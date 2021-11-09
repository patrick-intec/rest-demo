package be.infernalwhale.restdemo.model;

public class BeerDTO {
    private Integer id;
    private String beername;
    private BrewerDTO brewer;

    public BeerDTO(Beer beer) {
        this.id = beer.getId();
        this.beername = beer.getBeername();
        this.brewer = new BrewerDTO(beer.getBrewer());
    }

    public Integer getId() {
        return id;
    }

    public BeerDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBeername() {
        return beername;
    }

    public BeerDTO setBeername(String beername) {
        this.beername = beername;
        return this;
    }

    public BrewerDTO getBrewer() {
        return brewer;
    }

    public BeerDTO setBrewer(BrewerDTO brewer) {
        this.brewer = brewer;
        return this;
    }
}
