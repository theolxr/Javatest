package org.example;

import java.time.LocalDate;
import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        List<Products> products = new ArrayList<>();
        products.add(new Products("Covrigi cu grau", 9, 20.0, false, LocalDate.of(2025, 8, 6)));
        products.add(new Products("Apa", 200, 9.0, true, LocalDate.of(2024, 12, 12)));
        products.add(new Products("Twix", 120, 14.0, true, LocalDate.of(2023, 5, 28)));
        products.add(new Products("Cola", 60, 18.5, false, LocalDate.of(2034, 4, 30)));
        products.add(new Products("Betisoare cu lapte condensat", 40, 35.5, true, LocalDate.of(2026, 12, 31)));

        ProductsServices ps = new ProductsServices(products);

        while( !false ) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\tMeniu ");
            System.out.println("1. Filtrare dupa pretul produsului");
            System.out.println("2. Grupare produselor dupa cantitate");
            System.out.println("3. Sortare produselor dupa nume");
            System.out.println("4. Valoarea totala a stock-ului produselor");
            System.out.println("5. Cel mai scump produs din lista");
            System.out.println("6. Produse cu data de expirare în viitor");

            Scanner sc = new Scanner(System.in);

            int x = sc.nextInt();

            switch(x) {
                case 1: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nIntrodu pretul pentru produs min si max: ");
                    double minPrice, maxPrice;
                    minPrice = sc.nextDouble();
                    maxPrice = sc.nextDouble();

                    products = ps.filterProdsByPrice(minPrice, maxPrice);

                    int i = 0;
                    for (Products product : products) {
                        i++;
                        System.out.println(i + ". " + product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }


                case 2: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nGrupare produselor dupa cantitate: ");
                    Map<String, Integer> productsMap = new HashMap<>();
                    productsMap = ps.groupProdsByQuantity();
                    int i = 0;

                    for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
                        String productName = entry.getKey();
                        Integer quantity = entry.getValue();
                        System.out.println(++i + ". " + productName + " " + quantity);
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 3: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nSortare produselor dupa nume: ");
                    products = ps.sortProdsByName();
                    int i = 0;

                    for (Products product : products) {
                        i++;
                        System.out.println(i + ". " + product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }



                case 4: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nValoarea totala a stock-ului produselor: ");
                    DecimalFormat df = new DecimalFormat("#.##");
                    System.out.println(df.format(ps.totalStockValue()) + " lei");

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 5: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nCel mai scump produs din lista: ");
                    Products mostExpensive = ps.mostExpensiveProd();

                    System.out.println(mostExpensive.getName() + " " + mostExpensive.getPrice() + "lei");

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 6: {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nProduse cu data de expirare în viitor: ");
                    products = ps.getProdsWithFutExpDate();
                    int i = 0;

                    for (Products product : products) {
                        i++;
                        System.out.println(i + ". " + product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }

                    sc.nextLine();
                    sc.nextLine();
                    break;
                }
                default: {
                    System.out.println("A fost o eroare!!!");
                }
            }
        }
    }
}