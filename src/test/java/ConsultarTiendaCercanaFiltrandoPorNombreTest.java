import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConsultarTiendaCercanaFiltrandoPorNombreTest {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeTest
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        page.navigate("http://localhost:3000");
    }

    @Test
    public void consultarTiendaCercanaPorNombre() throws InterruptedException {
        Locator opTiendasCercanas = page.locator("//*[@id='root']/div[2]/nav/div/div/ul/a[3]/li/div/div[2]/span");
        opTiendasCercanas.click();
        Locator inputBuscarTiendCerc = page.locator("css=[id='search']");
        String resultExpected = "Mitchell Inc";
        inputBuscarTiendCerc.fill(resultExpected);
        Locator result = page.locator("//*[@id='root']/div[2]/main/div[2]/div/div[2]/div/div[1]/div[2]/ul/div[1]/li/div[3]/span");
        String resultActual = result.textContent();
        Assert.assertEquals(resultActual,resultExpected);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        page.close();
    }








}
