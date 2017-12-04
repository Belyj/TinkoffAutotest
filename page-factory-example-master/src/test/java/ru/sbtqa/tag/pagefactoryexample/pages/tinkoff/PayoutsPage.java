package ru.sbtqa.tag.pagefactoryexample.pages.tinkoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.pages.BaseWebPage;

import java.util.List;

@PageEntry(title = "Платежи")
public class PayoutsPage extends BaseWebPage {

    @ElementTitle("Коммунальные платежи")
    @FindBy(xpath = "//*[@title = 'Коммунальные платежи']")
    public WebElement[] communityPayouts;

    @ElementTitle("Строка быстрого поиска")
    @FindBy(xpath = "//span[text() = 'Что оплатить или куда перевести?']//following-sibling::input")
    public WebElement searchInput;

    @ElementTitle("Результаты поиска")
    @FindBy(xpath = "//*[@class='SearchSuggested__suggestContainer_Z6mjO']//div[@data-qa-node= 'Tag']")
    public List<WebElement> searchResults;

    @ActionTitle("ищет поставщика услуг")
    public void searchOfVendor() {
        searchInput.sendKeys(new CommunityPayoutsPage().searchableVendor);
    }

    @ActionTitle("убеждается, что поставщик под номером")
    public void inshureInSequence(String searchebleNum) {
        int number = Integer.parseInt(searchebleNum);
        if (!searchResults.get(number - 1).getText().equals(new CommunityPayoutsPage().searchableVendor)) {
            System.out.println("Искомый поставщик не находится под номером " + searchebleNum);
        }
    }

    @ActionTitle("выбираем искомого поставщика")
    public void choseSearchebleVendor() {
        searchResults.stream().filter(x -> x.getText()
                .equals(new CommunityPayoutsPage().searchableVendor)).findFirst().get().click();
    }
}