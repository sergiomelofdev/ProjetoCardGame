public enum EnumRarityCard{
    //apenas sugestao
    COMMON(0.60), 
    UNCOMMON(0.20),
    RARE(0.14), 
    EPIC(0.05), 
    LEGENDARY(0.01);

    private final double rarity;

    private EnumRarityCard(double rarity) {
        this.rarity = rarity;
    }

    public double getRarity() {
        return rarity;
    }
}