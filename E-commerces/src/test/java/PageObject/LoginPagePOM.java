package PageObject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.Loginpage;
import Utilities.IAutoConstant;
import Utilities.ReadConfig;

public class LoginPagePOM implements  IAutoConstant{
	//public static Logger log=log=LogManager.getLogger("E-commers");
	ReadConfig Rc = new ReadConfig();
	public LoginPagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//locate Element 
	@FindBy(xpath ="//input[@name='username']") public WebElement  username;
	@FindBy(xpath ="//input[@name='password']") public WebElement passwored;
	@FindBy(xpath ="//button[@type='submit']") public WebElement loginbutton;
	@FindBy(linkText ="Forgot your password?")  public WebElement forgotpasswordElement;
	@FindBy(xpath ="//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	public WebElement  dashboard;
	@FindBy(xpath ="//img[@alt='profile picture' and  @class='oxd-userdropdown-img']") public  WebElement loginLogo;
	@FindBy(xpath="//p[text()='Invalid credentials']")public WebElement logo;

	public void clickForgotyourpassword()
	{
		forgotpasswordElement.click();
	}

	public void LoginOperation() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String user = Rc.ReadExcelData(EXCEL_PATH,"Validcreads",1,0);
		String pass = Rc.ReadExcelData(EXCEL_PATH,"Validcreads",1,1);
		username. sendKeys(user);
		passwored.sendKeys(pass);
		Thread.sleep(10000);
		loginbutton.click();
		//log.info("user login sucessfull");
	}
	//invalid Condition
	public void  multipelLogin(String Username, String password ) throws InterruptedException
	{
		username. sendKeys(Username);
		passwored.sendKeys(password);
		Thread.sleep(10000);
		loginbutton.click();
	}
}
