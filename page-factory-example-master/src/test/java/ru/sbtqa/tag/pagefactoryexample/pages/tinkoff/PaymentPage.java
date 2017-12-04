package ru.sbtqa.tag.pagefactoryexample.pages.tinkoff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactoryexample.pages.BaseWebPage;

import java.util.List;

@PageEntry(title = "Страница оплаты")
public class PaymentPage extends BaseWebPage {

    @ElementTitle("Оплатить ЖКУ в Москве")
    @FindBy(xpath = "//*[text() = 'Оплатить ЖКУ в Москве']//ancestor::a")
    public WebElement payInMoscow;

    @ElementTitle("Обязательные поля для заполнения")
    @FindBy(xpath = "//form[@class = 'ui-form']//input")
    List<WebElement> requiredInputs;

    /*
     *В этом методе соответственно документации
     * вводятся некоректные символы
     */
    @ActionTitle("водит неверные симолы")
    public void enteryInvalidSybols() {
        //TO DO : Ввести некорректные символы
    }
}
