package pages.mainpage;

import enums.MainPageSectionId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MainPage {



    public MainPageSection getSection(MainPageSectionId sectionId) {
        return new MainPageSection(sectionId);
    }

    public void addProductToCartFromMainPage(int productId, MainPageSectionId sectionId) {
        MainPageSection section = getSection(sectionId);
        String sectionXpath = section.getSectionXpath();
        MainPageProduct product = new MainPageProduct(productId, sectionXpath);
        product.clickAddToCartButton();
    }

//    public void addProductToCartFromMainPage(int productId) {
//        MainPageProduct.setProductId(productId);
//        MainPageProduct.clickAddToCartButton();
//    }
}
