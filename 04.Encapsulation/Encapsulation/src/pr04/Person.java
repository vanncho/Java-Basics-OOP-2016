package pr04;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    public void setName(String name) {

        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setMoney(double money){

        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getBag() {
        return bag;
    }

    public void addProductToBag(Product product){

        if (canBuyProduct(product.getCost())){
            System.out.printf("%s bought %s%n", this.name, product.getName());
            this.bag.add(product);
            this.money -= product.getCost();
        } else {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
        }
    }

    private boolean canBuyProduct(double money){

        if (this.money >= money){
            return true;
        }else {
            return false;
        }
    }
}
