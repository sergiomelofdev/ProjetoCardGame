package ClientService;

import java.util.Random;

import Cards.*;
import Enumerates.*;

public class Store {
    private String cardNumber;
    private String verifierCode;
    private boolean promotion;

    // Construtor
    public Store(String cardNumber, String verifierCode) {
        this.cardNumber = cardNumber;
        this.verifierCode = verifierCode;
    }

    // Método para comprar um booster com CardCoins
    public void buyBooster(User user, Inventory inventory) {
        int boosterPrice = 100; // Preço de um booster em CardCoins (ajuste conforme necessário)

        if (inventory.wasteCardCoin(boosterPrice)) {
            Card[] boosterPack = generateBoosterPackRandomCards(12);
            for (Card card : boosterPack) {
                if(!inventory.incrementCardInInventory(card)){ //se o usuario n conseguir adicionar a carta no inventario, 
                    inventory.earnCardCoin(10);      //quer dizer q ele ja tem ela logo ganha 10 cardCoins
                }
            }
        }
    }

    public void buyBoosterPremium(User user, Inventory inventory) {
        int boosterPrice = 200; // Preço de um booster em CardCoins (ajuste conforme necessário)

        if (inventory.wasteCardCoin(boosterPrice)) {
            Card cardBoosterPack = generateBoosterPremium();
            
            if(!inventory.incrementCardInInventory(cardBoosterPack)){ //se o usuario n conseguir adicionar a carta no inventario, 
                inventory.earnCardCoin(200);      //quer dizer q ele ja tem ela logo ganha um "reembolso" de cardCoins
            }
        }
    }


    // Método para gerar um pacote de booster com cartas aleatórias
    private Card[] generateBoosterPackRandomCards(int qtdCardsBoosterPack) {
        Card[] boosterPack = new Card[qtdCardsBoosterPack];
        //para preencher o booster pack é gerado 12 cartas aleatorias
        for (int posBoosterPack = 0; posBoosterPack < qtdCardsBoosterPack; posBoosterPack++) {
            Card card = new Card("Carta Aleatória " + (posBoosterPack + 1), "imagem","type", EnumRarityCard.COMMON, 2, 3, "ability");
            boosterPack[posBoosterPack] = card;
            posBoosterPack++;
        }
        return boosterPack;
    }
    private Card generateBoosterPremium() {
        //booster q gera apenas uma carta aleatória mas ela sempre sera lendaria
        Card card = new Card("Carta Aleatória", "imagem","type", EnumRarityCard.LEGENDARY, 2, 3, "ability");
        return card;
    }

}