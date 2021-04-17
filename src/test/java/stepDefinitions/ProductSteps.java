package stepDefinitions;

import helpers.JSHelpers;
import helpers.SeleniumHelpers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.experimental.categories.Categories;
import pages.HomePage;
import pages.ProductListPage;
import product.Product;
import product.ProductFactory;


public class ProductSteps {
    HomePage homePage = new HomePage();
    ProductListPage productList = new ProductListPage();
    Product product ;
    ProductFactory productFactory = ProductFactory.getProductInstance();


    @When("^Click on the (.*?) category title from the top menu$")
    public void clickGivenCategoryOnTheTopMenu(String catName) throws Exception {
      //catName = onlyTheFirtsLetter(catName);
        try{
            homePage.clickCategory(catName);
        } catch (Exception e){
            Assert.fail("No category found with " + catName);
        }


        product = ProductFactory.getProductInstance().getProduct(catName);
    }

    @When("^Click on the (.*?) subcategory that is under (.*?) category title$")
    public void clickSubCategoryOnTheTopMenu(String subCategory, String category) throws Exception {

        homePage.hoverAndClickSubcategory(category,subCategory);
        product = ProductFactory.getProductInstance().getProduct(category);

    }

    @When("^Click on the Add to cart button for the \"(\\d+)\". ranked product$")
    public void clickAddToCartButtonOnRankedPRoduct(int rank) throws InterruptedException {
        product.name(productList.getProductNameForNTHRank(rank));
        product.price(productList.getProductPriceeForNTHRank(rank));
        productList.clickAddToCartForNTHRank(rank);

        productFactory.removeEmptyObject();

    }

    @Then("^Should see \"(.*?)\" category title$")
    public void shouldSeeGivenCategoryTitle(String title){
        productList.validateCategoryTitle(title);

    }







}
