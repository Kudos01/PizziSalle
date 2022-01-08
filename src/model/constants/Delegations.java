package model.constants;

public enum Delegations {
    Barcelona("Barcelona"),
    Girona("Girona"),
    Tarragona("Tarragona"),
    Lleida("Lleida");

    private final String val;

    Delegations(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
