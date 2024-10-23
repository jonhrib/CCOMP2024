package Interfaces;

import Classes.Adotante;
import Classes.Animal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AdotarAnimal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private Animal animalController;
    private Adotante adotanteController;
    private JTextField cpfField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AdotarAnimal frame = new AdotarAnimal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public AdotarAnimal() {
        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1055, 750);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\jonhv\\Downloads\\image-2.png");
                g.drawImage(backgroundIcon.getImage(), 0, 280, 438, 530, this);
            }
        };
        contentPane.setBackground(new Color(0, 64, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Configuração da tabela de animais disponíveis para adoção
        model = new DefaultTableModel(new Object[]{"Código", "Tipo", "Raça", "Cor", "Peso"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Painel inferior com campo de CPF, botão de adoção e botão de voltar
        JPanel bottomPanel = new JPanel(new BorderLayout());
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        JPanel cpfPanel = new JPanel();
        cpfPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        cpfPanel.add(new JLabel("CPF Adotante: "));
        cpfField = new JTextField(15);
        cpfPanel.add(cpfField);
        bottomPanel.add(cpfPanel, BorderLayout.WEST);

        // Painel para os botões "Adotar" e "Voltar"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        // Botão para realizar a adoção
        JButton btnAdotar = new JButton("Adotar Animal");
        btnAdotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adotarAnimal();
            }
        });
        buttonPanel.add(btnAdotar);

        // Botão "Voltar"
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });
        buttonPanel.add(btnVoltar);

        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        // Inicializando controladores de Animal e Adotante, e carregando os animais
        try {
            animalController = new Animal();
            adotanteController = new Adotante();
            carregarAnimais();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Carrega os animais disponíveis para adoção na tabela.
     */
    private void carregarAnimais() throws SQLException {
        // Obtém a lista de animais disponíveis para adoção
        List<String[]> animais = animalController.encontrarAnimaisDisponiveis();
        // Adiciona cada animal à tabela
        for (String[] animal : animais) {
            model.addRow(animal);
        }
    }

    /**
     * Realiza o processo de adoção do animal selecionado.
     */
    private void adotarAnimal() {
        // Obtém a linha selecionada na tabela
        int selectedRow = table.getSelectedRow();
        String cpf = cpfField.getText();

        // Verifica se uma linha foi selecionada e se o campo CPF não está vazio
        if (selectedRow >= 0 && !cpf.isEmpty()) {
            String codigo = (String) model.getValueAt(selectedRow, 0); // Obtém o código do animal

            try {
                // Verifica se o adotante existe no banco de dados
                String[] adotante = adotanteController.encontrarAdotante(cpf);

                if (adotante != null) {
                    // Registra a adoção
                    animalController.adotarAnimal(codigo, cpf);
                    
                    // Adiciona o código do animal ao vetor adotados do adotante
                    adotanteController.adicionarAnimalAdotado(cpf, codigo);

                    // Remove o animal da lista e atualiza a tabela
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Animal adotado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Caso o adotante não seja encontrado, oferece a opção de cadastrar
                    int option = JOptionPane.showConfirmDialog(this, "Adotante não encontrado. Deseja cadastrar o adotante?", "Adotante não encontrado", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        cadastrarAdotante(cpf); // Chama o método de cadastro de adotante
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao adotar o animal.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Exibe uma mensagem de aviso se nenhum animal for selecionado ou o CPF não for informado
            JOptionPane.showMessageDialog(this, "Selecione um animal e informe o CPF do adotante.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }


    /**
     * Exibe uma janela para cadastrar o adotante.
     */
    private void cadastrarAdotante(String cpf) {
        // Criação de campos para o cadastro
        JTextField nomeField = new JTextField(20);
        JTextField rgField = new JTextField(15);
        JTextField enderecoField = new JTextField(30);
        JTextField telefoneField = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("CPF:"));
        panel.add(new JLabel(cpf)); // Exibe o CPF informado, sem permitir edição
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("RG:"));
        panel.add(rgField);
        panel.add(new JLabel("Endereço:"));
        panel.add(enderecoField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastro de Adotante", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Tenta cadastrar o adotante
            try {
                adotanteController.cadastrarAdotante(cpf, rgField.getText(), nomeField.getText(), enderecoField.getText(), telefoneField.getText());
                JOptionPane.showMessageDialog(this, "Adotante cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar adotante.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método para voltar à tela anterior ou fechar a janela atual.
     */
    private void voltar() {
    	TelaAnimais ta = new TelaAnimais();
    	ta.setVisible(true);
        this.dispose(); // Fecha a janela atual
        // Aqui você pode adicionar código para voltar a outra tela, se necessário.
    }
}
