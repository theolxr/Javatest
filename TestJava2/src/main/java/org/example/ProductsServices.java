package org.example;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductsServices {
    private final List<Products> products;

    public ProductsServices(List<Products> products) {
        this.products = products;
    }

    public List<Products> filterProdsByPrice(double minPrice, double maxPrice) {
        return products.stream().filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    public List<Products> sortProdsByName() {
        return products.stream().sorted(Comparator.comparing(Products::getName)).collect(Collectors.toList());
    }

    public Map<String, Integer> groupProdsByQuantity() {
        return products.stream().collect(Collectors.groupingBy(Products::getName, Collectors.summingInt(Products::getQuantity)));
    }

    public double totalStockValue() {
        return products.stream().mapToDouble(Products::getPrice).sum();
    }

    public Products mostExpensiveProd() {
        return products.stream().max(Comparator.comparing(Products::getPrice)).orElse(null);
    }

    public List<Products> getProdsWithFutExpDate() {
        return products.stream().filter(product -> product.getExpirationDate().isAfter(LocalDate.now())).collect(Collectors.toList());
    }
}
