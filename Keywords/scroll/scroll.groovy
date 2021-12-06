package scroll

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class scroll {
	@Keyword
	def scrollScreenTopToBottom() {
		def device_Height = Mobile.getDeviceHeight()
		def device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.30
		int endY = device_Height * 0.70

		Mobile.swipe(startX, endY, endX, startY)
	}

	@Keyword
	def scrollScreenBottomToTop() {
		def device_Height = Mobile.getDeviceHeight()
		def device_Width = Mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.8
		int endY = device_Height * 0.2

		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def scrollScreenBottomToTop(TestObject element) {
		int left_position = Mobile.getElementLeftPosition(element, 0)
		int top_position = Mobile.getElementTopPosition(element, 0)
		int width = Mobile.getElementWidth(element, 0)
		int height = Mobile.getElementHeight(element, 0)

		int startX = left_position + width/2
		int endX = startX
		int startY = Mobile.getDeviceHeight() - 15
		int endY = top_position + 15

		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def scrollScreenRightToLeft(TestObject element) {
		int left_position = Mobile.getElementLeftPosition(element, 0)
		int top_position = Mobile.getElementTopPosition(element, 0)
		int width = Mobile.getElementWidth(element, 0)
		int height = Mobile.getElementHeight(element, 0)

		int startX = Mobile.getDeviceWidth() - 100
		int startY = top_position + (height / 2)
		int endX = 100
		int endY = top_position + (height / 2)

		System.out.println('start x : ' + startX)
		System.out.println('start y : ' + startY)
		System.out.println('end x : ' + endX)
		System.out.println('end y : ' + endY)

		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def scrollScreenLeftToRight() {
		int startX = 10
		int startY = Mobile.getDeviceHeight() / 2
		int endX = Mobile.getDeviceWidth() - 10
		int endY = Mobile.getDeviceHeight() / 2

		System.out.println('start x : ' + startX)
		System.out.println('start y : ' + startY)
		System.out.println('end x : ' + endX)
		System.out.println('end y : ' + endY)

		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def scrollRightToLeft(TestObject element) {
		int left_position = Mobile.getElementLeftPosition(element, 0)
		int top_position = Mobile.getElementTopPosition(element, 0)
		int width = Mobile.getElementWidth(element, 0)
		int height = Mobile.getElementHeight(element, 0)

		int startX = left_position + width * 0.95
		int startY = top_position + (height / 2)
		int endX = left_position + width * 0.05
		int endY = top_position + (height / 2)

		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def scrollLeftToRight(TestObject element) {
		int left_position = Mobile.getElementLeftPosition(element, 0)
		int top_position = Mobile.getElementTopPosition(element, 0)
		int width = Mobile.getElementWidth(element, 0)
		int height = Mobile.getElementHeight(element, 0)

		int startX = left_position + width * 0.2
		int startY = top_position + (height / 2)
		int endX = left_position + width * 0.8
		int endY = top_position + (height / 2)

		Mobile.swipe(startX, startY, endX, endY)
	}
}
