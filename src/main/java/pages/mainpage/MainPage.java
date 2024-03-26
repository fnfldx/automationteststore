package pages.mainpage;

import enums.MainPageSectionId;
import lombok.Getter;
import lombok.Setter;
import pages.BasePage;

import java.util.List;
@Setter
public class MainPage extends BasePage {
    private List<MainPageSection> sections;

    public MainPageSectionId getSection(int index) {
        return sections.get(index).getSectionId();
    }

    public int countSections() {
        return sections.size();
    }

    public int countAllProducts() {
        int total = 0;
        for (MainPageSection section : sections) {
            total += section.countProducts();
        }
        return total;
    }
}