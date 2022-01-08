package Model.constants;

public enum NamedPizza {
    Basic("Basic"),
    Hawaiian("Hawaiian"),
    Bacon_Crispy("Bacon_Crispy"),
    American("American"),
    Traviata("Traviata"),
    Burger("Burger"),
    Castellera("Castellera"),
    Cowboy("Cowboy"),
    Texas("Texas"),
    Coast("Coast"),
    BBQ("BBQ"),
    Diablo("Diablo"),
    Carbonara("Carbonara"),
    Spanish("Spanish"),
    Four_Cheeses("Four cheeses"),
    Pepperoni("Pepperoni"),
    Vegetal("Vegetal"),
    Barcelona("Barcelona"),
    Girona("Girona"),
    Tarragona("Tarragona"),
    Lleida("Lleida"),
    Six_Cheeses("Six cheeses"),
    Mallorca("Mallorca"),
    Carbonara_Deluxe("Carbonara deluxe");

    private final String val;

    NamedPizza(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
