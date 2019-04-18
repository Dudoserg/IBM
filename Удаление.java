
import resources.��������Helper;
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
public class �������� extends ��������Helper
{
	/**
	 * Script Name   : <b>��������</b>
	 * Generated     : <b>16 ���. 2019 �. 22:07:22</b>
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
		������������������window().inputChars("14");
		������������������window().click(atPoint(273,258));
		������������������window().inputChars("88");
		������������������window().click(atPoint(324,329));
		
		// Window: java.exe: 
		glassWndClassGlassWindowClass3().click(atPoint(719,178));

		
		
		DbConnection dbConnection = new DbConnection();
		dbConnection.getDbConnection();
        ArrayList<Position> positions = dbConnection.getAllPosition();

        
        // ��������� � ������ 5 ��������� �������
        int countForDelete = 5;
        int size = positions.size() - countForDelete;
        for(int i = 0 ; i < size; i++){
            positions.remove((int) (Math.random() * positions.size()));
        }
        for(int i = 0 ; i < positions.size(); i++){
        	System.out.println(positions.get(i).getId() + "   " + positions.get(i).getPosition());
        }

        // ������� ������
        for(int i = 0 ; i < positions.size(); i++){	
			// ���� � ����
			glassWndClassGlassWindowClass3().click(atPoint(618,214));
			// ����
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}");
			glassWndClassGlassWindowClass3().inputKeys("^a{BKSP}" + positions.get(i).getId());
			System.out.println(positions.get(i).getId());
			//������ �������
			glassWndClassGlassWindowClass3().click(atPoint(647,244));		
        }
        glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		// Window: java.exe: ��������� ���������
		������������������window().click(atPoint(624,27));
		
		//������ ��������, ���� �� ����� ������ � ��
		
		// ��������� ���������� �� ��� ������������		
		boolean flagNOTdelete = false;
		for(int i = 0 ; i < positions.size(); i++){
			int x = dbConnection.checkCurrentPosition(positions.get(i).getPosition());
			//System.out.println(x);
			if( x == 1)
				flagNOTdelete = true;
		}
		if( flagNOTdelete == false)
			System.out.println("��� ���������");
		else
			System.out.println("�� ��� ���������");
	}
}


























