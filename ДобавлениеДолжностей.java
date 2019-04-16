
import resources.��������������������Helper;
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
public class �������������������� extends ��������������������Helper
{
	/**
	 * Script Name   : <b>��������4</b>
	 * Generated     : <b>16 ���. 2019 �. 16:27:11</b>
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
		
		// Window: java.exe: ��������� ���������
		������������������window().click(atPoint(238,193));
		������������������window().inputKeys("{Num1}");
		������������������window().inputKeys("{Num4}{TAB}");
		������������������window().inputKeys("{Num8}{Num8}");
		������������������window().click(atPoint(315,331));
		
		DbConnection dbConnection = new DbConnection();
		dbConnection.getDbConnection();
		
		
		// �������� ��� ���������, ������� ���� � ��
        ArrayList<Position> allPosition = dbConnection.getAllPosition();
        System.out.println();

        // ���������� ����� ���������, � ���, ����� �� ���� ����������, ��� ����� ������, 
        // ��� � ������������ ������
        ArrayList<String> generateStrings = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            int len = (int)(Math.random() * 10) + 1;
            String str = getSaltString(len);
            boolean flagRepeat = false;
            // ���������, ���� �� ����� ��������
            for(int j = 0 ; j < allPosition.size(); j++){
                if( allPosition.get(j).getPosition().equals(str)) {
                    flagRepeat = true;
                }
            }
            // ���� ����� ��� �� ��������� � ������ ��� ��� � ��
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
// ��������� ����� ������
		// Window: java.exe: 
		for(int i = 0; i < generateStrings.size() ;i++){
			// ���� �� ���������
			glassWndClassGlassWindowClass3().click(atPoint(54,130));
			//���� �� ����������
			glassWndClassGlassWindowClass3().click(atPoint(543,173));
			//���� �� ���� �����
			glassWndClassGlassWindowClass3().click(atPoint(606,210));
			// ������� � ������
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}");
			//glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}");
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}" + generateStrings.get(i));
			//������ ��������
			glassWndClassGlassWindowClass3().click(atPoint(623,239));
		}
		glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		
		// Window: java.exe: ��������� ���������
		������������������window().click(atPoint(635,30));
		
		
		// ��������� ���������� �� ��� ������������		
		boolean flagLosePosition = false;
		for(int i = 0 ; i < generateStrings.size(); i++){
			int x = dbConnection.checkCurrentPosition(generateStrings.get(i));
			//System.out.println(x);
			if( x == 0)
				flagLosePosition = true;
		}
		if(flagLosePosition == false)
			System.out.println("��� ��, ��� ��������� ���������");
		else
			System.out.println("������, ����� �� ��������� ��������");
		// �������� �� ��
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

