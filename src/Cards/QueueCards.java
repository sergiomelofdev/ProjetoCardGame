public class QueueCards {
    private Card[] vetorQueue;
    private int lastCardInQueue;

    public QueueCards(int lenghtQueue){
        vetorQueue = new Card[lenghtQueue];
    }
    public Card[] getVetorQueue() {
        return vetorQueue;
    }
    public int getlastCardInQueue() {
        return lastCardInQueue;
    }
    public boolean isEmpty(){
        return (lastCardInQueue == 0);
    }
    public boolean isFull(){
        return(lastCardInQueue > vetorQueue.length);
    }
    public boolean addCardInQueue(Card newCardToAdd){
        if(isFull()){
            return false;
        }
        vetorQueue[lastCardInQueue] = newCardToAdd;
        lastCardInQueue++;
        return true;
    }
    public Card removeCardQueue(Card cardToRemove){
        for (int i = 0; i<lastCardInQueue; i++) {
            if(vetorQueue[i].getIdCard() == cardToRemove.getIdCard()){
                for (int posCardToRemove = i; posCardToRemove < lastCardInQueue; posCardToRemove++) {
                    if(posCardToRemove == lastCardInQueue-1){
                        vetorQueue[i] = null;
                    }else{
                        vetorQueue[i] = vetorQueue[i+1];
                    }
                }
                lastCardInQueue--;
                return cardToRemove;
            }
        }
        return null;
    }
    public boolean cardHasDuplicates(int idCardToTestHasDuplicate) {
        for (Card card : vetorQueue) {
            if(card.getIdCard() == idCardToTestHasDuplicate){
                return true;
            }
        }
        return false;
    }
}
