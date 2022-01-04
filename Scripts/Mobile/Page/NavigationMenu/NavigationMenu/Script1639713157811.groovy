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

Mobile.delay(3)
CustomKeywords.'scroll.scroll.scrollScreenLeftToRight'()
Mobile.delay(1)

for (int i = 0; i < 1; i++) {
	if (action == 'downloadtaxreport') {
		TestObject taxreport = GlobalVariable.NAVM_ContYearlyTaxReport
		
		int top = Mobile.getElementTopPosition(taxreport, 0)
		int y = Mobile.getElementHeight(taxreport, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(5)
//		Mobile.tap(findTestObject('Mobile/Page/NavigationMenu/Button - Open Just Once'), 0)
//		Mobile.delay(5)
		Mobile.pressBack()
	} else if (action == 'analyzeprofile') {
		TestObject risk = GlobalVariable.NAVM_ContRiskProfile
		
		int top = Mobile.getElementTopPosition(risk, 0)
		int y = Mobile.getElementHeight(risk, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * ( 0.2)
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
		
		try {
			for (int j = 1; j <= 5; j++) {
				def bestsuited = Mobile.verifyElementExist(GlobalVariable.NAVM_ContRiskProfile, 2)
					
				if (!bestsuited) {
					break
				}
				
				x = Mobile.getDeviceWidth() * ( 0.2 * j )
				
				Mobile.tapAtPosition(x, y)
				Mobile.delay(1)
			}
		} catch (Exception e) { }
		
		Random rand = new Random()
		
		int random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(GlobalVariable.NAVM_RISK_DropHowLong)
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(GlobalVariable.NAVM_RISK_OptHowLong1to3, 0)
		else
			Mobile.tap(GlobalVariable.NAVM_RISK_OptHowLong3to5, 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(GlobalVariable.NAVM_RISK_DropInvestGoal)
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(GlobalVariable.NAVM_RISK_OptInvestGoalAddIncome, 0)
		else
			Mobile.tap(GlobalVariable.NAVM_RISK_OptInvestGoalProfit, 0)
		Mobile.delay(1)

		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(GlobalVariable.NAVM_RISK_DropGenKnowledge)
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(GlobalVariable.NAVM_RISK_OptGenKnowledgeLimited, 0)
		else
			Mobile.tap(GlobalVariable.NAVM_RISK_OptGenKnowledgeQuiteGood, 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(GlobalVariable.NAVM_RISK_DropTotalAmount)
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(GlobalVariable.NAVM_RISK_OptTotal10and20, 0)
		else
			Mobile.tap(GlobalVariable.NAVM_RISK_OptTotal20and30, 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(GlobalVariable.NAVM_RISK_DropRiskLevel)
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(GlobalVariable.NAVM_RISK_OptRiskLevelLow, 0)
		else
			Mobile.tap(GlobalVariable.NAVM_RISK_OptRiskLevelNone, 0)
		Mobile.delay(1)
		
		random = rand.nextInt(2)
		CustomKeywords.'positionclick.positionclick.clickButtonInBottom'(GlobalVariable.NAVM_RISK_DropBestSuited)
		Mobile.delay(1)
		if (random == 0)
			Mobile.tap(GlobalVariable.NAVM_RISK_OptBestSuitedBonds, 0)
		else
			Mobile.tap(GlobalVariable.NAVM_RISK_OptBestSuitedSecDeposit, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.NAVM_RISK_BtnCalculate, 0)
		Mobile.delay(1)
		
		Mobile.pressBack()
	} else if (action == 'wa') {
		Mobile.tap(GlobalVariable.NAVM_BtnWhatsapp, 0)
		Mobile.delay(2)
	} else if (action == 'email') {
		Mobile.tap(GlobalVariable.NAVM_BtnEmail, 0)
		Mobile.delay(2)
	} else if (action == 'setting') {
		TestObject setting = GlobalVariable.NAVM_BtnSettings
		
		int top = Mobile.getElementTopPosition(setting, 0)
		int y = Mobile.getElementHeight(setting, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.NAVM_SETT_DropGain, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_OptGain5, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchGain, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchGain, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.NAVM_SETT_DropLoss, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_OptLoss5, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchLoss, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchLoss, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.NAVM_SETT_CbRiskTolerance, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_CbRiskTolerance, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchStock, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchStock, 0)
		Mobile.delay(1)

		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchFund, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchFund, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchBond, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchBond, 0)
		Mobile.delay(1)
		
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchMacro, 0)
		Mobile.delay(1)
		Mobile.tap(GlobalVariable.NAVM_SETT_SwitchMacro, 0)
		Mobile.delay(1)
		
		Mobile.pressBack()
		Mobile.delay(1)
	} else if (action == 'logout') {
		TestObject logout = GlobalVariable.NAVM_ContLogout
		
		int top = Mobile.getElementTopPosition(logout, 0)
		int y = Mobile.getElementHeight(logout, 0) * 0.8 + top
		int x = Mobile.getDeviceWidth() * 0.2
		
		Mobile.tapAtPosition(x, y)
		Mobile.delay(1)
	}
}