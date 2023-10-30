import java.util.Random;

public class Store {
    private String cardNumber;
    private String verifierCode;

    // Construtor
    public Store(String cardNumber, String verifierCode) {
        this.cardNumber = cardNumber;
        this.verifierCode = verifierCode;
    }

    // Método para comprar um booster com CardCoins
    public void buyBooster(User user, Inventory inventory) {
        int boosterPrice = 100; // Preço de um booster em CardCoins (ajuste conforme necessário)

        if (inventory.wasteCardCoin(boosterPrice)) {
            Card[] boosterPack = generateBoosterPack12RandomCards();
            for (Card card : boosterPack) {
                if(!inventory.incrementCardInInventory(card)){ //se o usuario n conseguir adicionar a carta no inventario, 
                    inventory.earnCardCoin(10);      //quer dizer q ele ja tem ela logo ganha 10 cardCoins
                }
            }
        }
    }

    // Método para gerar um pacote de booster com 12 cartas aleatórias
    private Card[] generateBoosterPack12RandomCards() {
        int qtdCardsBoosterPack = 12;
        Card[] boosterPack = new Card[qtdCardsBoosterPack];
        //para preencher o booster pack é gerado 12 cartas aleatorias
        Random random = new Random();
        for (int posBoosterPack = 0; posBoosterPack < qtdCardsBoosterPack; posBoosterPack++) {
            Card card = new Card("Carta Aleatória " + (posBoosterPack + 1), "imagem","type", getRandomRarity(random), 2, 3, 5, "ability");
            boosterPack[posBoosterPack] = card;
            posBoosterPack++;
        }
        return boosterPack;
    }

    // Método auxiliar para obter uma raridade aleatória
    private Card.Rarity getRandomRarity(Random random) {
        int index = random.nextInt(Card.Rarity.values().length);
        return Card.Rarity.values()[index];
    }
}