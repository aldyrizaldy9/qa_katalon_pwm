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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import groovy.json.internal.Exceptions
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidKeyCode

WebUI.callTestCase(findTestCase('Mobile/Page/CheckLogin'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(GlobalVariable.HOME_MenubarNews, 0)
Mobile.delay(3)

for (int i = 0; i < 1; i++) {
	if (tab == 'macronews') {
		Mobile.tap(GlobalVariable.NEWS_TabMacro, 0)
	} else if (tab == 'stocknews') {
		Mobile.tap(GlobalVariable.NEWS_TabStock, 0)
	} else if (tab == 'fundnews') {
		Mobile.tap(GlobalVariable.NEWS_TabFund, 0)
	} else if (tab == 'bondnews') {
		Mobile.tap(GlobalVariable.NEWS_TabBond, 0)
	} else if (tab == 'worldindices') {
		CustomKeywords.'scroll.scroll.scrollScreenRightToLeft'(GlobalVariable.NEWS_TabMacro)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NEWS_TabWorldIndices, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NEWS_BtnIndices, 0)
		Mobile.delay(3)
		Mobile.tap(GlobalVariable.NEWS_BtnCurrencies, 0)
		Mobile.delay(3)
		Mobile.tap(GlobalVariable.NEWS_BtnCommodities, 0)
		Mobile.delay(3)
	} else if (tab == 'search') {
		Mobile.tap(GlobalVariable.NEWS_BtnSearch, 0)
		Mobile.delay(5)
		Mobile.tap(GlobalVariable.NEWS_SEAR_EdtSearch, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.NEWS_SEAR_EdtSearch, 'flash', 0)
		
		AndroidDriver<?> driver = MobileDriverFactory.getDriver()
		driver.pressKeyCode(AndroidKeyCode.ENTER)
		Mobile.delay(5)
		
		Mobile.tapAndHold(GlobalVariable.NEWS_SEAR_ItemTopSearch, 1, 0)
		Mobile.delay(1)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		Mobile.delay(3)
	}
	
	Mobile.delay(1)
	
	if (tab != 'worldindices') {
		try {
			Mobile.tapAndHold(GlobalVariable.NEWS_ItemTopNews, 1, 10)
			Mobile.delay(1)
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(3)
		} catch (Exception e) {
			
		}
	}
}