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

for (int i = 0; i < 1; i++) {
    if (bug == 'fingerprint') {
        Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Login/Button - Fingerprint'), 1, 0)
        Mobile.delay(1)
        Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Login/Button - Touch Fingerprint'), 1, 0)
        Mobile.delay(5)

        def exist = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/Login/Error Indicator - Fingerprint'), 10)
		break
    } else if (bug == 'visible password') {
//		WebUI.callTestCase(findTestCase('Mobile/Page/Login/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.callTestCase(findTestCase('Mobile/Page/NavigationMenu/NavigationMenu'), [('action') : 'logout'], FailureHandling.CONTINUE_ON_FAILURE)
		
		Mobile.tap(findTestObject('Mobile/Page/Login/Input - Password'), 0)
		Mobile.delay(1)
		Mobile.setText(findTestObject('Mobile/Page/Login/Input Rdy - Password'), 'Shalawa18', 0)
		Mobile.delay(1)
		
		String invisible = Mobile.getAttribute(findTestObject('Object Repository/Mobile/Page/Login/Input Rdy - Password'), 'password', 10)
		Mobile.delay(1)
		if (invisible == 'true') {
			throw new StepErrorException('bug fixed')
		} else { }
		break
    }
}



