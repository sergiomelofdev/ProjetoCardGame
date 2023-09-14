import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Deck {
    private String name;
    private Card[] cards;//sugestao: definir limite cartas deck = 30 
    private boolean availability;
    private int qtdAddDeck;

    // Construtor
    public Deck(String name) {
        this.name = name;
        cards = new Card[15];
        this.availability = false;
    }
    private boolean isFull(){
        if(qtdAddDeck >= 15){
            return true;
        }
        return false;
    }
    private boolean isEmpty(){
        if(qtdAddDeck == 0){
            return true;
        }
        return false;
    }

    // Método para adicionar uma carta ao deck e atualizar o inventário
    public void addCardToDeck(Card card, Inventory inventory) {
        //sugestao vetor de quantidade de cada carta para melhor testar duplicata
        if (qtdAddDeck < 15 || !hasMaxDuplicates(card)) {
            cards[qtdAddDeck] = card;
            qtdAddDeck++;
            inventory.decrementCardQuantity(card);
            updateAvailability();
        }
    }

    // Método para remover uma carta do deck e atualizar o inventário
    public void removeCardFromDeck(Card card, Inventory inventory) {
        if (!isEmpty()) {
            inventory.incrementCardQuantity(card);
            updateAvailability();
            qtdAddDeck--;
        }
    }

    // Método para verificar se o deck tem o número máximo de duplicatas de uma carta (exceto mana)
    private boolean hasMaxDuplicates(Card card) {
        for (Card deckCard : cards) {
            if (deckCard.getName().equals(card.getName())) {
                return true;
            }
        }
        return false;
    }

    // Método para atualizar a disponibilidade do deck com base nas condições
    private void updateAvailability() {
        availability = (cards.length >= 15);
    }

    // Métodos getters
    public String getName() {
        return name;
    }

    public Card[] getCards() {
        return cards;
    }

    public boolean isAvailable() {
        return availability;
    }
}