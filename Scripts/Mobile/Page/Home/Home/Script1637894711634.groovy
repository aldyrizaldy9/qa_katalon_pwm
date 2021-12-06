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

//check if button login available
def loginCheck = Mobile.verifyElementExist(findTestObject('Object Repository/Mobile/Page/Login/Button - Login'), 4, FailureHandling.CONTINUE_ON_FAILURE)
if (loginCheck) {
	WebUI.callTestCase(findTestCase('Mobile/Page/Login/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

for (int i = 0; i<1; i++) {
	if (action == 'seeperformance') {
		TestObject daily = findTestObject('Object Repository/Mobile/Page/Home/Item - Daily Performance')
		CustomKeywords.'scroll.scroll.scrollScreenRightToLeft'(daily)
		
		Mobile.delay(2)
		break
	} else if (action == 'requestadhoc') {
		
		TestObject adhoc = findTestObject('Mobile/Page/Home/Button - Request Ad Hoc')
		int x = Mobile.getDeviceWidth()/2
		int y = Mobile.getElementTopPosition(adhoc, 0) + Mobile.getElementHeight(adhoc, 0) * 0.2
		System.out.println('x : ' + x)
		System.out.println('y : ' + y)
		Mobile.tapAtPosition(x, y)
		
		Mobile.delay(10)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Button - Open with Just Once'), 0)
		Mobile.delay(5)
		Mobile.pressBack()
		Mobile.delay(1)
		break
	} else if (action == 'addwatchlist') {
		Mobile.delay(2)
		try {
			TestObject itemWatchlist = findTestObject('Object Repository/Mobile/Page/Home/Item - Top Watchlist')
			
			def itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
			while (itemWatchlistExist) {
				CustomKeywords.'scroll.scroll.scrollRightToLeft'(itemWatchlist)
				Mobile.delay(2)
				itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		
		TestObject watchlist = findTestObject('Mobile/Page/Home/Container - Watchlist')
		int left_position = Mobile.getElementLeftPosition(watchlist, 0)
		int top_position = Mobile.getElementTopPosition(watchlist, 0)
		int width = Mobile.getElementWidth(watchlist, 0)
		int height = Mobile.getElementHeight(watchlist, 0)
		
		int x = left_position + width * 0.8
		int y = top_position + 52
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(2)
		
		//move to watchlist search page
		TestObject search = findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Input - Search')
		int x1 = Mobile.getElementLeftPosition(search, 0) + Mobile.getElementWidth(search, 0)/2
		int y1 = Mobile.getElementTopPosition(search, 0) + Mobile.getElementHeight(search, 0)/2
		Mobile.tapAtPosition(x1, y1)
		
		Mobile.delay(1)
		Mobile.setText(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Input - Search'), 'bb', 0)
		Mobile.hideKeyboard()
		
		Mobile.tapAndHold(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Item - Top Search'), 1, 0)
		Mobile.delay(2)
		
		//move to detail watchlist
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Input - Target Buy Sell'), 0)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Input - Target Buy Sell'), 0)
		Mobile.delay(1)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Input - Target Price'), 0)
		Mobile.delay(1)
		Mobile.setText(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Input - Target Price'), '100000', 0)
		Mobile.hideKeyboard()
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Input - Expiry Date'), 0)
		
		TestObject expiry = findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Input - Expiry Date')
		int x2 = Mobile.getElementLeftPosition(expiry, 0) + Mobile.getElementWidth(expiry, 0)/2
		int y2 = Mobile.getElementTopPosition(expiry, 0) + Mobile.getElementHeight(expiry, 0) * 0.8
		Mobile.tapAtPosition(x2, y2)
		
		Mobile.delay(1)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Scroll - Expiry Year'))
		Mobile.delay(2)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Scroll - Expiry Month'))
		Mobile.delay(2)
//		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Scroll - Expiry Date'))
//		Mobile.delay(2)
		
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Button - Expiry Done'), 0)
		Mobile.delay(1)
		Mobile.tap(findTestObject('Object Repository/Mobile/Page/Home/Watchlist/Detail Watchlist/Button - Add Watchlist'), 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		Mobile.pressBack()
		Mobile.delay(1)
	}
	
	if (page == 'notification') {
		//temporary solution to clear watchlist before opening notification
		Mobile.delay(2)
		try {
			TestObject itemWatchlist = findTestObject('Object Repository/Mobile/Page/Home/Item - Top Watchlist')
			
			def itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
			while (itemWatchlistExist) {
				CustomKeywords.'scroll.scroll.scrollRightToLeft'(itemWatchlist)
				Mobile.delay(2)
				itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		TestObject notif = findTestObject('Mobile/Page/Home/Container - Notification')

		int left_position = Mobile.getElementLeftPosition(notif, 0)
		int top_position = Mobile.getElementTopPosition(notif, 0)
		int width = Mobile.getElementWidth(notif, 0)
		int height = Mobile.getElementHeight(notif, 0)
			
		int x = left_position + width * 0.9
		int y = top_position + 52
			
		Mobile.tapAtPosition(x, y)
		Mobile.delay(2)
			
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
	} else if (page == 'itemnews') {
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		Mobile.tapAndHold(findTestObject('Mobile/Page/Home/Item - Top Latest News'), 1, 0)
		Mobile.delay(2)
		
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
	} else if (page == 'news') {
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		TestObject news = findTestObject('Mobile/Page/Home/Container - Latest News')
		
		int left_position = Mobile.getElementLeftPosition(news, 0)
		int top_position = Mobile.getElementTopPosition(news, 0)
		int width = Mobile.getElementWidth(news, 0)
		int height = Mobile.getElementHeight(news, 0)
					
		int x = left_position + width * 0.9
		int y = top_position + 52
					
		Mobile.tapAtPosition(x, y)
		Mobile.delay(2)

		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
	}
}
