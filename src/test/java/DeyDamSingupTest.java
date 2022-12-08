import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeyDamSingupTest {
    private WebDriver driver;
    @BeforeTest
    public void setup () throws InterruptedException {
        //locate Driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //open browser
        driver = new ChromeDriver();
        driver.get("https://deydam.com/");
        Thread.sleep(3000);
        //Maximize the web_browser
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }
    @Test(priority = 0)
            public void verifyUrl(){
        //Test 1:verify that the user inputs the right Url and is directed to the right webpage
        String expectedUrl = "https://deydam.com/";
        String actualUrl=driver.getCurrentUrl();
        if (expectedUrl.contains(actualUrl))
            System.out.println("Correct Url");
        else
            System.out.println("Wrong URL");

}
@Test(priority = 1)
public void get_Text (){
        if (driver.getPageSource().contains("Create new account"))
            System.out.println("Create Account Link_Present");
        else
            System.out.println("Create Account Link_NotPresent");

}
    // Test 2: verify the title page
    @Test(priority = 2)
    public void verifyTitlePage (){
        String actualtitle= driver.getTitle();
    String expectedtitle= "Deydam:";

        Assert.assertEquals(actualtitle, expectedtitle);
    if (expectedtitle.contains(actualtitle))
        System.out.println("Page_Title Validated");
    else
        System.out.println("wrong title");
    }

    @Test(priority = 3)
    //Test 3:verify the signup button
    public void signupButton () throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[1]/div/div/button")).click();
        Thread.sleep(3000);

        // verify that the user is on the signup page
        String expectedsignupUrl = "https://deydam.com/signup?ref=null";
        String actualsingupUrl = driver.getCurrentUrl();
        if (expectedsignupUrl.contains(actualsingupUrl))
            System.out.println("correct sign up Url");
        else
            System.out.println("wrong signup Url");
    }

    @Test(priority = 4)
    // Test 4: verify that the signup button is present
    public void verifySignupButton_is_Displayed(){

    }
    @Test(priority = 5)
    // Test 5: Verify that the user can signup with valid credentials
    // POSITIVE SCENARIO
    public void verifySignup_Valid_Credentials() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("John87658");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys("John77864@mailinator.com");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("2222299999#");
        driver.findElement(By.name("confirmPassword")).sendKeys("2222299999#");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(7000);

        String expected_successful_Url="https://deydam.com/signup/success";
        String actualUrl=driver.getCurrentUrl();
        if (expected_successful_Url.contains(actualUrl))
            System.out.println("Signup_successful");
        else
            System.out.println("Signup_Failed");
    }


@Test(priority = 6)
//Test 6: verify that the user can not sign in with username less than 4 character
//NEGATIVE SCENARIO
public void username_less_than_4_character() throws InterruptedException {
        driver.get("https://deydam.com/signup?ref=null");
    driver.manage().window().maximize();
    Thread.sleep(3000);

    driver.findElement(By.name("username")).sendKeys("Joh");
    Thread.sleep(1000);

    driver.findElement(By.name("email")).sendKeys("johnaholu240@mailinator.com");
    Thread.sleep(1000);

    driver.findElement(By.name("password")).sendKeys("jjhooduyhryfgfvbd");
    driver.findElement(By.name("confirmPassword")).sendKeys("jjhooduyhryfgfvbd");

    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/button")).click();
    Thread.sleep(7000);
     String expectedUrl= "https://deydam.com/signup?ref=null";
     String actualUrl= driver.getCurrentUrl();
    if (expectedUrl.contains(actualUrl))
        System.out.println("Signup_successful");
    else
        System.out.println("Signup_Failed");

}

    @Test(priority = 7)
    //Test 7: verify that the user can not signup with a blank username
    //NEGATIVE SCENARIO
    public void sigup_denied() throws InterruptedException {
        driver.get("https://deydam.com/signup?ref=null");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys("johnaholu240@mailinator.com");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("jjhooduyhryfgfvbd");
        driver.findElement(By.name("confirmPassword")).sendKeys("jjhooduyhryfgfvbd");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(7000);
        String expectedUrl = "https://deydam.com/signup?ref=null";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.contains(actualUrl))
            System.out.println("Signup_successful");
        else
            System.out.println("Signup_Failed");

    }


    @Test(priority = 7)
    //Test 7: verify that the user can not signup with a blank email
    //NEGATIVE SCENARIO
    public void sigup_denied2() throws InterruptedException {
        driver.get("https://deydam.com/signup?ref=null");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("johnn6765784");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys("");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("1234567890");
        driver.findElement(By.name("confirmPassword")).sendKeys("123467890");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(7000);
        String expectedUrl = "https://deydam.com/signup?ref=null";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.contains(actualUrl))
            System.out.println("Signup_successful");
        else
            System.out.println("Signup_Failed");

    }
    @Test(priority = 8)
    //Test 8: verify that the user can not signup with a blank Password
    //NEGATIVE SCENARIO
    public void sigup_denied3() throws InterruptedException {
        driver.get("https://deydam.com/signup?ref=null");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("johnn6764");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys("johnaholu240@mailinator.com");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.name("confirmPassword")).sendKeys("");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(7000);
        String expectedUrl = "https://deydam.com/signup?ref=null";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.contains(actualUrl))
            System.out.println("Signup_successful");
        else
            System.out.println("Signup_Failed");

    }
    @Test(priority = 9)
    //Test 9: verify that the user can not signup with blank text fields
    //NEGATIVE SCENARIO
    public void sigup_denied4() throws InterruptedException {
        driver.get("https://deydam.com/signup?ref=null");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("");
        Thread.sleep(1000);

        driver.findElement(By.name("email")).sendKeys("");
        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.name("confirmPassword")).sendKeys("");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(7000);
        String expectedUrl = "https://deydam.com/signup?ref=null";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.contains(actualUrl))
            System.out.println("Signup_successful");
        else
            System.out.println("Signup_Failed");

    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
