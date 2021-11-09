package be.infernalwhale.restdemo.model;

public class BrewerDTO {
    private String name;

    public BrewerDTO(Brewer brewer) {
        this.name = brewer.getName();
    }

    public String getName() {
        return name;
    }

    public BrewerDTO setName(String name) {
        this.name = name;
        return this;
    }
}
