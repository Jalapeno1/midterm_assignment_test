import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Jonas on 02-04-2016.
 */
public class SeleniumTest {

    @Test
    public void run(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\jons_\\Documents\\Java Libraries\\selenium libs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.polyteknisk.dk/home");

        // i)
        driver.findElement(By.className("super_search_input_field")).sendKeys("Silberschatz");
        driver.findElement(By.className("super_search_submit_button")).click();

        // ii)
        List<WebElement> elementList = driver.findElements(By.className("imprint"));

        for(int i = 0; i < elementList.size(); i++){
            System.out.println(elementList.get(i).getText());
        }

        // iii)
        driver.findElement(By.linkText("Database System Concepts")).click();
        driver.findElement(By.className("submit-button")).click();

        // iv)
        String expected = "Database System Concepts, 6. udgave";
        driver.get("http://www.polyteknisk.dk/home/checkout1");
        String actual = driver.findElement(By.linkText("Database System Concepts, 6. udgave")).getText();
        assertEquals(expected, actual);

        // v)
        expected = "778,50 dkk.";
        actual = driver.findElement(By.className("price_total")).getText();
        assertEquals(expected, actual);

        driver.quit();

    }
}