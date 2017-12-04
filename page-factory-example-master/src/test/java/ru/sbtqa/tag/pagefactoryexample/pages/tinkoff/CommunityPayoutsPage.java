package ru.sbtqa.tag.pagefactoryexample.pages.tinkoff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactoryexample.pages.BaseWebPage;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;
import java.util.function.Predicate;

@PageEntry(title = "Коммунальные платежи")
public class CommunityPayoutsPage extends BaseWebPage {

    @ElementTitle("pageframe")
    @FindBy(xpath = "//div[@class ='ui-page-frame__content']")
    public WebElement pageFrame;

    @ElementTitle("Города")
    @FindBy(xpath = "//div[@class ='ui-regions__item']")
    List<WebElement> cities;

    @ElementTitle("Список поставщиков")
    @FindBy(xpath = "//section//a")
    List<WebElement> vendors;

    public static String searchableVendor;

    @ActionTitle("находится в")
    public void placedIn(String expectedCity, String targetCity) {
        WebElement actualCity = pageFrame.findElement(By.xpath(".//*[contains (@class, 'payment-page__title_inner')]"));
        if (!expectedCity.equals(actualCity.getText())) {
            actualCity.click();
            cities.stream().filter(x -> targetCity.equals(x.getText())).findFirst().get().click();
        }
    }

    @ActionTitle("переходит к поставщику и запоминает его наименование")
    public void choseVendor() {
        WebElement first = vendors.get(0);
        searchableVendor = first.getText();
        first.click();
    }
}