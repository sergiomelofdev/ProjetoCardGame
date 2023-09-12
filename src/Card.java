public class Card {
    private String name;
    private String image;
    private String type; 
    private Rarity rarity;
    private int attack;
    private int defense;
    private int cost;
    private String ability;
    private int quantity;

    
    public enum Rarity {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }

    // Construtor
    public Card(String name, String image, String type, Rarity rarity, int attack, int defense, int cost, String ability) {
        this.name = name;
        this.image = image;
        this.type = type;
        this.rarity = rarity;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.ability = ability;
        this.quantity = (type.equals("MANA")) ? Integer.MAX_VALUE : 3; 
    }

    
    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCost() {
        return cost;
    }

    public String getAbility() {
        return ability;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
