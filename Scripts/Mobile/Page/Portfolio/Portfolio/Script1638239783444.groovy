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

import groovy.json.internal.Exceptions
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//check if button login available
def loginCheck = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/Login/Button - Login'), 2, FailureHandling.CONTINUE_ON_FAILURE)
if (loginCheck) {
	WebUI.callTestCase(findTestCase('Mobile/Page/Login/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Menubar - Portfolio'), 0)
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (tab == 'summary') {
		if (action == 'summary') {
			Mobile.delay(3)
		} else if (action == 'perf_daily') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(1)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - IDR'), 0)
			Mobile.delay(3)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - Persen'), 0)
			Mobile.delay(3)
		} else if (action == 'perf_month') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(1)
			Mobile.tap(findTestObject('Object Repository/Mobile/Page/Portfolio/Button - Tab Month to Date'), 0)
			Mobile.delay(1)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - IDR'), 0)
			Mobile.delay(3)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - Persen'), 0)
			Mobile.delay(3)
		} else if (action == 'perf_quarter') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(1)
			Mobile.tap(findTestObject('Object Repository/Mobile/Page/Portfolio/Button - Tab Quarter to Date'), 0)
			Mobile.delay(1)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - IDR'), 0)
			Mobile.delay(3)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - Persen'), 0)
			Mobile.delay(3)
		} else if (action == 'perf_year') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(1)
			Mobile.tap(findTestObject('Object Repository/Mobile/Page/Portfolio/Button - Tab Year to Date'), 0)
			Mobile.delay(1)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - IDR'), 0)
			Mobile.delay(3)
			Mobile.tap(findTestObject('Mobile/Page/Portfolio/Button - Persen'), 0)
			Mobile.delay(3)
		}
	} else if (tab == 'stock') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Portfolio/Tab - Stock'), 0)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		Mobile.delay(3)
	} else if (tab == 'mutualfund') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Portfolio/Tab - Mutual Fund'), 0)
		Mobile.delay(1)
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Item - Top Mutual Fund'), 1, 0)
		Mobile.delay(2)
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Detail Mutual Funds/Button - 1 Month'), 1, 0)
		Mobile.delay(3)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Detail Mutual Funds/Button - 3 Month'), 1, 0)
		Mobile.delay(3)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Detail Mutual Funds/Button - 6 Month'), 1, 0)
		Mobile.delay(3)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Detail Mutual Funds/Button - 1 Year'), 1, 0)
		Mobile.delay(3)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Detail Mutual Funds/Button - 3 Year'), 1, 0)
		Mobile.delay(3)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Detail Mutual Funds/Button - 5 Year'), 1, 0)
		Mobile.delay(3)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Portfolio/Detail Mutual Funds/Button - 10 Year'), 1, 0)
		Mobile.delay(3)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
	} else if (tab == 'bond') {
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Portfolio/Tab - Bond'), 0)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		Mobile.delay(3)
	}
}