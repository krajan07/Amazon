package Mobiles;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.*;

public class amazonMobileCount {
	
	public static void main(String[] args) throws SQLException {
		
		try {
			
			//GET DETAILS FROM PROPERTY FILES FOR DB CONNECTION
			FileInputStream in = new FileInputStream("config.properties");
			Properties props = new Properties();
			props.load(in);  
		    
			//CONNECT TO DATABASE
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(props.getProperty("dbURL"), props.getProperty("user"), props.getProperty("pwd"));
			Statement stmt = conn.createStatement();
			
			//EXECUTE QUERY AND ASSIGN VALUE TO STRING VARIABLES
			ResultSet rs = stmt.executeQuery("SELECT * FROM amazon where id=1;");
			rs.next();
			String SearchCategory = rs.getString("categoryName");
			String Product = rs.getString("productName");
			System.out.println("Category " +SearchCategory+ " , Produc t" +Product);
			
			
			//OPEN AMAZON INDIA HOME PAGE
			System.setProperty("webdriver.chrome.driver","chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			
			//SEARCH FOR ELECTRONIC CATEGORY AND MOBILES KEYWORDS TAKEN FROM DATABASE
		
			Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
			select.selectByVisibleText(SearchCategory);
		
			WebElement selectCategory = driver.findElement(By.xpath("//option[text()='Electronics']//following::input[1]"));
			selectCategory.sendKeys(Product);
			
			WebElement submit = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
			submit.click();
			
			//COUNT NUMBER OF MOBILES DISPLAYED POST SEARCH
			List<WebElement> MobileCount = driver.findElements(By.xpath("//a[@class=\"a-link-normal a-text-normal\"]"));
			System.out.println("No.of mobiles listed in the Amazon Search page = " + MobileCount.size());
			String MobileCountSize = String.valueOf(MobileCount.size());
			
			WebElement CountText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));
			String CountInText = CountText.getText().substring(2, 4);
			System.out.println("No.of mobiles mentioned in the Amazon Search page in Text = " + CountInText);
			
			if ( CountInText.equals(MobileCountSize)) {
				System.out.println("Count in Text is matches with the listed count");	
			}
			else {
				System.out.println("Count in Text is not matching with the listed count");
			}
			
			
			
			
			List<WebElement> Mobiles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			System.out.println( "Count Mobile =" + Mobiles.size());
			int MobilesCount=Mobiles.size();
			System.out.println("<------- Names of the Mobiles in the Amazon Search page is as below --------->");
			for(int i=0; i < MobilesCount; i++) {
				System.out.println("Mobile "+ i + " = " + Mobiles.get(i).getText());
			}
		
			//CLOSE BROWSER
			stmt.close();
			driver.close();

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
