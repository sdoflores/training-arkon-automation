import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConsultaInformacionTiendaTest {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeTest
    public void setUp(){
        playwright =  Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        page.navigate("http://localhost:3000");
    }

    @Test
    public void detallesTiendaTest(){
        Locator opNombre = page.locator("//*[@id='root']/div[2]/main/div[2]/div/div[2]/div[2]/div/div/table/tbody/tr[1]/th[2]/a");
        String txtExpected = opNombre.textContent();
        opNombre.click();
        Locator textActual = page.locator("//*[@id='root']/div[2]/main/div[2]/div/div[2]/div/div[2]/div[1]/p[2]");
        String txtActual = textActual.textContent();
        Assert.assertEquals(txtActual,txtExpected);
    }

    @AfterTest
    public void tearDown() {
        page.close();
    }

}
