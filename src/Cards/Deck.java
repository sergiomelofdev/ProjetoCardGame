package Cards;
import ClientService.Inventory;
public class Deck {
    private String name;
    private QueueCards cards; 
    private boolean availability;

    // Construtor
    public Deck(String name) {
        this.name = name;
        cards = new QueueCards(15);
        this.availability = false;
    }

    // Método para adicionar uma carta ao deck e atualizar o inventário
    public boolean addCardToDeck(Card card, Inventory inventory) {
        //sugestao vetor de quantidade de cada carta para melhor testar duplicata
        if (!cards.isFull() || !cards.cardHasDuplicates(card.getIdCard())) {
            cards.addCardInQueue(card);
            availability = updateAvailability();
            return true;
        }
        return false;
    }

    // Método para remover uma carta do deck e atualizar o inventário
    public boolean removeCardFromDeck(Card card, Inventory inventory) {
        if (!cards.isEmpty()) {
            cards.removeCardQueue(card);
            return true;
        }
        return false;
    }
    public boolean updateAvailability(){
        return cards.isFull();
    }
    // Métodos getters
    public String getName() {
        return name;
    }

    public QueueCards getCards() {
        return cards;
    }

    public boolean isAvailable() {
        return availability;
    }
}