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

Mobile.tap(GlobalVariable.HOME_MenubarAnalysis, 0)
Mobile.delay(3)

for (int i = 0; i < 1; i++) {
	if (action == 'technicalsearch') {
		Mobile.tap(GlobalVariable.ANAL_DropTechIndicator, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.ANAL_OptTechIndicatorAll, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.ANAL_DropMarketCap, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.ANAL_OptMarketCap1T, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.ANAL_DropTransaction, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.ANAL_OptTransaction10B, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.ANAL_DropTimeFrame, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.ANAL_OptTimeFrameDaily, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.ANAL_DropIndex, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.ANAL_OptIndexIdx30, 0)
		Mobile.delay(2)
	
	} else if (action == 'technicaldetail') {
		Mobile.tapAndHold(GlobalVariable.ANAL_ItemTopResultTech, 1, 0)
		Mobile.delay(5)
		
		switch (action2) {
			case 'day' :
//				Mobile.tap(GlobalVariable.ANAL_DETL_BtnD, 0)
				Mobile.tapAndHold(GlobalVariable.ANAL_DETL_BtnD, 1, 0)
				break
			case 'week' :
//				Mobile.tap(GlobalVariable.ANAL_DETL_BtnW, 0)
				Mobile.tapAndHold(GlobalVariable.ANAL_DETL_BtnW, 1, 0)
				break
			case 'month' :
//				Mobile.tap(GlobalVariable.ANAL_DETL_BtnM, 0)
				Mobile.tapAndHold(GlobalVariable.ANAL_DETL_BtnM, 1, 0)
				break
			case 'year' :
//				Mobile.tap(GlobalVariable.ANAL_DETL_BtnY, 0)
				Mobile.tapAndHold(GlobalVariable.ANAL_DETL_BtnY, 1, 0)
				break
		}
		
		Mobile.delay(2)
	} else if (action == 'researchdetail') {
		Mobile.tap(GlobalVariable.ANAL_TabResearchReport, 0)
		Mobile.delay(1)
		
		Mobile.tapAndHold(GlobalVariable.ANAL_ItemTopSearch, 1, 0)
		Mobile.delay(3)
		
		Mobile.pressBack()
	} else if (action == 'researchsearch') {
		Mobile.tap(GlobalVariable.ANAL_TabResearchReport, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.ANAL_EdtSearch, 0)
		Mobile.delay(1)
		Mobile.setText(GlobalVariable.ANAL_EdtSearch, 'embun', 0)
		Mobile.hideKeyboard()
		
		Mobile.tapAndHold(GlobalVariable.ANAL_ItemTopSearch, 1, 0)
		Mobile.delay(3)

		Mobile.pressBack()
	}
}