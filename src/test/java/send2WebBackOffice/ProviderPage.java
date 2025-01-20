package send2WebBackOffice;


	import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
	import core.Base;
import core.CommonLib;



	public class ProviderPage extends Base {
		
		private String providerName;
		By ProviderTileButton =By.xpath(CommonLib.readElementPropertyFile("BUTTON_PROVIDER_TILE_XP"));
		By AddProviderButton=By.xpath(CommonLib.readElementPropertyFile("BUTTON_ADD_PROVIDER"));
		By UploadLogo=By.xpath(CommonLib.readElementPropertyFile("BUTTON_UPLOAD_LOGO"));
		By ProviderName=By.xpath(CommonLib.readElementPropertyFile("TEXT_PROVIDER_NAME"));
		By ProviderEmail=By.xpath(CommonLib.readElementPropertyFile("TEXT_PROVIDER_EMAIL"));
		By ProviderDescription=By.xpath(CommonLib.readElementPropertyFile("TEXT_DESCRIPTION"));
		By ProviderTypeBank=By.xpath(CommonLib.readElementPropertyFile("RADIO_BUTTON_PROVIDERTYPE_BANK"));
		By ProvideReceivemethodBankTransfer=By.xpath(CommonLib.readElementPropertyFile("CHECKBOX_RECEIVEMETHOD_BANKTRANSFER"));
		By ProviderSubmit=By.xpath(CommonLib.readElementPropertyFile("BUTTON_PROVIDERADD_SUBMIT"));
		By ProviderSearchBar=By.xpath(CommonLib.readElementPropertyFile("TEXT_SEARCHBAR"));
		By ActualProviderName=By.xpath(CommonLib.readElementPropertyFile("TEXT_ACTUAL_PROVIDER_NAME"));
		By ProviderDeleteButton=By.xpath(CommonLib.readElementPropertyFile("BUTTON_PROVIDER_DELETE_XP"));
		By ProviderDeleteConfirmation=By.xpath(CommonLib.readElementPropertyFile("BUTTON_DELETE_CONFIRMATION"));
		By NoProviderList=By.xpath(CommonLib.readElementPropertyFile("LABEL_NO_PROVIDER_LIST_XP"));
		
		
		
		
		

	    // Navigate to the home page
	    public void navigateToHomePage() {
	    	String Orginal_Title = driver.findElement(By.xpath("//div[contains(text(),\"Home\")]")).getText();
	    }

	    // Click on Providers tile
	    public void clickProvidersTile() throws InterruptedException {
	    	CommonLib.clickWhenReady(ProviderTileButton);
	    	CommonLib.webDriverElementClickWait(ProviderTileButton);
	        
	    }

	    // Click on Add Provider button
	    public void clickAddProviderButton() throws InterruptedException {
	    	CommonLib.webDriverElementLocatedWait(AddProviderButton);
	    	CommonLib.clickWhenReady(AddProviderButton);
	    	
	    	
	        }

	    // Fill in provider details
	    public void fillProviderFields() throws InterruptedException {
	    	
	    	driver.findElement(UploadLogo).sendKeys(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"providerlogo.png");
	    	//name
	    	providerName=CommonLib.randomWords(5);
	    	driver.findElement(ProviderName).sendKeys(providerName);
	    	//email
	    	driver.findElement(ProviderEmail).sendKeys((CommonLib.randomWords(5)+"@testdomain.com"));
	    	
	    	//description
	    
	    	driver.findElement(ProviderDescription).sendKeys(CommonLib.readDataPropertyFile("PROVIDER_DESCRIPTION"));
	    	//provider type-bank
	    	driver.findElement(ProviderTypeBank).click();
	    	////Receive method-bank transfer
	    	driver.findElement(ProvideReceivemethodBankTransfer).click();
	        
	    }

	    // Click on Submit button
	    public void clickSubmitButton() throws InterruptedException {
	    	CommonLib.clickWhenReady(ProviderSubmit);
	    	CommonLib.webDriverElementClickWait(ProviderSubmit);
	        
	    }

	    // Get success message after provider creation
	    public void getSuccessProvider() throws InterruptedException {
	    	
	        CommonLib.webDriverElementLocatedWait(ProviderSearchBar);
	    	driver.findElement(ProviderSearchBar).sendKeys(providerName);
	    	CommonLib.webDriverElementTestBoxWait(ActualProviderName);
	        String actualProviderName=driver.findElement(ActualProviderName).getText();
	        System.out.println(providerName);
	        System.out.println(actualProviderName);
	    	Assert.assertEquals(providerName, actualProviderName);
	    }

	    //Click on Delete button of provider
	    public void deleteProvider() throws InterruptedException {
	    	CommonLib.clickWhenReady(ActualProviderName);
	    	CommonLib.clickWhenReady(ProviderDeleteButton);
	    	CommonLib.clickWhenReady(ProviderDeleteConfirmation);
	    	CommonLib.webDriverElementTestBoxWait(ProviderSearchBar);


	    }
	    //Search the deleted provider 
	    public void deleteConfirmation() throws InterruptedException {
	    	CommonLib.webDriverElementLocatedWait(ProviderSearchBar);
	    	driver.findElement(ProviderSearchBar).clear();
	        driver.findElement(ProviderSearchBar).sendKeys(providerName);
	        String NoProviderListLabel=driver.findElement(NoProviderList).getText();
	        System.out.println(NoProviderListLabel);
	        //Assert.assertNotNull(NoProviderList);
	        Assert.assertEquals("Text mismatch","No data available.",NoProviderListLabel );
	    	
	    }
	    
	}


