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

for (int i = 0; i<1; i++) {
	if (action == 'seeperformance') {
		CustomKeywords.'scroll.scroll.scrollScreenRightToLeft'(GlobalVariable.HOME_ItemDailyPerf)
		
		Mobile.delay(2)
		break
	} else if (action == 'requestadhoc') {
		
		TestObject adhoc = GlobalVariable.HOME_BtnRequestAdHoc
		int x = Mobile.getDeviceWidth()/2
		int y = Mobile.getElementTopPosition(adhoc, 0) + Mobile.getElementHeight(adhoc, 0) * 0.2
		System.out.println('x : ' + x)
		System.out.println('y : ' + y)
		Mobile.tapAtPosition(x, y)
		
		Mobile.delay(10)
		Mobile.pressBack()
		Mobile.delay(1)
		break
	} else if (action == 'addwatchlist' || action == 'deletewatchlist') {
		Mobile.delay(2)
		try {
			TestObject itemWatchlist = GlobalVariable.HOME_ItemTopWatchlist
			
			def itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
			while (itemWatchlistExist) {
				CustomKeywords.'scroll.scroll.scrollRightToLeft'(itemWatchlist)
				Mobile.delay(2)
				itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		
		TestObject watchlist = GlobalVariable.HOME_ContWatchlist
		int left_position = Mobile.getElementLeftPosition(watchlist, 0)
		int top_position = Mobile.getElementTopPosition(watchlist, 0)
		int width = Mobile.getElementWidth(watchlist, 0)
		int height = Mobile.getElementHeight(watchlist, 0)
		
		int x = left_position + width * 0.9
		int y = top_position + 52
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(2)
		
		Mobile.tap(GlobalVariable.HOME_WCTL_FabAdd, 0)
		Mobile.delay(1)
		
		TestObject search = GlobalVariable.HOME_WCTL_DETL_ContSearch
		int x1 = Mobile.getElementLeftPosition(search, 0) + Mobile.getElementWidth(search, 0) / 2
		int y1 = Mobile.getElementTopPosition(search, 0) + Mobile.getElementHeight(search, 0) * 0.8
		Mobile.tapAtPosition(x1, y1)
		
		Mobile.setText(GlobalVariable.HOME_WCTL_DETL_EdtSearchStock, 'bb', 0)
		Mobile.delay(1)
		Mobile.tapAndHold(GlobalVariable.HOME_WCTL_DETL_ItemTopSearch, 1, 0)
		Mobile.delay(1)
		
		//move to detail watchlist
		Mobile.tap(GlobalVariable.HOME_WCTL_DETL_EdtTargetBuySell, 0)
		Mobile.tap(GlobalVariable.HOME_WCTL_DETL_EdtTargetBuySell, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.HOME_WCTL_DETL_EdtTargetPrice, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.HOME_WCTL_DETL_EdtTargetPrice, '100000', 0)
		Mobile.hideKeyboard()
		
		Mobile.tap(GlobalVariable.HOME_WCTL_DETL_EdtExpiryDate, 0)
		
		TestObject expiry = GlobalVariable.HOME_WCTL_DETL_ContExpiryDate
		int x2 = Mobile.getElementLeftPosition(expiry, 0) + Mobile.getElementWidth(expiry, 0)/2
		int y2 = Mobile.getElementTopPosition(expiry, 0) + Mobile.getElementHeight(expiry, 0) * 0.8
		Mobile.tapAtPosition(x2, y2)
		
		Mobile.delay(1)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'(GlobalVariable.HOME_WCTL_DETL_ScrollExpiryYear)
		Mobile.delay(2)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'(GlobalVariable.HOME_WCTL_DETL_ScrollExpiryMonth)
		Mobile.delay(2)
		
		Mobile.tap(GlobalVariable.HOME_WCTL_DETL_BtnExpiryDone, 0)
		Mobile.delay(1)
		
		
		Mobile.tap(GlobalVariable.HOME_WCTL_DETL_BtnAddWatchlist, 0)
		Mobile.delay(1)
		Mobile.hideKeyboard()
		Mobile.pressBack()
		Mobile.delay(1)
		
		try {
			TestObject itemWatchlist = GlobalVariable.HOME_ItemTopWatchlist
			
			def itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
			while (itemWatchlistExist) {
				CustomKeywords.'scroll.scroll.scrollRightToLeft'(itemWatchlist)
				Mobile.delay(2)
				itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
	} else if (action == 'addwatchlistnoinput') {
		Mobile.delay(2)
		try {
			TestObject itemWatchlist = GlobalVariable.HOME_ItemTopWatchlist
			
			def itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
			while (itemWatchlistExist) {
				CustomKeywords.'scroll.scroll.scrollRightToLeft'(itemWatchlist)
				Mobile.delay(2)
				itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		TestObject watchlist = GlobalVariable.HOME_ContWatchlist
		int left_position = Mobile.getElementLeftPosition(watchlist, 0)
		int top_position = Mobile.getElementTopPosition(watchlist, 0)
		int width = Mobile.getElementWidth(watchlist, 0)
		int height = Mobile.getElementHeight(watchlist, 0)
		
		int x = left_position + width * 0.9
		int y = top_position + 52
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(2)
		
		Mobile.tap(GlobalVariable.HOME_WCTL_FabAdd, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.HOME_WCTL_DETL_BtnAddWatchlist, 0)
		Mobile.delay(1)
		
		def verify = Mobile.verifyElementExist(GlobalVariable.HOME_WCTL_DETL_AlertFillinput, 5)
		
		break
	} else if (action == 'deletewatchlist') {
		
	}
	
	if (page == 'notification') {
		//temporary solution to clear watchlist before opening notification
		Mobile.delay(2)
		try {
			TestObject itemWatchlist = GlobalVariable.HOME_ItemTopWatchlist
			
			def itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
			while (itemWatchlistExist) {
				CustomKeywords.'scroll.scroll.scrollRightToLeft'(itemWatchlist)
				Mobile.delay(2)
				itemWatchlistExist = Mobile.verifyElementExist(itemWatchlist, 2)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		TestObject notif = GlobalVariable.HOME_ContNotification

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
		
		Mobile.tapAndHold(GlobalVariable.HOME_ItemTopLatestNews, 1, 0)
		Mobile.delay(2)
		
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
	} else if (page == 'news') {
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		
		TestObject news = GlobalVariable.HOME_ContLatestNews
		
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
