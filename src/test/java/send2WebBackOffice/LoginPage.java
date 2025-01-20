package send2WebBackOffice;
import org.openqa.selenium.By;
import core.CommonLib;

import org.junit.Assert;


public class LoginPage extends CommonLib{
	By userName = By.id(CommonLib.readElementPropertyFile("TEXT_LOGN_USERNAME_ID"));
	By password = By.name(CommonLib.readElementPropertyFile("TEXT_LOGN_PASSWORD_NAME"));
	By loginButton =By.xpath(CommonLib.readElementPropertyFile("BUTTON_LOGN_XP"));
	By homepageTitle=By.xpath(CommonLib.readElementPropertyFile("TEXT_HOMEPAGE_TITLE_XP"));

    public void appSuperAdminLoginName() throws Exception {
        driver.findElement(userName).sendKeys(CommonLib.readDataPropertyFile("SUPERADMIN_LOGIN_USERNAME"));
    }

    public void appSuperAdminLoginPassword() throws Exception {
        driver.findElement(password).sendKeys(CommonLib.readDataPropertyFile("SUPERADMIN_LOGIN_PASSWORD"));
    }

    public void appLoginClickLogin() throws Exception {
        CommonLib.clickWhenReady(loginButton);
        CommonLib.webDriverElementTestBoxWait(homepageTitle);
    }

    public void appHomePageLanding() throws Exception {
        CommonLib.webDriverElementTestBoxWait(homepageTitle);
        String Success_Title = "HOME";
        String Orginal_Title = driver.findElement(homepageTitle).getText();
        // Use the correct Assert class
      Assert.assertEquals(Success_Title, Orginal_Title);  
    }
}
