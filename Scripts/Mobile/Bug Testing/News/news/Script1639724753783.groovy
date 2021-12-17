import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidKeyCode

import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Mobile/Page/CheckLogin'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('Mobile/Page/Home/Menubar - News'), 0)
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (bug == 'indikator loading') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Button - Search'), 0)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/News/Search/Input - Search'), 0)
		Mobile.delay(1)
		Mobile.sendKeys(findTestObject('Object Repository/Mobile/Page/News/Search/Input - Search'), '-')
		
		AndroidDriver<?> driver = MobileDriverFactory.getDriver()
		driver.pressKeyCode(AndroidKeyCode.ENTER)
		Mobile.delay(10)
		
		def verify = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/News/Search/Error Indicator - Loading'), 10)
		break
	}
}