package ee.rebecca.api.entity;

public class product {
    public int id;
    public String name;
    public double price;
    public boolean active;
    public product(){
    }
    public product(String name, double price){
        this.id = (int) (Math.random()* 9);
        this.name = name;
        this.active = true;
    }
}
