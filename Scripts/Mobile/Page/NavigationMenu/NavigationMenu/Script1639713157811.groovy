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

WebUI.callTestCase(findTestCase('Mobile/Page/CheckLogin'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(3)
CustomKeywords.'scroll.scroll.scrollScreenLeftToRight'()
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (action == 'downloadtaxreport') {
		TestObject taxreport = findTestObject('Mobile/Page/NavigationMenu/Container - Yearly Tax Report')
		
		int top = Mobile.getElementTopPosition(taxreport, 0)
		int y = Mobile.getElementHeight(taxreport, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(5)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Button - Open Just Once'), 0)
		Mobile.delay(5)
		Mobile.pressBack()
	} else if (action == 'analyzeprofile') {
		TestObject risk = findTestObject('Mobile/Page/NavigationMenu/Container - Risk Profile')
		
		int top = Mobile.getElementTopPosition(risk, 0)
		int y = Mobile.getElementHeight(risk, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * ( 0.2)
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
		
		try {
			for (int j = 1; j <= 5; j++) {
				def bestsuited = Mobile.verifyElementExist(findTestObject('Mobile/Page/NavigationMenu/Container - Risk Profile'), 2)
					
				if (!bestsuited) {
					break
				}
				
				x = Mobile.getDeviceWidth() * ( 0.2 * j )
				
				Mobile.tapAtPosition(x, y)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		Random rand = new Random()
		
		int random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - How Long'))
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option How Long - 1 to 3'), 0)
		else
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option How Long - 3 to 5'), 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Investment Goal'))
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Investment Goal - Additional Income'), 0)
		else
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Investment Goal - Profit'), 0)
		Mobile.delay(1)

		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - General Knowledge'))
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option General Knowledge - Limited'), 0)
		else
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option General Knowledge - Quite Good'), 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Total Amount'))
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Total Amount - Between 10 and 20'), 0)
		else
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Total Amount - Between 20 and 30'), 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Investment Goal'))
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Risk Level - Low'), 0)
		else
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Risk Level - None'), 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Best Suited'))
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Best Suited - Bonds'), 0)
		else
			Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Best Suited - Security Deposit'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Button - Calculate Risk Profile'), 0)
		Mobile.delay(1)
		
		Mobile.pressBack()
	} else if (action == 'wa') {
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Button - Whatsapp'), 0)
		Mobile.delay(2)
	} else if (action == 'email') {
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Button - Email'), 0)
		Mobile.delay(2)
	} else if (action == 'setting') {
		TestObject setting = findTestObject('Mobile/Page/NavigationMenu/Button - Settings')
		
		int top = Mobile.getElementTopPosition(setting, 0)
		int y = Mobile.getElementHeight(setting, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Dropdown - Gain'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Option Gain - 5'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Gain'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Gain'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Dropdown - Loss'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Option Loss - 5'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Loss'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Loss'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Checkbox - Risk Tolerance'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Checkbox - Risk Tolerance'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Stock News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Stock News'), 0)
		Mobile.delay(1)

		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Fund News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Fund News'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Bond News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Bond News'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Macro News'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Settings/Switch - Macro News'), 0)
		Mobile.delay(1)
		
		Mobile.pressBack()
		Mobile.delay(1)
	} else if (action == 'logout') {
		TestObject logout = findTestObject('Mobile/Page/NavigationMenu/Container - Logout')
		
		int top = Mobile.getElementTopPosition(logout, 0)
		int y = Mobile.getElementHeight(logout, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
	}
}