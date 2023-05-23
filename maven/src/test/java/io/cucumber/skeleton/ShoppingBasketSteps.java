package io.cucumber.skeleton;

import java.util.stream.IntStream;

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
        assertTrue(basket.getContents().contains(product));
    }

    @When("I add {int} {string}(s) to my basket")
    public void iAddCarrotsToMyBasket(int count, String product) {
        IntStream.rangeClosed(1, count).forEach(i -> i_add_a_product_to_my_basket(product));
    }

    @Then("my basket contains {int} {string}s")
    public void myBasketContainsCarrotS(int count, String product) {

    }

}
