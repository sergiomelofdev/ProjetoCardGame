public class Inventory {
    private Card[] cards;
    private boolean[] cardsInInventoryByID;
    private int cardCoins;
    
    private static int totalCardsInGame = 200;
    
    public Inventory() {
        cards = new Card[totalCardsInGame];
        cardsInInventoryByID = new boolean[totalCardsInGame];
    }
    public boolean[] getCardsInInventoryByID() {
        return cardsInInventoryByID;
    }
    public Card[] getCards() {
        return cards;
    }

    public int getCardCoins() {
        return cardCoins;
    }

    public void earnCardCoin(int coinToAdd){
        cardCoins += coinToAdd;
    }

    public boolean wasteCardCoin(int coinToLose){
        if(cardCoins < coinToLose){ //se n tiver dinheiro suficiente retorna false
            return false;
        }
        cardCoins -= coinToLose;
        return true;
    }

    public boolean incrementCardInInventory(Card cardForAdd) {
        if(cardsInInventoryByID[cardForAdd.getIdCard()]){
            return false; //n conseguiu incrementar pois ja tinha essa carta no inventario
        }
        cards[cardForAdd.getIdCard()] = cardForAdd;
        cardsInInventoryByID[cardForAdd.getIdCard()] = true;
        return true;//conseguiu incrementar
    }

}
