
import resources.—ценарий3Helper;
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

import java.sql.SQLException;

import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
/**
 * Description   : Functional Test Script
 * @author Dudoserg
 */
public class —ценарий3 extends —ценарий3Helper
{
	/**
	 * Script Name   : <b>—ценарий3</b>
	 * Generated     : <b>15 апр. 2019 г. 23:13:32</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 10.0  Build 17134 ()
	 * 
	 * @since  2019/04/15
	 * @author Dudoserg
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void testMain(Object[] args) throws ClassNotFoundException, SQLException 
	{
		DbConnection dbConnection = new DbConnection();
		dbConnection.print();
		dbConnection.getDbConnection();
		
		int result = dbConnection.checkUser("14", "88");
		System.out.println("result = " + result);
		
		int result2 = dbConnection.checkUser( "88", "14");
		System.out.println("result2 = " + result2);
		
		
		/*
		startApp("Lab8Bd");
		
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().click(atPoint(257,196));
		рекламноејгентствоwindow().inputChars("14");
		рекламноејгентствоwindow().click(atPoint(229,254));
		рекламноејгентствоwindow().inputChars("88");
		рекламноејгентствоwindow().click(atPoint(338,318));
		
		glassWndClassGlassWindowClass3().click(atPoint(722,172));
		// Window: java.exe: 
		for(int i = 0 ; i < 10 ; i++){
			
			glassWndClassGlassWindowClass3().click(atPoint(128,184));
			glassWndClassGlassWindowClass3().click(atPoint(644,243));
		}
		glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().click(atPoint(637,20));
		*/
		System.out.print("kek\n");
	}
}

