package utilities.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class WebElements {
    private WebDriver driver = Driver.getDriver();
    List<WebElement> secilenUrun;


    By aramaInpuBox = By.cssSelector("[id=\"searchData\"]");
    By sign_in_button = By.cssSelector("[class=\"btnSignIn\"]");
    By loginPage_email_input_box = By.cssSelector("[id=\"email\"]");
    By loginPage_password_input_box = By.cssSelector("[id=\"password\"]");
    By loginPage_girisYap_buton = By.cssSelector("[id=\"loginButton\"]");
    By header_favorilerim_button = By.cssSelector("[title=\"Favorilerim\"]");
    By productPage_secondPage_button = By.xpath("//div[@class=\"pagination\"]//a[2]");
    By header_hesabim_buton = By.xpath("//div[@class=\"customMenu hMedMenu-item\"]//div[5]");
    By underHesabim_favorilerim_button = By.xpath("//div[@class=\"hOpenMenuContent\"]//a[2]");
    By favoriPage_favoriList_button = By.xpath("(//ul[@class=\"wishGroupList\"]//h4)[1]");
    By favoriPage_h2Text = By.xpath("//div[@class=\"accContent \"]//h2");
    By confirm_delete_buton_from_popoup = By.cssSelector("[class=\"btn btnBlack confirm\"]");
    By underHesabim_cikis_button = By.xpath("//div[@class=\"hOpenMenuContent\"]//a[10]");
    By favoriOage_emptyList = By.cssSelector("[class=\"emptyWatchList hiddentext\"]");

    public void click_sign_in() {
        driver.findElement(sign_in_button).click();
    }

    public void aramaInputText(String text) {
        driver.findElement(aramaInpuBox).sendKeys(text + Keys.ENTER);
    }

    public void email_input() {
        driver.findElement(loginPage_email_input_box).sendKeys(ConfigReader.getProperty("email"));
    }

    public void password_input() {
        driver.findElement(loginPage_password_input_box).sendKeys(ConfigReader.getProperty("password"));
    }

    public void click_girisYap_button() {
        driver.findElement(loginPage_girisYap_buton).click();
    }

    public void verify_favoriElements_button() {
        Assert.assertTrue(driver.findElement(header_favorilerim_button).isDisplayed());
    }

    public void verify_aranan(String aranan) {
        ReusableMethods.waitForPageToLoad(3);
        String expected = "https://www.n11.com/arama?q=" + aranan;
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(expected, actual);

    }

    public void got_to_xPage(int page) {
        String path = "//div[@class=\"pagination\"]//a[" + page + "]";
        ReusableMethods.scrollIntoVIewJS(driver.findElement(By.xpath(path)));
        ReusableMethods.waitFor(2);
        driver.findElement(By.xpath(path)).click();
    }

    public void verify_xPage(int page) {
        String expected = "https://www.n11.com/arama?q=iphone&pg=" + page;
        String actual = driver.getCurrentUrl().replaceAll("I", "i");
        Assert.assertEquals(expected, actual);
    }

    public void select_xProduct(int product) {
        String path = "(//span[@title=\"Favorilere ekle\"])[" + product + "]";
        driver.findElement(By.xpath(path)).click();
    }

    public void click_favoriPage_button() {
        // driver.findElement(header_favorilerim_button).click();
        Actions actions = new Actions(driver);
        ;
        actions.moveToElement(driver.findElement(header_hesabim_buton)).perform();
        ReusableMethods.waitFor(2);
        driver.findElement(underHesabim_favorilerim_button).click();
        ReusableMethods.waitForVisibility(favoriPage_favoriList_button, 3);
        driver.findElement(favoriPage_favoriList_button).click();

    }

    public void verify_favoriPage() {
        Assert.assertTrue(driver.findElement(favoriPage_h2Text).getText().contains("Favorilerim"));
    }

    public void delete_product_from_favoriList(int urunSirasi) {
        secilenUrun = driver.findElements(By.xpath("(//h3[@class=\"productName \"])[1]"));
        String path = "(//span[@class=\"deleteProFromFavorites\"])[" + urunSirasi + "]";
        driver.findElement(By.xpath(path)).click();
        driver.findElement(confirm_delete_buton_from_popoup).click();
    }

    public void verify_delete_product_from_favorlist(int urun) {

        ReusableMethods.waitForVisibility(favoriOage_emptyList, 4);
        Assert.assertTrue(driver.findElement(favoriOage_emptyList).isDisplayed());

    }

    public void cikis_islemi() {

        ReusableMethods.hover(driver.findElement(header_hesabim_buton));
        ReusableMethods.waitFor(3);
        driver.findElement(underHesabim_cikis_button).click();
    }
}