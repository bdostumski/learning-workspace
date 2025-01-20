import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterCollection {

    private static class Product {
        int id;
        String name;
        float price;

        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product(1,"HP Laptop",25000f));
        productList.add(new Product(2,"Dell Laptop",30000f));
        productList.add(new Product(2,"Lenovo ThinkPad",30000f));
        productList.add(new Product(3,"Lenevo Laptop",28000f));
        productList.add(new Product(4,"Sony Laptop",28000f));
        productList.add(new Product(4,"Sony Laptop",10000f));
        productList.add(new Product(4,"Sony Laptop",9999f));
        productList.add(new Product(5,"Apple Laptop",90000f));

        List<Float> price = productList.stream().map(p -> p.price).filter(p -> p <= 30000).collect(Collectors.toList());

        price.stream().filter(e -> e % 2 == 0).limit(3).forEach(s -> System.out.printf("%.0f ", s));

        System.out.println();

        Stream.iterate(1, e -> e + 1).filter(e -> e % 2 == 0).limit(10).forEach(e -> System.out.printf("%d ", e));

        System.out.println();

        productList.stream().filter(p -> p.price == 30000).forEach(p -> System.out.println(p.name + " - " + p.price));

        float totalPrice = productList.stream().map(product -> product.price).reduce(0.0f, Float::sum);
        System.out.println(totalPrice);

        Product productA = productList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1).get();
        System.out.println(productA.name);

        long count = productList.stream().filter(p -> p.price == 30000).count();
        System.out.println(count);

    }

}
