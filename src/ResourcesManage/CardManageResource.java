package ResourcesManage;

import Cards.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

public class CardManageResource extends AbstractReadResource{
    public ArrayList<Card> getAllCards() throws IOException {
        String jsonCards = readResouceFile(getResourcePath("GlobalResources", "Cards.json"));
        // gerar o tipo de objeto para ler o json:
        TypeToken<ArrayList<Card>> typeArrayListCards = new TypeToken<ArrayList<Card>>(){};
        return new Gson().fromJson(jsonCards, typeArrayListCards); //retorna todas as cartas
    }
    public ArrayList<Card> searchCardsPerName(String cardName) throws IOException {
        ArrayList<Card> allCardsInGame = getAllCards();
        ArrayList<Card> cardsFounded = new ArrayList<>();
        for (Card card: allCardsInGame) {
            if(card.getName().contains(cardName)){
                cardsFounded.add(card);
            }
        }
        return cardsFounded;
    }
    public ArrayList<Card> searchCardsPerPower(int cardPower) throws IOException {
        ArrayList<Card> allCardsInGame = getAllCards();
        ArrayList<Card> cardsFounded = new ArrayList<>();
        for (Card card: allCardsInGame) {
            if(card.getPower() == cardPower){
                cardsFounded.add(card);
            }
        }
        return cardsFounded;
    }
    public ArrayList<Card> searchCardsPerTimeEnergy(int cardTimeEnergy) throws IOException {
        ArrayList<Card> allCardsInGame = getAllCards();
        ArrayList<Card> cardsFounded = new ArrayList<>();
        for (Card card: allCardsInGame) {
            if(card.gettimeEnergy() == cardTimeEnergy){
                cardsFounded.add(card);
            }
        }
        return cardsFounded;
    }
    public Card searchOneCardPerID(int cardID) throws IOException {
        ArrayList<Card> allCardsInGame = getAllCards();
        for (Card card: allCardsInGame) {
            if(card.getIdCard() == cardID){
                return card;
            }
        }
        return null;
    }
}
