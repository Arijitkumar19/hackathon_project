package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobjects.UsedCarsPage;

public class TC003_UsedCars extends TC001_HomePage {
	@Test(priority=7, groups= {"master","regression"})
	void test7() throws IOException, InterruptedException {
		UsedCarsPage up = new UsedCarsPage(driver);
		up.displayPopularModels();
	}
	
	@Test(priority=8, groups= {"master","regression"})
	void test8() throws IOException {
		UsedCarsPage up = new UsedCarsPage(driver);
		up.returnToHomePage();

	}

}
