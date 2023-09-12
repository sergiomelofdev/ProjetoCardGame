public class Inventory {
    private Card[] cards;
    private int nivel;
    private int cardCoins;
    
    private static int MAX_CARDS = 200;
    
    public Inventory() {
        this.cards = new Card[MAX_CARDS];
        this.nivel = 1;
        this.cardCoins = 0;
    }
    
    public Card[] getCards() {
        return cards;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCardCoins() {
        return cardCoins;
    }

    public void setCardCoins(int cardCoins) {
        this.cardCoins = cardCoins;
    }

    public void decrementCardQuantity(Card card) {
        if (card != null) {
            for (Card inventoryCard : cards) {
                if (inventoryCard.getName().equals(card.getName())) {
                    int currentQuantity = inventoryCard.getQuantity();
                    if (currentQuantity > 0) {
                        inventoryCard.setQuantity(currentQuantity - 1);
                    }
                    break; // Apenas uma carta pode ser decrementada de cada vez
                }
            }
        }
    }

    public void incrementCardQuantity(Card card) {
        if (card != null) {
            for (Card inventoryCard : cards) {
                if (inventoryCard.getName().equals(card.getName())) {
                    int currentQuantity = inventoryCard.getQuantity();
                    inventoryCard.setQuantity(currentQuantity + 1);
                    break; // Apenas uma carta pode ser incrementada de cada vez
                }
            }
        }
    }

    public boolean isCardFull(Card card) {
        return false;
    }

    public void addCard(Card card) {
    }
}
