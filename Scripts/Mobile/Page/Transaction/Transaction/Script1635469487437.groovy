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

Mobile.delay(5)

def loginCheck = Mobile.verifyElementExist(findTestObject('null'), 2, FailureHandling.CONTINUE_ON_FAILURE)

if (loginCheck) {
	WebUI.callTestCase(findTestCase('Mobile/Page/Login/Login'), [
		('isLogin') : 0])
	
//    Mobile.tap(findTestObject('null'), 0)
//	Mobile.delay(1)
//    Mobile.tap(findTestObject('null'), 0)
//	Mobile.delay(1)
//	Mobile.setText(findTestObject('null'), 'ady.pangerang@gmail.com', 0)
//	Mobile.delay(1)
//	Mobile.tap(findTestObject('null'), 0)
//	Mobile.delay(1)
//	Mobile.setText(findTestObject('null'), 'Mirae1234', 0)
//	Mobile.delay(1)
//	Mobile.tap(findTestObject('null'), 0)
//    Mobile.delay(5)
}

if (page == 'cart') {
    WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)
}

Mobile.tap(findTestObject('null'), 0)
Mobile.delay(1)

if (page == 'onprocess') {
    if (tab == 'subscription') {
        Mobile.tap(findTestObject('null'), 0)
    } else if (tab == 'redemption') {
        Mobile.tap(findTestObject('null'), 0)
    } else if (tab == 'switching') {
        TestObject element = findTestObject('null')
		CustomKeywords.'scroll.scroll.scrollRightToLeft'(element)
        Mobile.tap(findTestObject('null'), 0)
    }
    
    if (action == 'detail') {
        Mobile.delay(4)

        if (tab == 'subscription') {
            Mobile.tapAndHold(findTestObject('null'), 1, 0)
        } else if (tab == 'redemption') {
            Mobile.tapAndHold(findTestObject('null'), 1, 0)
        } else if (tab == 'switching') {
            Mobile.tapAndHold(findTestObject('null'), 1, 0)
        } else {
            Mobile.tapAndHold(findTestObject('null'), 1, 0)
        }
        Mobile.delay(1)
		
		CustomKeywords.'scroll.scroll.scrollBottomToTop'()
    }
	
	Mobile.delay(1)
} else if (page == 'history') {
    Mobile.tap(findTestObject('null'), 0)

    if (action == 'detail') {
        Mobile.tapAndHold(findTestObject('null'), 1, 0)
		CustomKeywords.'scroll.scroll.scrollBottomToTop'()
	}
	
	Mobile.delay(1)
} else if (page == 'cart') {
    Mobile.tapAndHold(findTestObject('null'), 1, 0)

    if (action == 'deleteitem') {
        Mobile.tap(findTestObject('null'), 0)
    } else if (action == 'buyitem') {
        Mobile.tap(findTestObject('null'), 0)

        Mobile.tap(findTestObject('null'), 0)

        Mobile.tap(findTestObject('null'), 0)

        Mobile.delay(1)

        if (buymethod == 'rdn') {
            WebUI.callTestCase(findTestCase('null'), [('metodePembayaran') : 'Rekening Dana Nasabah'])
        } else if (buymethod == 'bca') {
            WebUI.callTestCase(findTestCase('null'), [('metodePembayaran') : 'VA BCA'])
        } else if (buymethod == 'bni') {
            WebUI.callTestCase(findTestCase('null'), [('metodePembayaran') : 'VA BNI'])
        } else if (buymethod == 'mandiri') {
            WebUI.callTestCase(findTestCase('null'), [('metodePembayaran') : 'VA Mandiri'])
        } else if (buymethod == 'permata') {
            WebUI.callTestCase(findTestCase('null'), [('metodePembayaran') : 'VA Permata'])
        } else if (buymethod == 'bri') {
            WebUI.callTestCase(findTestCase('null'), [('metodePembayaran') : 'VA BRI'])
        }
    }
	
	Mobile.delay(1)
} else if (page == 'notification') {
    Mobile.tapAndHold(findTestObject('null'), 1, 0)
    Mobile.delay(3)

    if (action == 'profile') {
        WebUI.callTestCase(findTestCase('null'), [('actionNotification') : 'Profile'])
    } else if (action == 'system') {
        WebUI.callTestCase(findTestCase('null'), [('actionNotification') : 'System'])
    } else if (action == 'transaction') {
        WebUI.callTestCase(findTestCase('null'), [('actionNotification') : 'Transaction'])
    } else if (action == 'promo') {
        WebUI.callTestCase(findTestCase('null'), [('actionNotification') : 'Promo'])
    } else if (action == 'event') {
        WebUI.callTestCase(findTestCase('null'), [('actionNotification') : 'Event'])
    } else if (action == 'tips') {
        WebUI.callTestCase(findTestCase('null'), [('actionNotification') : 'Tips'])
    }
	
	Mobile.delay(1)
}
