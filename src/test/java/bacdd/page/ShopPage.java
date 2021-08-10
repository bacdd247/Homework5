package bacdd.page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends PageFactory{
    WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
//    @FindBy(xpath = "//div[contains(@class,'price_slider ui-slider')]")
//    WebElement filterByPriceSlider;
    @FindBy(xpath = "//span[@class='onsale']")
    WebElement saleProductAndroid;
    @FindBy(xpath = "//a[@title='View Basket']")
    WebElement btnViewBasket;
//    @FindBy(xpath = "")
//    WebElement ;
//    @FindBy(xpath = "")
//    WebElement ;

    public void adjustThePrice(String leftPrice, String rightPrice) {

    }

    String partiProd;
    public void clickOnProductCategory(String prodCate) {
        String prodCateXpath = "//a[contains(text(),'" + prodCate + "')]";
        WebElement productCategory = driver.findElement(By.xpath(prodCateXpath));
        productCategory.click();
        partiProd = prodCate;
    }

    public void verifyPartiProd()   {
        String partiProdXpath = "//a[contains(text(),'" + partiProd + "')]";
        WebElement productCategory = driver.findElement(By.xpath(partiProdXpath));
        Assert.assertTrue(productCategory.isDisplayed());
    }

    String  valueSortXpath;
    public void clickSortDropdown(String valueSort) {
        valueSortXpath = "//option[contains(text(),'" + valueSort + "')]";
        WebElement valueSortProd = driver.findElement(By.xpath(valueSortXpath));
        valueSortProd.click();
    }

    public void verifyPopularProduct()  {
        WebElement valueSortProd = driver.findElement(By.xpath(valueSortXpath));
        Assert.assertEquals("true",valueSortProd.getAttribute("selected"));
    }

    public void clickOnSale()   {
        saleProductAndroid.click();
    }

    public void clickOnAddProductToCard(String productName)   {
        String addProductToCartXpath = "//h3[text()='" + productName + "']//ancestor::li//a[contains(@class,'add_to_cart')]";
        WebElement btnAddProductToCart = driver.findElement(By.xpath(addProductToCartXpath));
        btnAddProductToCart.click();
    }

    public void clickBtnViewBasket()    {
        btnViewBasket.click();
    }

}
