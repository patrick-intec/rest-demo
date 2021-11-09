package be.infernalwhale.restdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Brewer {
    private String name;
    @JsonBackReference
    private Beer beer;

    public Brewer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Brewer setName(String name) {
        this.name = name;
        return this;
    }

    public Beer getBeer() {
        return beer;
    }

    public Brewer setBeer(Beer beer) {
        this.beer = beer;
        return this;
    }
}
