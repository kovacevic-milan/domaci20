
/*
Napraviti maven projekat i dodati selenium dependency.
U Mainu preko selenijuma otici na https://demoqa.com/text-box.
Zadatak je da popunite sva polja
(Full Name, email, Current Address, Permanent Address) i da kliknete submit.
Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre submita,
da nije doslo do izmene. Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver.", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Milan Kovacevic");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("milankovacevic@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Svetozara Markovica 22");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Sime Strahote 13");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);", "");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton.click();

        WebElement name1 = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement email1 = driver.findElement(By.xpath("//*[@id=\"email\"]"));

        if (name1.getText().substring(5).equals(fullName.getAttribute("value"))
                && email1.getText().substring(6).equals(email.getAttribute("value"))) {
            System.out.println("Ime i e-mail su validni. Podudaraju se sa unesenim tekstom. ");
        } else {
            System.out.println("Uneseni elementi se ne podudaraju!");
        }


    }
}
