package Model.constants;

public enum Topping {
    Ham("Ham"),
    Pineapple("Pineapple"),
    Chicken("Chicken"),
    Bacon("Bacon"),
    Frankfurt("Frankfurt"),
    Egg("Egg"),
    Sausage("Sausage"),
    Onion("Onion"),
    Miniburgers("Miniburgers"),
    Tuna("Tuna"),
    Pepperoni("Pepperoni"),
    Olives("Olives"),
    BBQ_Sauce("BBQ sauce"),
    Cheddar("Cheddar"),
    Roquefort("Roquefort"),
    Tomato_slices("Tomato slices"),
    Anchovies("Anchovies"),
    Prawns("Prawns"),
    Beef("Beef"),
    Carbonara_sauce("Carbonara sauce"),
    Mushrooms("Mushrooms"),
    Jamon_serrano("Jamon"),
    Mozzarella("Mozzarella"),
    Emmental("Emmental"),
    Bell_peppers("Bell peppers"),
    Artichoke("Artichoke"),
    Brie("Brie"),
    Goat_cheese("Goat cheese"),
    Sobrasada("Sobrasada"),
    Honey("Honey");

    private final String val;

    Topping(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
