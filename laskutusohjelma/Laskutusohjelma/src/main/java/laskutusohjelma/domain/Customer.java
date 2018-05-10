
package laskutusohjelma.domain;


public class Customer {
    private Integer id;
    private String name; 
    private String yTunnus;
    
    public Customer(Integer id, String name, String yTunnus) {
        this.id = id;
        this.name = name;
        this.yTunnus = yTunnus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public String getyTunnus() {
        return this.yTunnus;
    }

    public void setyTunnus(String yTunnus) {
        this.yTunnus = yTunnus;
    }
    
    @Override
    public String toString() {
        return "" + this.name;
    }
}
