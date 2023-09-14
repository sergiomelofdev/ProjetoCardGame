import java.util.ArrayList;
import java.util.List;
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
        int cardCoins = user.getCardCoins();
        int boosterPrice = 100; // Preço de um booster em CardCoins (ajuste conforme necessário)

        if (cardCoins >= boosterPrice) {
            Card[] boosterPack = generateBoosterPack12RandomCards();
            for (Card card : boosterPack) {
                if (!user.getInventory().isCardFull(card)) {
                    user.getInventory().addCard(card);
                } else {
                    user.addCardCoins(10); // Valor em CardCoins por cartas repetidas (ajuste conforme necessário)
                }
            }
            user.subtractCardCoins(boosterPrice);
        }
    }

    // Método para gerar um pacote de booster com 12 cartas aleatórias
    private Card[] generateBoosterPack12RandomCards() {
        int qtdCardsBoosterPack = 12;//modificado para melhor entendimento do codigo 
        Card[] boosterPack = new Card[qtdCardsBoosterPack];
        /*Lógica para gerar 12 cartas aleatórias
        Isso pode envolver escolher aleatoriamente cartas do seu conjunto de cartas disponíveis
        e criar instâncias aleatórias com diferentes raridades, atributos, etc.
        Por simplicidade, vou criar um exemplo com cartas fictícias: */
        Random random = new Random();
        int posBoosterPack = 0;
        for (int i = 0; i < qtdCardsBoosterPack; i++) {
            Card card = new Card("Carta Aleatória " + (i + 1), "imagem","type", getRandomRarity(random), 2, 3, 5, "ability");
            boosterPack[posBoosterPack] = card;
            posBoosterPack++;
        }
        return boosterPack;
    }

    // Método auxiliar para obter uma raridade aleatória
    private Card.Rarity getRandomRarity(Random random) {
        //explicar
        int index = random.nextInt(Card.Rarity.values().length);
        return Card.Rarity.values()[index];
    }
}