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

//check if button login available
def loginCheck = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/Login/Button - Login'), 2, FailureHandling.CONTINUE_ON_FAILURE)
if (loginCheck) {
	WebUI.callTestCase(findTestCase('Mobile/Page/Login/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

CustomKeywords.'scroll.scroll.scrollScreenLeftToRight'()
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (action == 'downloadtaxreport') {
		TestObject taxreport = findTestObject('Object Repository/Mobile/Page/Profile/Container - Yearly Tax Report')
		
		int top = Mobile.getElementTopPosition(taxreport, 0)
		int y = Mobile.getElementHeight(taxreport, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Button - Open Just Once'), 0)
		Mobile.delay(5)
	} else if (action == 'analyzeprofile') {
		TestObject risk = findTestObject('Object Repository/Mobile/Page/Profile/Container - Risk Profile 2')
		
		int top = Mobile.getElementTopPosition(risk, 0)
		int y = Mobile.getElementHeight(risk, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * ( 0.2)
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
		
		try {
			for (int j = 1; j <= 5; j++) {
				def bestsuited = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/Profile/Container - Risk Profile 2'), 2)
					
				if (!bestsuited) {
					break
				}
				
				x = Mobile.getDeviceWidth() * ( 0.2 * j )
				
				Mobile.tapAtPosition(x, y)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Dropdown - How Long 2'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Option How Long - 1 to 3'), 0)
		Mobile.delay(1)
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Dropdown - Investment Goal'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Option Investment Goal - Additional Income'), 0)
		Mobile.delay(1)
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Dropdown - General Knowledge'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Option General Knowledge - Good'), 0)
		Mobile.delay(1)
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Dropdown - Total Amount'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Option Total Amount - Between 10 and 20'), 0)
		Mobile.delay(1)
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Dropdown - Investment Goal'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Option Risk Level - High'), 0)
		Mobile.delay(1)
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Dropdown - Best Suited'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Option Best Suited - Bonds'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Risk Profile/Button - Calculate Risk Profile'), 0)
		Mobile.delay(1)
		
		Mobile.pressBack()
	} else if (action == 'wa') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Button - Whatsapp'), 0)
		Mobile.delay(2)
	} else if (action == 'email') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Button - Email'), 0)
		Mobile.delay(2)
	} else if (action == 'setting') {
		TestObject setting = findTestObject('Object Repository/Mobile/Page/Profile/Button - Settings')
		
		int top = Mobile.getElementTopPosition(setting, 0)
		int y = Mobile.getElementHeight(setting, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Dropdown - Gain'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Option Gain - 5'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Gain'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Gain'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Dropdown - Loss'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Option Loss - 5'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Loss'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Loss'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Checkbox - Risk Tolerance'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Checkbox - Risk Tolerance'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Stock News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Stock News'), 0)
		Mobile.delay(1)

		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Fund News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Fund News'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Bond News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Bond News'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Macro News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Profile/Settings/Switch - Macro News'), 0)
		Mobile.delay(1)
		
		Mobile.pressBack()
		Mobile.delay(1)
	}
}