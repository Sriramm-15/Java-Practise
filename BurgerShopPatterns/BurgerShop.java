import java.util.*;
import java.util.function.Function;
public class BurgerShop {
    interface Burger {
        String getDescription();
        double getPrice();
    }
    static class BaseBurger implements Burger {
        @Override
        public String getDescription() {
            return "Base Burger";
        }
        @Override
        public double getPrice() {
            return 60.0;
        }
    }
    static abstract class BurgerDecorator implements Burger {
        protected Burger burger;
        public BurgerDecorator(Burger burger) {
            this.burger = burger;
        }
    }
    static class Cheese extends BurgerDecorator {
        public Cheese(Burger burger) {
            super(burger);
        }
        @Override
        public String getDescription() {
            return burger.getDescription() + ", Cheese";
        }
        @Override
        public double getPrice() {
            return burger.getPrice() + 10.0;
        }
    }
    static class Tomato extends BurgerDecorator {
        public Tomato(Burger burger) {
            super(burger);
        }
        @Override
        public String getDescription() {
            return burger.getDescription() + ", Tomato";
        }
        @Override
        public double getPrice() {
            return burger.getPrice() + 7.0;
        }
    }
    static class Onion extends BurgerDecorator {
        public Onion(Burger burger) {
            super(burger);
        }
        @Override
        public String getDescription() {
            return burger.getDescription() + ", Onion";
        }
        @Override
        public double getPrice() {
            return burger.getPrice() + 5.0;
        }
    }
    static class Ketchup extends BurgerDecorator {
        public Ketchup(Burger burger) {
            super(burger);
        }
        @Override
        public String getDescription() {
            return burger.getDescription() + ", Ketchup";
        }
        @Override
        public double getPrice() {
            return burger.getPrice() + 3.0;
        }
    }
    static class Mayo extends BurgerDecorator {
        public Mayo(Burger burger) {
            super(burger);
        }
        @Override
        public String getDescription() {
            return burger.getDescription() + ", Mayo";
        }
        @Override
        public double getPrice() {
            return burger.getPrice() + 4.5;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Burger burger = new BaseBurger();
        Map<Integer, Function<Burger, Burger>> toppings = new HashMap<>();
        toppings.put(1, Cheese::new);
        toppings.put(2, Onion::new);
        toppings.put(3, Tomato::new);
        toppings.put(4, Ketchup::new);
        toppings.put(5, Mayo::new);
        System.out.println("Enter topping numbers for making burgir:");
        System.out.println("1.Cheese 2.Onion 3.Tomato 4.Ketchup 5.Mayo");
        while (true) {
            int choice = sc.nextInt();
            if (choice == 0) break;
            if (toppings.containsKey(choice)) {
                burger = toppings.get(choice).apply(burger);
            } else {
                System.out.println("Invalid choice,exist and choose again");
            }
        }
        System.out.println("Your order is ready");
        System.out.println("\n Description of your Order: " + burger.getDescription());
        System.out.println("\n Total Cost of your Order: Rs. " + burger.getPrice());
        sc.close();
    }
}
