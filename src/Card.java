public class Card {
    private String name;
    private String image;
    private String type; 
    private Rarity rarity;
    private int attack;
    private int defense;
    private int timeEnergy;
    private String ability;
    private int idCard;

    
    public enum Rarity {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }
    //sugestao: enumerar tambem os tipo se cartas

    // Construtor
    public Card(String name, String image, String type, Rarity rarity, int attack, int defense, int timeEnergy, String ability) {
        this.name = name;
        this.image = image;
        this.type = type;
        this.rarity = rarity;
        this.attack = attack;
        this.defense = defense;
        this.timeEnergy = timeEnergy;
        this.ability = ability;
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

    public int gettimeEnergy() {
        return timeEnergy;
    }

    public String getAbility() {
        return ability;
    }
    public int getIdCard() {
        return idCard;
    }
    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }
}
