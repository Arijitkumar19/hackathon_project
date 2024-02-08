package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobjects.UpcomingBikes;
//@Listeners(Utilities.ExtentReportManager.class)
public class TC002_UpcomingBikePage extends TC003_UsedCars {
	
	@Test(priority=3, groups= {"master","regression"})
	void test3() throws IOException, InterruptedException {
		UpcomingBikes up=new UpcomingBikes(driver);
		up.filtermanufacturer();
	}
	@Test(priority=4, groups= {"master","regression"})
	void test4() throws IOException, InterruptedException {
		UpcomingBikes up=new UpcomingBikes(driver);
		up.scrollToViewMore();
		up.displaybikedetails();
	}
	@Test(priority=5, groups= {"master","regression"})
	void test5() throws IOException {
		UpcomingBikes up=new UpcomingBikes(driver);
		up.returntohomepage();
	}


}
