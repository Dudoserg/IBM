
import resources.—ценарий1Helper;
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
/**
 * Description   : Functional Test Script
 * @author Dudoserg
 */
public class —ценарий1 extends —ценарий1Helper
{
	/**
	 * Script Name   : <b>—ценарий1</b>
	 * Generated     : <b>15 апр. 2019 г. 23:02:29</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 10.0  Build 17134 ()
	 * 
	 * @since  2019/04/15
	 * @author Dudoserg
	 */
	public void testMain(Object[] args) 
	{
		startApp("Lab8Bd");
		
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().click(atPoint(247,201));
		рекламноејгентствоwindow().inputKeys("{Num1}{Num4}");
		рекламноејгентствоwindow().click(atPoint(257,244));
		рекламноејгентствоwindow().inputKeys("{Num8}{Num8}");
		рекламноејгентствоwindow().click(atPoint(358,337));
		
		// Window: java.exe: 
		glassWndClassGlassWindowClass3().click(atPoint(625,205));
		glassWndClassGlassWindowClass3().inputChars("йцу");
		glassWndClassGlassWindowClass3().click(atPoint(627,241));
		glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().click(atPoint(628,27));
	}
}

