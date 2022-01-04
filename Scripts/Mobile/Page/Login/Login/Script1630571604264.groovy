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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Keys as Keys

Mobile.delay(2)

for (int i = 0; i<1; i++) {
	if (action == 'username') {
		Mobile.tap(GlobalVariable.LOGN_EdtUserID, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyUserID, 'anggaaditya', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_EdtPassword, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyPassword, 'Shalawa18', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_BtnLogin, 0)
		Mobile.delay(2)
		
		break
	} else if (action == 'wrongpassword') {
		Mobile.tap(GlobalVariable.LOGN_EdtUserID, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyUserID, 'anggaaditya', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_EdtPassword, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyPassword, 'Shalawa181', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_BtnLogin, 0)
		Mobile.delay(2)
		
		def verify = Mobile.verifyElementExist(GlobalVariable.LOGN_AlertInvalidCredentials, 5, FailureHandling.STOP_ON_FAILURE)
		
		break
	} else if (action == 'nointernet') {
		CustomKeywords.'scroll.scroll.scrollNotificationBar'()
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.OTHR_BtnWifi, 0)
		Mobile.delay(1)
		Mobile.pressBack()
		
		Mobile.tap(GlobalVariable.LOGN_EdtUserID, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyUserID, 'anggaaditya', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_EdtPassword, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyPassword, 'Shalawa18', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_BtnLogin, 0)
		Mobile.delay(2)
		
		def verify = Mobile.verifyElementExist(GlobalVariable.LOGN_AlertCheckYourNetwork, 5, FailureHandling.STOP_ON_FAILURE)
		
		CustomKeywords.'scroll.scroll.scrollNotificationBar'()
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.OTHR_BtnWifi, 0)
		Mobile.delay(1)
		Mobile.pressBack()
		
		break
	} else if (action == 'visiblepassword') {
		Mobile.tap(GlobalVariable.LOGN_EdtUserID, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyUserID, 'anggaaditya', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		int top = Mobile.getElementTopPosition(GlobalVariable.LOGN_EdtPassword, 0)
		int left = Mobile.getElementLeftPosition(GlobalVariable.LOGN_EdtPassword, 0)
		int x = left + Mobile.getElementWidth(GlobalVariable.LOGN_EdtPassword, 0) * 0.9
		int y = top + Mobile.getElementHeight(GlobalVariable.LOGN_EdtPassword, 0) / 2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.LOGN_EdtPassword, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyPassword, 'Shalawa18', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_BtnLogin, 0)
		Mobile.delay(2)
		
		break
	} else if (action == 'cancelfingerprint') {
		Mobile.tap(GlobalVariable.LOGN_BtnFingerprint, 0)
		Mobile.delay(1)
		Mobile.pressBack()
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.LOGN_EdtUserID, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyUserID, 'anggaaditya', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_EdtPassword, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.LOGN_EdtRdyPassword, 'Shalawa18', 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.LOGN_BtnLogin, 0)
		Mobile.delay(2)
	}
}