
import resources.”далениеHelper;
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

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Description   : Functional Test Script
 * @author Dudoserg
 */
public class ”даление extends ”далениеHelper
{
	/**
	 * Script Name   : <b>”даление</b>
	 * Generated     : <b>16 апр. 2019 г. 22:07:22</b>
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
		
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().inputChars("14");
		рекламноејгентствоwindow().click(atPoint(273,258));
		рекламноејгентствоwindow().inputChars("88");
		рекламноејгентствоwindow().click(atPoint(324,329));
		
		// Window: java.exe: 
		glassWndClassGlassWindowClass3().click(atPoint(719,178));

		
		
		DbConnection dbConnection = new DbConnection();
		dbConnection.getDbConnection();
        ArrayList<Position> positions = dbConnection.getAllPosition();

        
        // оставл€ем в списке 5 рандомных записей
        int countForDelete = 5;
        int size = positions.size() - countForDelete;
        for(int i = 0 ; i < size; i++){
            positions.remove((int) (Math.random() * positions.size()));
        }
        for(int i = 0 ; i < positions.size(); i++){
        	System.out.println(positions.get(i).getId() + "   " + positions.get(i).getPosition());
        }

        // удал€ем записи
        for(int i = 0 ; i < positions.size(); i++){	
			// клик в поле
			glassWndClassGlassWindowClass3().click(atPoint(618,214));
			// ввод
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}");
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}" + positions.get(i).getId());
			System.out.println(positions.get(i).getId());
			//кнопка удалить
			glassWndClassGlassWindowClass3().click(atPoint(647,244));		
        }
        glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().click(atPoint(624,27));
		
		//“еперь проверим, есть ли такие записи в бд
		
		// ѕровер€ем добавились ли все пользователи		
		boolean flagNOTdelete = false;
		for(int i = 0 ; i < positions.size(); i++){
			int x = dbConnection.checkCurrentPosition(positions.get(i).getPosition());
			//System.out.println(x);
			if( x == 1)
				flagNOTdelete = true;
		}
		if( flagNOTdelete == false)
			System.out.println("¬се удалилось");
		else
			System.out.println("не все удалилось");
	}
}


























