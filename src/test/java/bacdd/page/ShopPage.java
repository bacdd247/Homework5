package bacdd.page;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage extends PageFactory{
    WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class='onsale']")
    WebElement saleProductAndroid;
    @FindBy(xpath = "//a[@title='View Basket']")
    WebElement btnViewBasket;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnFilter;
    @FindBy(xpath = "//img[contains(@class,'attachment')]")
    List<WebElement> listProduct;



    public void adjustThePrice(String leftPrice, String rightPrice) {
        By rightsliderXpath = By.xpath("//span[contains(@style,'left: 100%')]");
        WebElement rightslider = driver.findElement(rightsliderXpath);
        rightslider.click();
        for (int i = 500 ; i > Integer.parseInt(rightPrice); i --) {
            rightslider.sendKeys(Keys.ARROW_LEFT);
        }
        By leftsliderXpath = By.xpath("//span[contains(@style,'left: 0%')]");
        WebElement leftslider = driver.findElement(leftsliderXpath);
        leftslider.click();
        for (int i = 150 ; i < Integer.parseInt(leftPrice); i ++) {
            leftslider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void  clickOnFilterBtn() {
        btnFilter.click();
    }
    public void verifyProductByPrice(String minPrice, String maxPrice)  {
        long price;
        for (int i = 1; i < listProduct.size() + 1 ; i ++) {
            By productPriceXpath1 = By.xpath("//li[" + i + "]//span[contains(@class,'Price-amount')]");
            List<WebElement> listPrice = driver.findElements(productPriceXpath1);
                if (listPrice.size() ==2)  {
                    By productPriceXpath2 = By.xpath("//li[" + i + "]//ins//span[contains(@class,'Price-amount')]");
                    WebElement productPrice2 = driver.findElement(productPriceXpath2);
                    price = Long.parseLong(productPrice2.getText().replace("₹","").replace(".00",""));
                    System.out.println("sale price product " + i +": " + price);
                }   else   {
                WebElement productPrice1 = driver.findElement(productPriceXpath1);
                price = Long.parseLong(productPrice1.getText().replace("₹","").replace(".00",""));
                System.out.println("price product " + i +": " + price);
                }
            Assert.assertTrue( price >= Long.parseLong(minPrice) && price <= Long.parseLong(maxPrice));
        }

    }
    String partiProd;
    public void clickOnProductCategory(String prodCate) {
        By prodCateXpath = By.xpath("//a[contains(text(),'" + prodCate + "')]");
        WebElement productCategory = driver.findElement(prodCateXpath);
        productCategory.click();
        partiProd = prodCate;
    }

    public void verifyPartiProd()   {
        By partiProdXpath = By.xpath("//a[contains(text(),'" + partiProd + "')]");
        WebElement productCategory = driver.findElement(partiProdXpath);
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
        By addProductToCartXpath = By.xpath("//h3[text()='" + productName + "']//ancestor::li//a[contains(@class,'add_to_cart')]");
        WebElement btnAddProductToCart = driver.findElement(addProductToCartXpath);
        btnAddProductToCart.click();
    }

    public void clickBtnViewBasket()    {
        btnViewBasket.click();
    }


}
