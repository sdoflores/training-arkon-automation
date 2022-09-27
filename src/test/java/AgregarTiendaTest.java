import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AgregarTiendaTest {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeTest
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        page.navigate("http://localhost:3000/");
    }
    @Test
    public void primerTest() {
        Locator opAgTiendas = page.locator("//*[@id=\"root\"]/div[2]/nav/div/div/ul/a[2]/li/div/div[2]/span");
        Locator txtId = page.locator("css=[id=':r7:']");
        Locator txtName = page.locator("css=[id=':r9:']");
        Locator txtBusinessName = page.locator("css=[id=':rb:']");
        Locator txtActivity= page.locator("css=[id=':rd:']");
        Locator txtEstrato = page.locator("css=[id=':rf:']");
        Locator txtPhone = page.locator("css=[id=':rh:']");
        Locator txtDress = page.locator("css=[id=':rj:']");
        Locator txtWebsite = page.locator("css=[id=':rl:']");
        Locator selectStoreType = page.locator("css=[id='mui-component-select-shopType']");
        Locator opStoreType = page.locator("//*[@id=\"menu-shopType\"]/div[3]/ul/li[1]");
        Locator txtLatitude = page.locator("css=[id=':rn:']");
        Locator txtLength = page.locator("css=[id=':rp:']");
        Locator btnSave = page.locator("//button[text()='Guardar']");

        opAgTiendas.click();
        txtId.fill("123");
        txtName.fill("Este es un negocio nuevo");
        txtBusinessName.fill("Negocio Prueba");
        txtActivity.fill("Comercio");
        txtEstrato.fill("Estrato Prueba");
        txtPhone.fill("1234567890");
        txtDress.fill("Esta es una dirección");
        txtWebsite.fill("pagina.com");
        selectStoreType.click();
        opStoreType.click();
        txtLatitude.fill("789635");
        txtLength.fill("1235465");
        btnSave.click();
        Locator txtNotify = page.locator("//div[1]/div[1]/div/div/div[1]/div[2]");
        Assert.assertTrue(txtNotify.isVisible());
    }

    @AfterTest
    public void tearDown () throws InterruptedException {
        Thread.sleep(5000);
        page.close();
    }

}
