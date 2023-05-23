package io.cucumber.skeleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingBasket {
    private static final Map<String, Integer> products = new HashMap<>();

    public void add(String product) {
        var count = products.getOrDefault(product, 0);
        products.put(product, ++count);
    }

    public Set<String> getContents() {
        return products.keySet();
    }
}
