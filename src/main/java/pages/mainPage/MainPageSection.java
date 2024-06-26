package pages.mainPage;

import enums.MainPageSectionId;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

@Getter
@Setter
public class MainPageSection {
    protected BasePage basePage;
    private String sectionXpath;

    public MainPageSection(MainPageSectionId sectionId)  {
        this.basePage = new BasePage();
        this.sectionXpath = "//section[@id='" + sectionId.getId() + "']";
    }

    public List<MainPageProduct> getProductsFromSection() {
        return IntStream.range(1, countProductsInSection() + 1)
                .mapToObj(index -> new MainPageProduct(index, sectionXpath))
                .collect(Collectors.toList());
}

    public int countProductsInSection() {
        return getWebDriverInstance()
                .findElements(By.xpath(this.sectionXpath + "/div/div/div/div"))
                .size();
    }
    
    public MainPageProduct getProduct(int index) {
        return getProductsFromSection()
                .get(index);
    }
}