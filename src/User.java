import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String cpf;
    private String senha;
    private int idade;
    private String sexo;
    private String email;
    private int level;
    private Inventory inventory;
    private Deck[] decks; 
    private int cardCoinsSaldo;

    public User(String login, String cpf, String senha, String email) {
        this.login = login;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.idade = idade;
        this.sexo = sexo;
        this.level = 1;
        this.inventory = new Inventory();
        this.decks = new Deck[5];
        this.cardCoinsSaldo = 0;
    }

    // Métodos getters e setters para acessar e modificar os atributos privados

    public String getLogin() {
        return login;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Deck[] getDecks() {
        return decks;
    }

    public int getCardCoinsSaldo() {
        return cardCoinsSaldo;
    }

    public void setCardCoinsSaldo(int cardCoinsSaldo) {
        this.cardCoinsSaldo = cardCoinsSaldo;
    }

    public void addCardCoins(int amount) {
        cardCoinsSaldo += amount;
    }

    public void subtractCardCoins(int boosterPrice) {
        if (cardCoinsSaldo >= boosterPrice) {
            cardCoinsSaldo -= boosterPrice;
        } else {
            System.out.println("Saldo insuficiente de CardCoins.");
        }
    }

    public int getCardCoins() {
        return cardCoinsSaldo;
    }

    public String getUsername() {
        return login;
    }

    public boolean checkLogin(String login2, String senha2) {
        return login.equals(login2) && senha.equals(senha2);
    }

    // Outros métodos relacionados ao jogador, como adicionar/remover decks, etc.
    
}

