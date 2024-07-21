import model.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class AccrodTextTest {
     private final By accrodHead;
     private final String expected;
    private static final By ACCRODHEAD_0 = By.id("accordion__heading-0");
    private static final By ACCRODHEAD_1 = By.id("accordion__heading-1");
    private static final By ACCRODHEAD_2 = By.id("accordion__heading-2");
    private static final By ACCRODHEAD_3 = By.id("accordion__heading-3");
    private static final By ACCRODHEAD_4 = By.id("accordion__heading-4");
    private static final By ACCRODHEAD_5 = By.id("accordion__heading-5");
    private static final By ACCRODHEAD_6 = By.id("accordion__heading-6");
    private static final By ACCRODHEAD_7 = By.id("accordion__heading-7");

    private static final String ACCRODPANELTEXT_0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ACCRODPANELTEXT_1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ACCRODPANELTEXT_2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ACCRODPANELTEXT_3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ACCRODPANELTEXT_4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ACCRODPANELTEXT_5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ACCRODPANELTEXT_6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ACCRODPANELTEXT_7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    public AccrodTextTest(By accrodHead, String expected) {
        this.accrodHead = accrodHead;
        this.expected=expected;
    }
    @Parameterized.Parameters
    public static Object[] getText() {
        return new Object[][] {
                { ACCRODHEAD_0, ACCRODPANELTEXT_0},
                { ACCRODHEAD_1, ACCRODPANELTEXT_1},
                { ACCRODHEAD_2, ACCRODPANELTEXT_2},
                { ACCRODHEAD_3, ACCRODPANELTEXT_3},
                { ACCRODHEAD_4, ACCRODPANELTEXT_4},
                { ACCRODHEAD_5, ACCRODPANELTEXT_5},
                { ACCRODHEAD_6, ACCRODPANELTEXT_6},
                { ACCRODHEAD_7, ACCRODPANELTEXT_7}
                // передали тестовые данные
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
    public void CheckTextPanel() {
        driverChrome.get("https://qa-scooter.praktikum-services.ru/");
        driverFireFox.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPageChrome = new MainPage(driverChrome);
        MainPage mainPageFireFox = new MainPage(driverFireFox);
        Assert.assertEquals(mainPageChrome.AccordPanelText(accrodHead), expected);
        Assert.assertEquals(mainPageFireFox.AccordPanelText(accrodHead), expected);
    }
}

