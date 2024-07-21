import model.MainPage;
import model.OrderPageConfirm;
import model.OrderPageHowToMakeOrder;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.StringContains.containsString;

@RunWith(Parameterized.class)
public class TestOrder {
    private final String name;
    private final String surName;
    private final String adress;
    private final String phone;
    private final String dateRent;
    private final String comment;

    public TestOrder(String name, String surName, String adress,String phone,String dateRent,String comment) {
        this.name = name;
        this.surName=surName;
        this.adress=adress;
        this.phone=phone;
        this.dateRent=dateRent;
        this.comment=comment;
    }
    @Parameterized.Parameters
    public static Object[] Next() {
        return new Object[][] {
                { "Наиля", "Боркова", "улица 8", "+79992225555","20.02.2024","vvv"},
                { "Иван", "Иваер", "улица 9", "+79992225555","20.03.2024","ddd"},
        };
    }

    private WebDriver driverChrome;
    private WebDriver driverFireFox;

    @Before
    public void setUp() throws Exception {
        driverChrome = new ChromeDriver();
        driverFireFox = new FirefoxDriver();
    }

    @After
    public void after() {
        driverChrome.quit();
        driverFireFox.quit();
    }

    @Test
    public void CheckTextPanelOnFireFox() {
        driverFireFox.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driverFireFox);
        mainPage.clickUpOrderButton();

        OrderPageHowToMakeOrder orderPageHowToMakeOrder =new OrderPageHowToMakeOrder(driverFireFox);
        orderPageHowToMakeOrder.waitOrderPage();
        orderPageHowToMakeOrder.enterName(name);
        orderPageHowToMakeOrder.enterSurName(surName);
        orderPageHowToMakeOrder.enterAdress(adress);
        orderPageHowToMakeOrder.enterMetro();
        orderPageHowToMakeOrder.enterPhone(phone);
        orderPageHowToMakeOrder.clickNextButton();

        OrderPageConfirm orderPageConfirm = new OrderPageConfirm(driverFireFox);
        orderPageConfirm.waitOrder2Page();
        orderPageConfirm.enterDate(dateRent);
        orderPageConfirm.enterSrok();
        orderPageConfirm.enterColor();
        orderPageConfirm.enterComment(comment);
        orderPageConfirm.enterNext();
        orderPageConfirm.waitModalWin();
        orderPageConfirm.enterYes();
        MatcherAssert.assertThat(orderPageConfirm.waitModalSucess(),containsString("Заказ оформлен"));


    }
    @Test
    public void CheckTextPanelOnChrome() {
        driverChrome.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driverChrome);
        mainPage.clickUpOrderButton();
        OrderPageHowToMakeOrder orderPageHowToMakeOrder =new OrderPageHowToMakeOrder(driverChrome);
        orderPageHowToMakeOrder.waitOrderPage();
        orderPageHowToMakeOrder.enterName(name);
        orderPageHowToMakeOrder.enterSurName(surName);
        orderPageHowToMakeOrder.enterAdress(adress);
        orderPageHowToMakeOrder.enterMetro();
        orderPageHowToMakeOrder.enterPhone(phone);
        orderPageHowToMakeOrder.clickNextButton();

        OrderPageConfirm orderPageConfirm = new OrderPageConfirm(driverChrome);
        orderPageConfirm.waitOrder2Page();
        orderPageConfirm.enterDate(dateRent);
        orderPageConfirm.enterSrok();
        orderPageConfirm.enterColor();
        orderPageConfirm.enterComment(comment);
        orderPageConfirm.enterNext();
        orderPageConfirm.waitModalWin();
        orderPageConfirm.enterYes();
        MatcherAssert.assertThat(orderPageConfirm.waitModalSucess(),containsString("Заказ оформлен"));


    }


}
