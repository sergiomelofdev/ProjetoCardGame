public class Card {
    private String name;
    private String image;
    private String type; 
    private EnumRarityCard rarity;
    private int power;
    private int timeEnergy;
    private String ability;
    private int idCard;


    // Construtor
    public Card(String name, String image, String type, int power, int timeEnergy, String ability) {
        this.name = name;
        this.image = image;
        this.type = type;
        this.rarity = ;
        this.power = power;
        this.timeEnergy = timeEnergy;
        this.ability = ability;
    }

    public EnumRarityCard generateRarityCard() {
        double numeroAleatorio = Math.random();

        double chanceAcumulada = 0.0;
        for (EnumRarityCard rarity : EnumRarityCard.values()) {
            chanceAcumulada += rarity.getRarity();
            if (numeroAleatorio < chanceAcumulada) {
                return rarity;
            }
        }

        return EnumRarityCard.COMMON;
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

    public EnumRarityCard getRarity() {
        return rarity;
    }

    public int getPower() {
        return power;
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
