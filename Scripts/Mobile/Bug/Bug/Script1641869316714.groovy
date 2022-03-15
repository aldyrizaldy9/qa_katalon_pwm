import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.delay(2)

if (needlogin) {
	WebUI.callTestCase(findTestCase('Mobile/Page/CheckLogin'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

switch (bug) {
	case 'home - daily pertofolio performance tidak muncul' :
		Mobile.tap(GlobalVariable.HOME_MenubarPortfolio, 0)
		Mobile.delay(1)
		
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		def chart = Mobile.verifyElementExist(GlobalVariable.BUG_PORT_ChartDaily, 5)
		
		String text = Mobile.getText(GlobalVariable.BUG_PORT_ChartDaily, 0)
		
		boolean bug = text.contains("Chart will show when market open")
		
		if (!bug) {
			throw new Exception()
		}
	
		break
}
