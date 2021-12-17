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
Mobile.tap(findTestObject('Mobile/Page/Home/Menubar - Analysis'), 0)
Mobile.delay(1)

for (int i = 0; i<1; i++) {
	if (bug == 'report invalid') {
		Mobile.tap(findTestObject('Mobile/Page/Analysis/Tab - Research Report'), 0)
		Mobile.delay(1)
		Mobile.tapAndHold(findTestObject('Mobile/Page/Analysis/Item - Top Search'), 1, 0)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Analysis/Button - Open With Just Once'), 0)
		Mobile.delay(5)
		
		def verify = Mobile.verifyElementExist(findTestObject('Mobile/Page/Analysis/Item - Top Search'), 10)
		
		break
	}
}
