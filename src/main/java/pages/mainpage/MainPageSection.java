package pages.mainpage;

import enums.MainPageSectionId;
import lombok.Getter;
import lombok.Setter;
import pages.BasePage;

import java.util.List;
import java.util.Random;

@Setter
public class MainPageSection extends BasePage {
    private List<MainPageProduct> products;
    @Getter
    private MainPageSectionId sectionId;

    public MainPageProduct getProduct(int index) {
        return products.get(index);
    }

    public int countProducts() {
        return products.size();
    }

    public MainPageProduct getRandomProduct() {
        Random rand = new Random();
        return products.get(rand.nextInt(products.size()));
    }

}