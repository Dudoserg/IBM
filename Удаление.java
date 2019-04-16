
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
		
		DbConnection dbConnection = new DbConnection();
		dbConnection.getDbConnection();
		ArrayList<Position> positions = dbConnection.getAllPosition();
		
		
		
		// Window: java.exe: 
		glassWndClassGlassWindowClass3().click(atPoint(719,178));

	
		
		
		// клик в поле
		glassWndClassGlassWindowClass3().click(atPoint(618,214));
		// ввод
		glassWndClassGlassWindowClass3().inputKeys("^ф{BKSP}84");
		//кнопка удалить
		glassWndClassGlassWindowClass3().click(atPoint(647,244));
		glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().click(atPoint(624,27));
	}
}

