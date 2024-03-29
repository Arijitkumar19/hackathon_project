package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.ExcelUtils;
import Utilities.Screenshots;

public class UpcomingBikes extends BasePage {

	public UpcomingBikes(WebDriver driver) throws IOException {
		super(driver);
	}

	//Elements
	
	// Homepage --> zigwheels logo
	@FindBy(xpath="//div[@class='row qlc']//div[@class='col-lg-2']")
	public WebElement zigwheelsLogo;
	
	// manufacturer dropdown
	@FindBy(xpath="//select[@id='makeId']")
	public WebElement manufacturesrs;
	
	// available bikes names element
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/a/strong")
	public List<WebElement> Bike_Names;
	
	// available bikes price text element
	@FindBy(xpath="//li[contains(@class,'modelItem')]")
	public List<WebElement> priceOfBike;
	
	// available bikes price text element
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/div[1]")
	public List<WebElement>Bike_Prices;
	
	//available bikes launch dates elements
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/div[2]")
	public List<WebElement>Bike_Launchdate;
	
	// click on view more options
	@FindBy(xpath="//li[@class='txt-c clr moreModels mb-20']/span")
	public WebElement viewMoreOpt;
	
	//honda text element
	@FindBy(xpath="//h1[@class='mt-0 pt-2 pull-left zm-cmn-colorBlack']")
	public WebElement hondaText; 
	
	//Action Methods
	public void returntohomepage() {
		zigwheelsLogo.click();
	}
	
	// Select honda from the manufacturer using select class
	public void filtermanufacturer() throws InterruptedException, IOException {
		Screenshots ss = new Screenshots(driver);
		Select s=new Select(manufacturesrs);
		s.selectByVisibleText("Honda");
		highlightElement(hondaText);
		ss.ScreenShot("HondaBikes");
		if(hondaText.getText().startsWith("Honda")) {
			System.out.println("Honda is selected");
		}
		else {
			System.out.println("Honda is not selected");
		}
	}
	
	//scroll the page and click on view more button
	public void scrollToViewMore() throws InterruptedException, IOException {
		Screenshots ss = new Screenshots(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500);", "");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", viewMoreOpt);
		//viewMoreOpt.click();
		Thread.sleep(3000);
		ss.ScreenShot("Bikes");
	}
	
	//get the bike name,price and launch date and print on console
	public void displaybikedetails() throws IOException {
		int j=1;
		String xlFile = System.getProperty("user.dir")+"\\testData\\zigWheels.xlsx";
		System.out.println("-----------------------------");
		for(int i=0;i<Bike_Names.size();i++) {
			int price = Integer.parseInt(priceOfBike.get(i).getAttribute("data-price"));
			if(price<400000) {
				System.out.println(Bike_Names.get(i).getText());
				ExcelUtils.setCellData(xlFile, "upcomingBikes", j, 0,Bike_Names.get(i).getText());
				System.out.println(Bike_Prices.get(i).getText());
				ExcelUtils.setCellData1(xlFile, "upcomingBikes", j, 1,Bike_Prices.get(i).getText());
				System.out.println(Bike_Launchdate.get(i).getText());
				System.out.println("-----------------------------------");
				ExcelUtils.setCellData1(xlFile, "upcomingBikes", j, 2,Bike_Launchdate.get(i).getText());
				j++;
			}
			else {
				continue;
			}
				
			}
		}
	}
