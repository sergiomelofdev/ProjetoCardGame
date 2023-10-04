
// Classe que representa o campo do jogo falta implementar atributos = sub camos e seu tamanho e habilidade/tipo/efeito, metodos de retirar e inserir cartas 
public class Field {
    private Card[][] yourSubField;
    private int qtdCardsInYourSubField;	
    private Card[][] subFieldOpponent;
    private int qtdCardsSubFieldOpponent;	
    private String nameField;	
    private EffectField effectField;
    private int maxCardsInyourSubField = 4; // tamanho max de cartas em cada campo ainda a ser determinado

    public enum EffectField {
        noEffect,
        disableCardEffects,
        reduce1PowerCardsPerTurn,
        increasePowerCards,
        discartOneCardBothHands,
        fillBothHands
        //apenas esses efeitos, por enquanto...
    }
    
    public Field(String nameField, EffectField effectField) {
        this.nameField = nameField;
        this.effectField = effectField;
        yourSubField = new Card[2][2];
        yourSubFieldOpponent = new Card[2][2];
    }

    public boolean yourFieldIsFull() {
        return qtdCardsInyourSubField == maxCardsInyourSubField; 
    }
    public boolean opponentFieldIsFull() {
        return qtdCardsInyourSubField == maxCardsInyourSubField;
    }
    public boolean yourFieldIsEmpty() {
        return qtdCardsInyourSubField == 0; 
    }
    public boolean opponentFieldIsEmpty() {
        return qtdCardsInyourSubField == 0;
    }

    public Card putCardInYourField(Card insertedCard) {
        if(yourFieldIsFull()){
            return null;
        }
        for(int lineFieldIndex = 0; lineFieldIndex < (maxCardsInyourSubField/2); lineFieldIndex++) {
            for(int columnFieldIndex = 0; columnFieldIndex < (maxCardsInyourSubField/2); columnFieldIndex++) {
                if(yourSubField[lineFieldIndex][columnFieldIndex] == null) {
                    yourSubField[lineFieldIndex][columnFieldIndex] = insertedCard;
                    qtdCardsInYourSubField++;
                    return insertedCard;
                }
            }
        }

        yourSubField[qtdCardsInyourSubField] = insertedCard;
        return insertedCard;
    }

    public Card remoCardFromYourField(Card removedCard) {
        if(yourFieldIsEmpty()){
            return null;
        }
        for(int lineFieldIndex = 0; lineFieldIndex < (maxCardsInyourSubField/2); lineFieldIndex++) {
            for(int columnFieldIndex = 0; columnFieldIndex < (maxCardsInyourSubField/2); columnFieldIndex++) {
                if(yourSubField[lineFieldIndex][columnFieldIndex] == removedCard) {
                    //se achar a carta q deseja remover no campo, a carta sera removida e todas as cartas depois dela vao andar como uma fila
                    
                }
            }
        }
    }

}