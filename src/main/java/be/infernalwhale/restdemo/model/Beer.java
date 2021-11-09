package be.infernalwhale.restdemo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Beer {
    private Integer id;
    private String beername;
    private Double price;
    @JsonManagedReference
    private Brewer brewer;

    public Beer(Integer id, String beername, Double price, Brewer brewer) {
        this.id = id;
        this.beername = beername;
        this.price = price;
        this.brewer = brewer;
    }

    public Integer getId() {
        return id;
    }

    public Beer setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBeername() {
        return beername;
    }

    public Beer setBeername(String beername) {
        this.beername = beername;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Beer setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public Beer setBrewer(Brewer brewer) {
        this.brewer = brewer;
        return this;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", beername='" + beername + '\'' +
                ", price=" + price +
                '}';
    }
}
