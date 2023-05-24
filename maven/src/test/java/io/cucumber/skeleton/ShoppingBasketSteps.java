package io.cucumber.skeleton;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingBasketSteps {
    private ShoppingBasket basket;

    @Given("I have an empty basket")
    public void i_have_an_empty_basket() {
        basket = new ShoppingBasket();
    }

    @When("I add a {string} to my basket")
    public void i_add_a_product_to_my_basket(String product) {
        basket.add(product);
    }

    @Then("my basket contains a {string}")
    public void my_basket_contains_a_banana(String product) {
        assertTrue(basket.getProducts().contains(product));
    }

    @When("I add {int} {string}(s) to my basket")
    public void iAddCarrotsToMyBasket(int count, String product) {
        IntStream.rangeClosed(1, count).forEach(i -> i_add_a_product_to_my_basket(product));
    }

    @Given("I have the following products in my basket")
    public void iHaveTheFollowingProductsInMyBasket(List<ProductCount> productCounts) {
        i_have_an_empty_basket();
        productCounts.forEach(pc -> basket.add(pc.product, pc.count));
    }

    @DataTableType
    public ProductCount productCount(Map<String, String> entry) {
        return new ProductCount(Integer.parseInt(entry.get("count")), entry.get("product"));
    }

    @Then("my basket contains")
    public void myBasketContains(List<ProductCount> productCounts) {
        System.out.println(basket);
        productCounts.forEach(pc -> assertTrue(basket.contains(pc.product, pc.count)));
    }

    @When("I remove from my basket")
    public void iRemoveFromMyBasket(List<ProductCount> productCounts) {
        productCounts.forEach(pc -> basket.remove(pc.product, pc.count));
    }

    static class ProductCount {
        int count;
        String product;

        public ProductCount(int count, String product) {
            this.count = count;
            this.product = product;
        }
    }
}
