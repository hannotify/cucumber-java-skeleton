package io.cucumber.skeleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class ShoppingBasket {
    private final Map<String, Integer> products = new HashMap<>();

    public void add(String product) {
        add(product, 1);
    }

    public void add(String product, int increment) {
        if (product == null || product.isBlank()) {
            return;
        }

        var count = products.getOrDefault(product, 0);
        products.put(product, count + increment);
    }

    public Set<String> getProducts() {
        return products.keySet();
    }

    public boolean contains(String product, int count) {
        return products.containsKey(product) && products.get(product) == count;
    }

    public void remove(String product, int decrement) {
        var count = products.get(product);
        products.put(product, count - decrement);
    }

    @Override
    public String toString() {
        return products.toString();
    }

    public void clear() {
        products.clear();
    }
}
