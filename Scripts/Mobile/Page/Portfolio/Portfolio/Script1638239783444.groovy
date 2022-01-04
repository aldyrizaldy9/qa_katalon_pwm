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

WebUI.callTestCase(findTestCase('Mobile/Page/CheckLogin'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(GlobalVariable.HOME_MenubarPortfolio, 0)
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (tab == 'summary') {
		TestObject idr = GlobalVariable.PORT_BtnIDR
		TestObject persen = GlobalVariable.PORT_BtnPersen
		
		if (action == 'summary') {
			Mobile.delay(3)
		} else if (action == 'perf_daily') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		} else if (action == 'perf_month') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(1)
			Mobile.tap(GlobalVariable.PORT_TabSummaryMonth, 0)
		} else if (action == 'perf_quarter') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(1)
			Mobile.tap(GlobalVariable.PORT_TabSummaryQuarter, 0)
		} else if (action == 'perf_year') {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(1)
			Mobile.tap(GlobalVariable.PORT_TabSummaryYear, 0)
		}
		
		if (action != 'summary') {
			Mobile.delay(1)
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			Mobile.delay(3)
			if (action2 == 'idr') {
				Mobile.tap(idr, 10)
				Mobile.delay(3)
			} else if (action2 == 'persen') {
				Mobile.tap(persen, 10)
				Mobile.delay(3)
			}
		}
	} else if (tab == 'stock') {
		Mobile.tap(GlobalVariable.PORT_TabStock, 0)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		Mobile.delay(3)
	} else if (tab == 'mutualfund') {
		Mobile.tap(GlobalVariable.PORT_TabMutualFund, 0)
		Mobile.delay(1)
		
		try {
			Mobile.tapAndHold(GlobalVariable.PORT_ItemTopMutualFund, 1, 10)
			Mobile.delay(2)
			
			switch (action2) {
				case '1 month':
					Mobile.tapAndHold(GlobalVariable.PORT_DETL_Btn1Month, 1, 0)
					break
				case '3 month' :
					Mobile.tapAndHold(GlobalVariable.PORT_DETL_Btn3Month, 1, 0)
					break
				case '6 month' :
					Mobile.tapAndHold(GlobalVariable.PORT_DETL_Btn6Month, 1, 0)
					break
				case '1 year' :
					Mobile.tapAndHold(GlobalVariable.PORT_DETL_Btn1Year, 1, 0)
					break
				case '3 year' :
					Mobile.tapAndHold(GlobalVariable.PORT_DETL_Btn3Year, 1, 0)
					break
				case '5 year' :
					Mobile.tapAndHold(GlobalVariable.PORT_DETL_Btn5Year, 1, 0)
					break
				case '10 year' :
					Mobile.tapAndHold(GlobalVariable.PORT_DETL_Btn10Year, 1, 0)
					break
			}
			
			Mobile.delay(3)
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
			
		} catch (Exception e) {
			CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		}
	} else if (tab == 'bond') {
		Mobile.tap(GlobalVariable.PORT_TabBond, 0)
		CustomKeywords.'scroll.scroll.scrollScreenBottomToTop'()
		Mobile.delay(3)
	}
}