
import resources.—ценарий2Helper;
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
public class —ценарий2 extends —ценарий2Helper
{
	/**
	 * Script Name   : <b>—ценарий2</b>
	 * Generated     : <b>15 апр. 2019 г. 23:05:52</b>
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
		рекламноејгентствоwindow().click(atPoint(244,208));
		рекламноејгентствоwindow().inputKeys("{Num4}");
		рекламноејгентствоwindow().click(atPoint(251,257));
		рекламноејгентствоwindow().inputKeys("{Num8}{Num8}");
		рекламноејгентствоwindow().click(atPoint(343,326));
		
		// Window: java.exe: 
		glassWndClassGlassWindowClass3().click(atPoint(610,211));
		glassWndClassGlassWindowClass3().inputChars("кек");
		glassWndClassGlassWindowClass3().click(atPoint(631,240));
		glassWndClassGlassWindowClass3().click(atPoint(148,338));
		glassWndClassGlassWindowClass3().doubleClick(atPoint(139,337));
		glassWndClassGlassWindowClass3().inputKeys("^с");
		glassWndClassGlassWindowClass3().click(atPoint(130,359));
		glassWndClassGlassWindowClass3(ANY,MAY_EXIT).click(CLOSE_BUTTON);
		
		// Window: java.exe: –екламное агентство
		рекламноејгентствоwindow().click(atPoint(629,26));
	}
}

