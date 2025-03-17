import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;


class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + '}';
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200));
        products.add(new Product("Smartphone", "Electronics", 800));
        products.add(new Product("Chair", "Furniture", 150));
        products.add(new Product("Table", "Furniture", 300));
        products.add(new Product("TV", "Electronics", 600));
        products.add(new Product("Sofa", "Furniture", 700));

        // Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(product -> product.category));

        // Find the most expensive product in each category
        Map<String, Product> mostExpensiveProduct = products.stream()
                .collect(Collectors.groupingBy(product -> product.category,
                        Collectors.maxBy(Comparator.comparingDouble(product -> product.price))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().orElse(null)));

        // Calculate the average price of all products
        DoubleSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingDouble(product -> product.price));

        // Print results
        System.out.println("Grouped Products by Category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveProduct.forEach((category, product) -> {
            System.out.println(category + ": " + product);
        });

        System.out.println("\nAverage Price of All Products: " + stats.getAverage());
    }
}
