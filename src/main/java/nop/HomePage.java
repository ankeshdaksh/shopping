package nop;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;


public class HomePage extends BasePage {

    static String email;
    static String enterPassword;

    @FindBy(css = ".ico-register")
    WebElement goToRegistration;
    @FindBy(css = "#gender-male")
    WebElement genderMale;
    @FindBy(css = "#FirstName")
    WebElement firstName;
    @FindBy(css = "#LastName")
    WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    WebElement birthDay;
    @FindBy(name = "DateOfBirthMonth")
    WebElement birthMonth;
    @FindBy(name = "DateOfBirthYear")
    WebElement birthYear;
    @FindBy(id = "Email")
    WebElement enterEmail;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(id = "register-button")
    WebElement registerSubmitButton;
    @FindBy(className = "ico-logout")
    WebElement logOUt;
    @FindBy(tagName = "body")
    WebElement registrationUI;
    @FindBy(className = "ico-login")
    WebElement gotoLogin;
    @FindBy(css = "#RememberMe")
    WebElement checkBoxRememberMe;
    @FindBy(css = ".button-1.login-button")
    WebElement loginButton;
    @FindBy(css = ".ico-account")
    WebElement loginlUi;
    @FindBy(css = ".ico-logout")
    WebElement logOutUi;
    @FindBy(css = ".validation-summary-errors>ul>li")
    WebElement unregisterEmailMessage;
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement subCategory;

    @FindBy(linkText = "product")
    WebElement product;
    @FindBy(xpath = "html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[3]/div[2]/input[1]")
    WebElement addCart;
    @FindBy(className = "ico-cart")
    WebElement iconCart;
    @FindBy(css = ".button-2.update-cart-button")
    WebElement updateShoppingCart;
    @FindBy(css = "#checkout")
    WebElement checkoutButton;
    @FindBy(css = "#termsofservice")
    WebElement checkBoxTermOfCondition;
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement selectNewAddressCountry;
    @FindBy(css = "#BillingNewAddress_City")
    WebElement enternNewAddressCity;
    @FindBy(css = "#BillingNewAddress_Address1")
    WebElement enterNewAddress1;
    @FindBy(css = "#BillingNewAddress_ZipPostalCode")
    WebElement postalCode;
    @FindBy(css = "#BillingNewAddress_PhoneNumber")
    WebElement newAddressPhoneNo;
    @FindBy(xpath = ".//*[@id='billing-buttons-container']/input")
    WebElement continueButton;
    @FindBy(css = "#shippingoption_1")
    WebElement shippingOptionNextDay;
    @FindBy(css = ".button-1.shipping-method-next-step-button")
    WebElement shippingContinueButton;
    @FindBy(id = "paymentmethod_0")
    WebElement moneyOrder;
    @FindBy(css = ".button-1.payment-method-next-step-button")
    WebElement paymentMethodNextButton;
    @FindBy(css = ".button-1.payment-info-next-step-button")
    WebElement continueNextStep;
    @FindBy(css = ".button-1.confirm-order-next-step-button")
    WebElement confirmButton;



    public void checkUrlAndTitle() {
        checkUrl();
        checkTitle();
    }

    private void checkTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "nopCommerce demo store");
    }

    private void checkUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("http://demo.nopcommerce.com/"));
    }


    public void gotoRegistration() {
        goToRegistration.click();
        String registerUrl = driver.getCurrentUrl();
        Assert.assertEquals(registerUrl, "http://demo.nopcommerce.com/register");
    }

    public void enterValidDetailForRegistration() throws InterruptedException {
        genderMale.click();
        firstName.sendKeys("FirstName");
        lastName.sendKeys("lastName");
        Select days = new Select(birthDay);
        days.selectByVisibleText("30");

        Select months = new Select(birthMonth);
        months.selectByVisibleText("January");

        Select years = new Select(birthYear);
        years.selectByVisibleText("1980");

        email = (new Random().nextInt() + "monu@hotmail.com");
        enterEmail.sendKeys(email);

        enterPassword = "pass@123";
        password.sendKeys(enterPassword);
        confirmPassword.sendKeys(enterPassword);
        registerSubmitButton.click();
    }

    public void heIsAbleToRegisterSucessfully() {
        checkforRegistration("Your registration completed");
        logOut();

    }

    private void logOut() {
        logOUt.click();
    }

    private void checkforRegistration(String text) {
        //  WebElement registrationUi = driver.findElement(By.tagName("body"));
        registrationUI.getText();
        Assert.assertTrue(registrationUI.getText().contains(text));


    }

    public void nevigateLogin() {
        gotoLogin.click();
        String loginUi = driver.getCurrentUrl();
        Assert.assertTrue(loginUi.contains("http://demo.nopcommerce.com/login"));

    }

    public void enterLoginDetail() {
        provideLoginDetail();
    }

    private void provideLoginDetail() {
        enterEmail.sendKeys(email);
        password.sendKeys(enterPassword);
        checkBoxRememberMe.click();
        loginButton.click();

    }

    public void checkLoginSuccessfully() {
        checkForLoginComplete("Log out");
        checkForLoginComplete();
    }

    private void checkForLoginComplete() {
        Assert.assertTrue(loginlUi.getText().matches(email));
        // Assert.assertTrue(loginlUi.getText().matches(email));
        // we can user contain instead of matches

    }

    private void checkForLoginComplete(String logOut) {
        Assert.assertTrue(logOutUi.getText().contains(logOut));

    }

    public void enterInvalidDetail(String Email, String Password) {
        enterInvalidCredential(Email, Password);
        userIsStillInLoginPage();

    }

    private void userIsStillInLoginPage() {
        String loginUrl = driver.getCurrentUrl();
        Assert.assertTrue(loginUrl.contains("http://demo.nopcommerce.com/login"));
    }

    private void enterInvalidCredential(String email, String passwrd) {
        enterEmail.sendKeys(email);
        password.sendKeys(passwrd);
        loginButton.click();

    }

    public void checkUnregisterEmailError(String Message) {
        unregisterEmailError(Message);
    }

    private void unregisterEmailError(String message) {
        unregisterEmailMessage.getText();
        Assert.assertTrue(unregisterEmailMessage.getText().contains(message));
        System.out.println("Error Message=====" + unregisterEmailMessage.getText());

    }


    public void productTabs(String productTab) {
        product = driver.findElement(By.linkText(productTab));
        product.click();


    }

    public void productTitle() {
        subCategory.click();
        subCategory.getText();
        String productName = subCategory.getText();
        System.out.println("product NAME======" + productName);
        Assert.assertTrue(productName.contains(subCategory.getText()));

    }

    public void countProduct(int count) {
        try {
            WebElement countSubCategory = driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/div[1]/div"));
            // WebElement countSubCategory = driver.findElement(By.cssSelector("div.category-grid.sub-category-grid"));
            List<WebElement> countsItem = countSubCategory.findElements(By.cssSelector("div.item-box"));
            int countSize = countsItem.size();
            System.out.println("product size====" + countSize);
            Assert.assertEquals(count, countSize);
        } catch (NoSuchElementException e) {
            int countItem = 0;
            Assert.assertEquals(count, countItem);


        }
    }

    public void productSelectFromEachCategory(String productTab, String productCategory) {
        productTabs(productTab);
        selectProductCategory(productCategory);
    }

    private void selectProductCategory(String productCategory) {
        subCategory = driver.findElement(By.linkText(productCategory));
        subCategory.click();
    }

    public void itemCount(int count) {
        List<WebElement> items = driver.findElements(By.cssSelector("div.item-box"));
        int itemCounts = items.size();
        Assert.assertEquals(count, itemCounts);

    }

    public void selectProduct(String productCategory) {
        selectItem(productCategory);
        addCart();
    }

    private void addCart() {
        List<WebElement> item = driver.findElements(By.cssSelector(".product-item"));
        int itemCount = item.size();
        System.out.println("item count======" + itemCount);
        WebElement itemOne = item.get(1);
        addCart.click();
        iconCart.click();
        Assert.assertTrue(item.add(itemOne));
    }

    private void selectItem(String productCategory) {
        WebElement product = driver.findElement(By.linkText(productCategory));
        product.click();

    }

    public void checkOutAndOrderDetail() {
        updateShoppingCart.click();
        checkBoxTermOfCondition.click();
        checkoutButton.click();
    }

    public void shippingBillingAddress() {
        selectNewAddressCountry.sendKeys("United Kingdom");
        enternNewAddressCity.sendKeys("Harrow");
        enterNewAddress1.sendKeys("Flate-5,ChesterCourt");
        postalCode.sendKeys("ha12jb");
        newAddressPhoneNo.sendKeys("999999999");
        continueButton.click();
    }


    public void checkOutOrderDetail() throws InterruptedException {
        Thread.sleep(1000);
        shippingOptionNextDay.click();
        shippingContinueButton.click();
        moneyOrder.click();
        paymentMethodNextButton.click();
       // continueNextStep.click();
        WebDriverWait confirm = new WebDriverWait(driver, 30);
        confirm.until(ExpectedConditions.elementToBeClickable(continueNextStep));
        continueNextStep.click();
        Thread.sleep(1000);
        confirmButton.click();
        Thread.sleep(1000);

        WebElement thankssMsg = driver.findElement(By.xpath("html/body/div[5]/div[3]/div/div/div/div[2]/div/div[1]/strong"));
       // WebElement thankssMsg = driver.findElement(By.xpath("//div[@class='title']/strong"));
        String thanksMsgText = thankssMsg.getText();
        System.out.println(thanksMsgText);
        Assert.assertEquals(thanksMsgText, "Your order has been successfully processed!");

        WebElement orderConfirm = driver.findElement(By.linkText("Click here for order details."));
        orderConfirm.click();

//        DateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM, DD, yyyy");
//        Date date = new Date();
//        String currentDate = ("Web Date==="+dateFormat.format(date));



    }

}













