package nop;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    HomePage homePage = new HomePage();

    @Given("^user is on home page$")
    public void userIsOnHomePage() throws Throwable {
        homePage.checkUrlAndTitle();
    }

    @When("^he enter his valid detail for registration$")
    public void heEnterHisValidDetailForRegistration() throws Throwable {
        homePage.gotoRegistration();
        homePage.enterValidDetailForRegistration();
    }

    @Then("^he able to register successfully$")
    public void heAbleToRegisterSuccessfully() throws Throwable {
        homePage.heIsAbleToRegisterSucessfully();


    }

    @When("^he nevigage to login page$")
    public void heNevigageToLoginPage() throws Throwable {
        homePage.nevigateLogin();

    }

    @And("^provide valid login detai$")
    public void provideValidLoginDetai() throws Throwable {
        homePage.enterLoginDetail();

    }

    @Then("^he is able to login successfully$")
    public void heIsAbleToLoginSuccessfully() throws Throwable {
        homePage.checkLoginSuccessfully();


    }

    @And("^enter invalid \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterInvalid(String email, String password) throws Throwable {
        homePage.enterInvalidDetail(email, password);

    }

    @Then("^he is not able to login successfully and receved Error \"([^\"]*)\"$")
    public void heIsNotAbleToLoginSuccessfullyAndRecevedError(String message) throws Throwable {
        homePage.checkUnregisterEmailError(message);

    }

    @When("^he looks product in \"([^\"]*)\"$")
    public void heLooksProductIn(String productTab) throws Throwable {
        homePage.productTabs(productTab);
        homePage.productTitle();


    }

    @Then("^\"([^\"]*)\" categories  relating to  selected  should be displayed$")
    public void categoriesRelatingToSelectedShouldBeDisplayed(int productCount) throws Throwable {
        homePage.countProduct(productCount);


    }


    @And("^select the \"([^\"]*)\" from \"([^\"]*)\"$")
    public void selectTheFrom(String productTab, String productCategory) throws Throwable {
        homePage.productSelectFromEachCategory(productCategory, productTab);


    }

    @Then("^we can see the product \"([^\"]*)\"$")
    public void weCanSeeTheProduct(int count) throws Throwable {
        homePage.itemCount(count);

    }

    @Then("^select the product from \"([^\"]*)\" and add to the Cart$")
    public void selectTheProductFromAndAddToTheCart(String productCategory) throws Throwable {
        homePage.selectProduct(productCategory);

    }


    @Then("^update shopping Cart$")
    public void updateShoppingCart() throws Throwable {
       homePage.checkOutAndOrderDetail();
       homePage.shippingBillingAddress();
       homePage.checkOutOrderDetail();
    }
}
