import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepErrorException
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

for (int i = 0; i<1; i++) {
	if (bug == 'wa') {
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Button - Whatsapp'), 0)
		Mobile.delay(5)
		
		def verify = Mobile.verifyElementExist(findTestObject('Mobile/Page/NavigationMenu/Button - Whatsapp'), 0)
		break
	} else if (bug == 'dropdown tidak berubah') {
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
		
		String content = Mobile.getAttribute(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Investment Goal'), 'content-desc', y)
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Investment Goal'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Investment Goal - Additional Income'), 0)
		Mobile.delay(1)
		
		String content2 = Mobile.getAttribute(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Investment Goal'), 'content-desc', y)
		
		if (content != content2) {
			throw new StepErrorException('bug fixed')
		}
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Button - Calculate Risk Profile'), 0)
		Mobile.delay(1)
		
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Dropdown - Investment Goal'))
		Mobile.delay(1)
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Option Investment Goal - Profit'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Risk Profile/Button - Calculate Risk Profile'), 0)
		Mobile.delay(1)
		
		break
	}
}