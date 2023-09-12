import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private JFrame frame;
    private JTextField loginField;
    private JPasswordField passwordField;
    private List<User> users;
    private User loggedInUser;
    private User authenticatedUser;

    public Game() {
        this.users = new ArrayList<>();
        this.loggedInUser = null;

        // Crie uma janela com o tamanho desejado (1920x1080 pixels)
        frame = new JFrame("Login de Jogo de Cartas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080); // Defina o tamanho da janela
        frame.setLayout(new BorderLayout());

        // Painel para campos de login e senha usando GridBagLayout
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Senha:");

        loginField = new JTextField(20);
        passwordField = new JPasswordField(20);

        constraints.gridx = 0;
        constraints.gridy = 0;
        loginPanel.add(loginLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        loginPanel.add(loginField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        loginPanel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        loginPanel.add(passwordField, constraints);

        // Botões de login e cadastro
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Cadastre-se");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField.getPassword());
                login(login, senha);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationDialog();
            }
        });

        // Adicione os componentes à janela
        frame.add(loginPanel, BorderLayout.CENTER);
        frame.add(loginButton, BorderLayout.SOUTH);
        frame.add(registerButton, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    // Método para registrar um novo usuário
    public void registerUser(String login, String cpf, String senha, String email) {
        // Verifique se já existe um usuário com o mesmo login ou CPF
        if (isUserExist(login, cpf)) {
            JOptionPane.showMessageDialog(frame, "Já existe um usuário com esse login ou CPF.");
            return;
        }

        // Crie o novo usuário e adicione à lista de usuários
        User newUser = new User(login, cpf, senha, email);
        users.add(newUser);
        JOptionPane.showMessageDialog(frame, "Conta criada com sucesso.");
    }

    // Método para fazer login
    public void login(String login, String senha) {
       
        // Verifique se já há um usuário logado
        if (loggedInUser != null) {
            JOptionPane.showMessageDialog(frame, "Você já está logado como " + loggedInUser.getLogin() + ".");
            return;
        }

        // Procure por um usuário correspondente na lista de usuários
        for (User user : users) {
            if (user.checkLogin(login, senha)) {
                loggedInUser = user;
                JOptionPane.showMessageDialog(frame, "Login bem-sucedido. Bem-vindo, " + loggedInUser.getLogin() + "!");
                return;
            }
        }

        JOptionPane.showMessageDialog(frame, "Login ou senha incorretos.");
    }

    // Método para fazer logout
    public void logout() {
        if (loggedInUser != null) {
            JOptionPane.showMessageDialog(frame, "Logout bem-sucedido. Adeus, " + loggedInUser.getLogin() + "!");
            loggedInUser = null;
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum usuário logado.");
        }
    }

    // Método auxiliar para verificar se um usuário já existe com o mesmo login ou CPF
    private boolean isUserExist(String login, String cpf) {
        for (User user : users) {
            if (user.getLogin().equals(login) || user.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar uma janela de cadastro
    private void showRegistrationDialog() {
        // Crie uma nova janela de diálogo modal para cadastro
        JDialog registrationDialog = new JDialog(frame, "Cadastro de Usuário", true);
        registrationDialog.setSize(400, 300);
        registrationDialog.setLayout(new BorderLayout());

        // Painel para campos de cadastro usando GridBagLayout
        JPanel registrationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints
        // Painel para campos de cadastro usando GridBagLayout
        JPanel; registrationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel loginLabel = new JLabel("Login:");
        JLabel cpfLabel = new JLabel("CPF:");
        JLabel passwordLabel = new JLabel("Senha:");
        JLabel emailLabel = new JLabel("Email:");

        JTextField loginField = new JTextField(20);
        JTextField cpfField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JTextField emailField = new JTextField(20);

        constraints.gridx = 0;
        constraints.gridy = 0;
        registrationPanel.add(loginLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        registrationPanel.add(loginField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        registrationPanel.add(cpfLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        registrationPanel.add(cpfField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        registrationPanel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        registrationPanel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        registrationPanel.add(emailLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        registrationPanel.add(emailField, constraints);

        // Botão de cadastro
        JButton registerButton = new JButton("Cadastrar");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String cpf = cpfField.getText();
                String senha = new String(passwordField.getPassword());
                String email = emailField.getText();
                // Valide os campos e chame registerUser para criar uma nova conta
                if (validateFields(login, cpf, senha, email)) {
                    registerUser(login, cpf, senha, email);
                    // Feche a janela de cadastro após o registro
                    registrationDialog.dispose();
                }
            }

            private boolean validateFields(String login, String cpf, String senha, String email) {
                if (login.isEmpty() || cpf.isEmpty() || senha.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                    return false;
                }
            
                // Verifique se o CPF tem um formato válido (11 dígitos numéricos)
                if (!cpf.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(frame, "CPF inválido. O CPF deve conter 11 dígitos numéricos.");
                    return false;
                }
            
                // Verifique se o email tem um formato válido (simplificado)
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(frame, "Email inválido. Verifique o formato do email.");
                    return false;
                }
            
                // Verifique a força da senha (pode adicionar regras adicionais aqui)
                if (senha.length() < 8) {
                    JOptionPane.showMessageDialog(frame, "Senha fraca. A senha deve ter pelo menos 8 caracteres.");
                    return false;
                }
            
                // Verifique se não há duplicatas de CPF ou login na lista de usuários
                for (User user : users) {
                    if (user.getLogin().equals(login)) {
                        JOptionPane.showMessageDialog(frame, "Já existe um usuário com esse login.");
                        return false;
                    }
                    if (user.getCpf().equals(cpf)) {
                        JOptionPane.showMessageDialog(frame, "Já existe um usuário com esse CPF.");
                        return false;
                    }
                }
            
                // Adicionar outras verificações conforme necessário
            
                return true;
            }
        });
        // Adiciona os componentes ao diálogo de cadastro
        registrationDialog.add(registrationPanel, BorderLayout.CENTER);
        registrationDialog.add(registerButton, BorderLayout.SOUTH);

        // Defina o tamanho mínimo da janela de cadastro
        registrationDialog.setMinimumSize(new Dimension(400, 300));

        // Torne a janela de cadastro visível
        registrationDialog.setVisible(true);
    }

    // Resto da classe Game...
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game(); // Cria uma instância da classe Game diretamente
            }
        });
    }
}