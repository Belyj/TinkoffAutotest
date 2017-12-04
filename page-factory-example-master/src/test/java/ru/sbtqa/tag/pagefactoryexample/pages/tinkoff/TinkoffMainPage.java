package ru.sbtqa.tag.pagefactoryexample.pages.tinkoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.pages.BaseWebPage;

@PageEntry(title = "Тинькофф")
public class TinkoffMainPage extends BaseWebPage {

    @ElementTitle("Платежи")
    @FindBy(xpath = "//*[text() = 'Платежи']/..")
    public WebElement payouts;
}