package ru.sbtqa.tag.pagefactoryexample.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class BaseWebPage extends Page {

    public BaseWebPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    /*
     * Метод для нажатия на WebElement
     * С ожиданием его прогрузки
     * @Param itemName - название элемента
     */
    @ActionTitle("нажимает на")
    public void pressOnMenuItem(String itemName) throws PageException {
        waitToBeClickable(getElementByTitle(itemName)).click();
    }

    /*
     * Ожидание кликабельности элемента
     * @Param webElement - искомый элемент на странице
     * @Return - возвращает эелемент после его прогрузки
     */
    public WebElement waitToBeClickable(WebElement webElement) {
        new WebDriverWait(PageFactory.getDriver(), 10).ignoring(StaleElementReferenceException.class).
                until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }
}
