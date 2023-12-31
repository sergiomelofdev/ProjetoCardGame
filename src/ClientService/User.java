package ClientService;

import Cards.Deck;

public class User implements Comparable<User> {
    private String login;
    private String cpf;
    private String senha;
    private int idade;
    private String sexo;
    private String email;
    private int level;
    private Inventory inventory;
    private Deck[] decks;
    private Deck chosedDeckToPlay; 

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
    }

    @Override
    public int compareTo(User userToCompare) {
        if(this.email.equals(userToCompare.getEmail())){
            return 0;
        }else{
            return 1;
        }
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

    public String getUsername() {
        return login;
    }
    public Deck getChosedDeckToPlay() {
        return chosedDeckToPlay;
    }
    public void setChosedDeckToPlay(Deck chosedDeckToPlay) {
        this.chosedDeckToPlay = chosedDeckToPlay;
    }

    public boolean checkLogin(String login2, String senha2) {
        return login.equals(login2) && senha.equals(senha2);
    }

    // Outros métodos relacionados ao jogador, como adicionar/remover decks, etc.
    
}

