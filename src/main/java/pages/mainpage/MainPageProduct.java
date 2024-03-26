package pages.mainpage;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Getter
@Setter
public class MainPageProduct extends BasePage {
    private String header;
    private double price;
    private WebDriver driver;

    public MainPageProduct(WebDriver driver) {
        this.driver = driver;
    }



    public double getPrice() {
        WebElement priceElement = driver.findElement(By.xpath("//a[@class='oneprice'"));;
        String priceText = priceElement.getText();
        price = Double.parseDouble(priceText);
        return price;
    }

    public String getProductName() {
        WebElement productNameElement = driver.findElement(By.xpath("//a[@class='prdocutname']"));
        return productNameElement.getText();
    }


    public void addToCart(String productId) {
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='productcart' and @data-id='" + productId + "']"));
        addToCartButton.click();
    }
}