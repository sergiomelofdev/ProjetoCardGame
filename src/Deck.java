import java.util.ArrayList;
import java.util.List;

public class Deck {
    private String name;
    private List<Card> cards;
    private boolean availability;

    // Construtor
    public Deck(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.availability = false;
    }

    // Método para adicionar uma carta ao deck e atualizar o inventário
    public void addCardToDeck(Card card, Inventory inventory) {
        if (cards.size() < 60 && (card.getType().equals("MANA") || !hasMaxDuplicates(card))) {
            cards.add(card);
            inventory.decrementCardQuantity(card);
            updateAvailability();
        }
    }

    // Método para remover uma carta do deck e atualizar o inventário
    public void removeCardFromDeck(Card card, Inventory inventory) {
        if (cards.remove(card)) {
            inventory.incrementCardQuantity(card);
            updateAvailability();
        }
    }

    // Método para verificar se o deck tem o número máximo de duplicatas de uma carta (exceto mana)
    private boolean hasMaxDuplicates(Card card) {
        if (card.getType().equals("MANA")) {
            return false; // Cartas de mana não têm limite
        }
        int count = 0;
        for (Card deckCard : cards) {
            if (deckCard.getName().equals(card.getName())) {
                count++;
                if (count >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para atualizar a disponibilidade do deck com base nas condições
    private void updateAvailability() {
        availability = (cards.size() >= 60);
    }

    // Métodos getters
    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean isAvailable() {
        return availability;
    }
}