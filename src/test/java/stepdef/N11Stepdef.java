package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.WebElements;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethods;



public class N11Stepdef extends WebElements {
    String mainUrl;

    @Given("{string} sitesi açılır.")
    public void sitesiAçılır(String baseUrl) {
       // Log.startTestCase("navigate url");
        Driver.getDriver().get(ConfigReader.getProperty("n11"));
        mainUrl=Driver.getDriver().getCurrentUrl();
        ReusableMethods.waitFor(3);
    }

    @Then("Ana sayfanın açıldığı kontrol edilir.")
    public void anaSayfanınAçıldığıKontrolEdilir() {
       ReusableMethods.waitForPageToLoad(10);
        Log.startTestCase("n11 Testi Başlıyor");
        Driver.getDriver().get(ConfigReader.getProperty("n11"));
        mainUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),mainUrl);
    }

    @When("Siteye login olunur.")
    public void siteyeLoginOlunur() {
        click_sign_in();
        Log.info("Siteye Login olunur");
        ReusableMethods.waitFor(2);
        email_input();
        password_input();
        ReusableMethods.waitFor(2);
        click_girisYap_button();
      }

    @And("Login işlemi kontrol edilir.")
    public void loginIşlemiKontrolEdilir() {
        Log.info("Login işlemi Kontrol edilir");
       verify_favoriElements_button();
    }


    @Given("{string} kelimesi aranır.")
    public void kelimesiAranır(String text) {
        Log.info("arama Kutusuna istenilen ürün yazılır");
            aramaInputText(text);
    }


    @And("{string} kelimesi aratıldığı kontrol edilir.")
    public void kelimesiAratıldığıKontrolEdilir(String text) {
ReusableMethods.waitForPageToLoad(4);
        Log.info("aranan Kelimenin Gelen sayfalardaki kelimle ile karşılaştırılıyor");
        verify_aranan(text);

    }

    @Then("Arama sonuçları sayfasından {int}. sayfa açılır.")
    public void aramaSonuçlarıSayfasındanSayfaAçılır(int sayfa) {
        Log.info("product page de ikinci sayfa gidilir");
        got_to_xPage(sayfa);

    }

    @When("{int}. sayfanın açıldığı kontrol edilir.")
    public void sayfanınAçıldığıKontrolEdilir(int sayfa) {
        Log.info("istenilen sayfanın gelen sayfa oldugu dogrulanır");
   ReusableMethods.waitFor(3);
        verify_xPage(sayfa);
    }
    

    @Given("Sayfadaki {int}. ürün favorilere eklenir.")
    public void sayfadakiÜrünFavorilereEklenir(int urunSirasi) {
        Log.info("Listede ki üçüncü ürün favorilere eklenir");
        select_xProduct(urunSirasi);

    }

    @Then("Hesabım - İstek Listem - Favorilerim sayfasına gidilir.")
    public void hesabımİstekListemFavorilerimSayfasınaGidilir() {
        Log.info("favori sayfasına gideriz");
        click_favoriPage_button();
    }

    @When("Favorilerim sayfası açıldığı kontrol edilir.")
    public void favorilerimSayfasıAçıldığıKontrolEdilir() {
        Log.info("favorilerim sayfasına gidilir");
        verify_favoriPage();
    }

    @Then("Eklenen ürün favorilerden silinir ve silme işlemi kontrol edilir.")
    public void eklenenÜrünFavorilerdenSilinirVeSilmeIşlemiKontrolEdilir() {
        Log.info("eklenen ürün favori listesiden silinir");
delete_product_from_favoriList(1);
verify_delete_product_from_favorlist(1);
    }

    @And("Üye çıkış işlemi yapılır.")
    public void üyeÇıkışIşlemiYapılır() {

        Log.info("Hesaptan çıkış işlemi yapılır");
        cikis_islemi();
        Log.endTestCase("Test Bitti");
    }


}
