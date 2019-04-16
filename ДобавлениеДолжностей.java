
import resources.ДобавлениеДолжностейHelper;
import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
import com.ibm.xtq.common.utils.Assert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Description   : Functional Test Script
 * @author Dudoserg
 */
public class ДобавлениеДолжностей extends ДобавлениеДолжностейHelper
{
	/**
	 * Script Name   : <b>Сценарий4</b>
	 * Generated     : <b>16 апр. 2019 г. 16:27:11</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 10.0  Build 17134 ()
	 * 
	 * @since  2019/04/16
	 * @author Dudoserg
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void testMain(Object[] args) throws ClassNotFoundException, SQLException 
	{
		startApp("Lab8Bd");
		
		// Window: java.exe: Рекламное агентство
		рекламноеАгентствоwindow().click(atPoint(238,193));
		рекламноеАгентствоwindow().inputKeys("{Num1}");
		рекламноеАгентствоwindow().inputKeys("{Num4}{TAB}");
		рекламноеАгентствоwindow().inputKeys("{Num8}{Num8}");
		рекламноеАгентствоwindow().click(atPoint(315,331));
		
		DbConnection dbConnection = new DbConnection();
		dbConnection.getDbConnection();
		
		
		// Получаем все должности, которые есть в бд
        ArrayList<Position> allPosition = dbConnection.getAllPosition();
        System.out.println();

        // Генерируем новые должности, и так, чтобы не было повторение, как между новыми, 
        // так и относительно старых
        ArrayList<String> generateStrings = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            int len = (int)(Math.random() * 10) + 1;
            String str = getSaltString(len);
            boolean flagRepeat = false;
            // Проверяем, была ли такая долность
            for(int j = 0 ; j < allPosition.size(); j++){
                if( allPosition.get(j).getPosition().equals(str)) {
                    flagRepeat = true;
                }
            }
            // Если такое еще не сгенерили И такого еще нет в бд
            if( generateStrings.contains(str) == false && flagRepeat == false ){
                generateStrings.add(str);
            }
            else{
                i--;
            }
        }
        System.out.println();
        for(int i = 0 ; i < generateStrings.size(); i++){
            System.out.println(generateStrings.get(i));
        }
        System.out.println();
// Добавляем новых юзеров
		// Window: java.exe: 
		for(int i = 0; i < generateStrings.size() ;i++){
			// клик на должность
			glassWndClassGlassWindowClass3().click(atPoint(54,130));
			//клик на добавление
			glassWndClassGlassWindowClass3().click(atPoint(543,173));
			//клик на поле ввода
			glassWndClassGlassWindowClass3().click(atPoint(606,210));
			// стираем и вводим
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}");
			//glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}");
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}" + generateStrings.get(i));
			//кнопка добавить
			glassWndClassGlassWindowClass3().click(atPoint(623,239));
		}
		glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		
		// Window: java.exe: Рекламное агентство
		рекламноеАгентствоwindow().click(atPoint(635,30));
		
		
		// Проверяем добавились ли все пользователи		
		boolean flagLosePosition = false;
		for(int i = 0 ; i < generateStrings.size(); i++){
			int x = dbConnection.checkCurrentPosition(generateStrings.get(i));
			//System.out.println(x);
			if( x == 0)
				flagLosePosition = true;
		}
		if(flagLosePosition == false)
			System.out.println("Все ок, все должности добавлены");
		else
			System.out.println("Ошибка, какую то должность потеряли");
		// Удаление из бд
		for(int i = 0 ; i < generateStrings.size(); i++){
			dbConnection.delCurPos(generateStrings.get(i));
		}
		
		assert flagLosePosition == true;
	}
	protected String getSaltString(int len) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}

