package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLib extends Base {

	// ********************************************************************************
	// Function Name : readElementPropertyFile
	// Summary : To get field
	// ********************************************************************************
	public static String readElementPropertyFile(String strQuery) {
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\Configuration\\findElementproperty.properties");
		String strData = "";
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInput);
			strData = prop.getProperty(strQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strData;
	}

	// ********************************************************************************
	// Function Name : readDataPropertyFile
	// Summary : To get data from TestData.properties
	// ********************************************************************************
	public static String readDataPropertyFile(String strQuery) {
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\Configuration\\testDatatproperty.properties");
		String strData = "";
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInput);
			strData = prop.getProperty(strQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strData;
	}

	// ********************************************************************************
	// Function Name : scrollMethod
	// Summary : Function to scroll down until an element is found
	// *****************************************************************************
	public static void scrollMethod(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// ********************************************************************************
	// Function Name : randomNumber
	// Summary : Function to generate random number
	// ********************************************************************************
	public static int randomNumber(int length) {
		int num = 0;
		Random random = new Random();
		num = random.nextInt(length) + 1;
		return num;
	}



	// ********************************************************************************
	// Function Name : randomWords
	// Summary : Function to generate random words
	// ********************************************************************************
	// random word generator
	public static String randomWords(int length) {
		Random random = new Random();
		StringBuilder word = new StringBuilder("Automations_");
		for (int i = 0; i < length; i++) {
			word.append((char) ('a' + random.nextInt(26)));
		}
		return word.toString();
	}
	
	// ********************************************************************************
	// Function Name : randomWord
	// Summary : Function to generate random words
	// ********************************************************************************
	// random word generator
	public static String randomWord(int length) {
		Random random = new Random();
		StringBuilder word = new StringBuilder("Automations");
		for (int i = 0; i < length; i++) {
			word.append((char) ('a' + random.nextInt(26)));
		}
		return word.toString();
	}

	// ********************************************************************************
	// Function Name : highLighterMethod
	// Summary : To get data Highlight
	// ********************************************************************************
	public static void highLighterMethod(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(100);
		js.executeScript("arguments[0].setAttribute('style', 'background: lightblue; border: 2px solid black;');",
				element);
		Thread.sleep(100);
		js.executeScript("arguments[0].removeAttribute('style','')", element);
	}


	// ********************************************************************************
	// Function Name :webDriverElementClickWait
	// Summary : To get data WAIT
	// ********************************************************************************
	public static void webDriverElementClickWait(By itemLocator) throws InterruptedException {
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(itemLocator));
	}
	
	// ********************************************************************
	// Function Name : clickWhenReady
	// Summary : Function for Select Text from Dropdown
	// ********************************************************************
	public static void clickWhenReady(By itemLocator) throws InterruptedException {
		Thread.sleep(1000);
		// Wait for the element to be visible and clickable
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
		wait2.until(ExpectedConditions.elementToBeClickable(itemLocator));
		// Click the element once it's ready
		driver.findElement(itemLocator).click();
	}
	
	// ********************************************************************************
		// Function Name :webDriverElementLocatedWait
		// Summary : To get data WAIT
		// ********************************************************************************
		public static void webDriverElementLocatedWait(By itemLocator) throws InterruptedException {
			Thread.sleep(500);
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
		}

	// ********************************************************************************
		// Function Name :webDriverElementWait
		// Summary : To get data WAIT
		// ********************************************************************************
		public static void webDriverElementWaitUntil(By itemLocator) throws InterruptedException {
			Thread.sleep(1500);
			WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait4.until(ExpectedConditions.elementToBeClickable(itemLocator));
		}
		// ********************************************************************************
				// Function Name :webDriverElementLocatedWait
				// Summary : To get data WAIT
				// ********************************************************************************
				public static void webDriverElementTestBoxWait(By itemLocator) throws InterruptedException {
					Thread.sleep(1500);
					WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait3.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
				}
}
