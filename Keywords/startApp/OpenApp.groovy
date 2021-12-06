package startApp

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.MobileElement

import internal.GlobalVariable

public class OpenApp {
	@Keyword
	def startApplication(String appId) {
		Mobile.startExistingApplication(appId)
	}
	@Keyword
	def terminateApplication() {
		AndroidDriver<MobileElement> driver = MobileDriverFactory.getDriver()
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH))
		Mobile.delay(3)

		int width = Mobile.getDeviceWidth()
		int height = Mobile.getDeviceHeight()

		int startX = width / 2
		int startY = height * 0.6
		int endX = width / 2
		int endY = height * 0.1

		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(1)
		Mobile.swipe(startX, startY, endX, endY)

		//		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Button - Close all application'), 0)
		Mobile.delay(3)
	}
}

