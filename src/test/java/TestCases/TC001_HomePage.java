package TestCases;

import java.io.IOException;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageobjects.HomePage;

public class TC001_HomePage extends BaseClass {
	@Test(priority=1, groups= {"master","regression"})
	void test1() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.titleValidation();
	}
	
	@Test(priority=5, groups= {"master","regression"})
	void test5() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.clickingOnUpcomingBikes();
	}
	
	@Test(priority=2,groups= {"master","regression"})
	void test() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickingOnCityForUsedCars();
	}
	
	@Test(priority=9, groups= {"master","sanity"})
	void Test9() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.login();
		hp.captureErrorMessage();
	}
}
