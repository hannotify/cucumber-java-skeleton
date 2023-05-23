package io.cucumber.skeleton;

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

    @When("I add a banana to my basket")
    public void i_add_a_banana_to_my_basket() {
        basket.add("banana");
    }

    @Then("my basket contains a banana")
    public void my_basket_contains_a_banana() {
        assertTrue(basket.getContents().contains("banana"));
    }
}
