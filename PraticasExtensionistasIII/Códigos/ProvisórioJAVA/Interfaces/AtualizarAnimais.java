package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Classes.Animal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AtualizarAnimais extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCodigo;
    private JTextField textFieldRaca;
    private JTextField textFieldCor;
    private JTextField textFieldPeso;
    private JTextField textFieldTipo; // Campo para Tipo (Cão/Gato)
    private Animal animal; // Instância da classe Animal para buscar e atualizar os dados
    private JTextPane textPane_1;
    private JTextPane textPane;
    private JTextPane txtpnRaa;
    private JTextPane txtpnCor;
    private JTextPane txtpnPeso;

    // Construtor da tela de edição, com dados já preenchidos
    public AtualizarAnimais() throws ClassNotFoundException, SQLException {
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

        // Título
        JTextPane txtpnEditarAnimal = new JTextPane();
        txtpnEditarAnimal.setText("EDITAR ANIMAL");
        txtpnEditarAnimal.setOpaque(false);
        txtpnEditarAnimal.setForeground(new Color(242, 121, 121));
        txtpnEditarAnimal.setFont(new Font("Just Another Hand", Font.PLAIN, 75));
        txtpnEditarAnimal.setEditable(false);
        txtpnEditarAnimal.setBackground(Color.WHITE);
        txtpnEditarAnimal.setBounds(333, 38, 533, 82);
        contentPane.add(txtpnEditarAnimal);
        
        JButton btnBuscar = new JButton("Buscar");

        // Campo de entrada para Código
        textFieldCodigo = new JTextField();
        textFieldCodigo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnBuscar.doClick();
        	}
        });
        textFieldCodigo.setBounds(549, 142, 261, 30);
        contentPane.add(textFieldCodigo);

        textFieldTipo = new JTextField();
        textFieldTipo.setBounds(204, 233, 261, 30);
        textFieldTipo.setEditable(false); // Não editável, será preenchido automaticamente
        contentPane.add(textFieldTipo);

        textFieldRaca = new JTextField();
        textFieldRaca.setBounds(204, 282, 261, 30);
        contentPane.add(textFieldRaca);

        textFieldCor = new JTextField();
        textFieldCor.setBounds(204, 334, 261, 30);
        contentPane.add(textFieldCor);

        textFieldPeso = new JTextField();
        textFieldPeso.setBounds(204, 386, 261, 30);
        contentPane.add(textFieldPeso);

        // Botão de salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalvar.setBounds(349, 480, 116, 42);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novoRaca = textFieldRaca.getText();
                String novaCor = textFieldCor.getText();
                double novoPeso = Double.parseDouble(textFieldPeso.getText());
                String codigo = textFieldCodigo.getText();

                // Atualizar o animal
                try {
                    animal.atualizarAnimal(novoRaca, novaCor, novoPeso, codigo);
                    JOptionPane.showMessageDialog(contentPane, "Dados do animal atualizados com sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Erro ao atualizar animal.");
                }
            }
        });
        contentPane.add(btnSalvar);

        // Botão de voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnVoltar.setBackground(new Color(0, 64, 128));
        btnVoltar.setBounds(10, 668, 197, 35);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaAnimais ta = new TelaAnimais();
                ta.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVoltar);

        // Botão de buscar por código
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBuscar.setBounds(699, 182, 116, 42);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textFieldCodigo.getText();
                try {
                    animal = new Animal(); // Instância da classe Animal
                    String[] dados = animal.encontrarAnimal(codigo);

                    if (dados != null) {
                        // Preencher os campos com os dados do animal encontrado
                        textFieldTipo.setText(dados[1]); // Tipo (Cão/Gato)
                        textFieldRaca.setText(dados[2]);
                        textFieldCor.setText(dados[3]);
                        textFieldPeso.setText(dados[4]);
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Animal não encontrado.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Erro ao buscar animal.");
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPane.add(btnBuscar);

        // Textos de descrição
        //criarTextPane(contentPane, "DIGITE O CÓDIGO QUE DESEJA BUSCAR:", 111, 137, 439, 48, 25);
//        criarTextPane(contentPane, "TIPO", 111, 230, 85, 48, 25);
//        criarTextPane(contentPane, "RAÇA", 111, 282, 85, 48, 25);
//        criarTextPane(contentPane, "COR", 111, 334, 85, 48, 25);
//        criarTextPane(contentPane, "PESO", 111, 386, 85, 48, 25);
        
        textPane_1 = new JTextPane();
        textPane_1.setText("DIGITE O CÓDIGO QUE DESEJA BUSCAR:");
        textPane_1.setOpaque(false);
        textPane_1.setForeground(Color.WHITE);
        textPane_1.setFont(new Font("Kiona", Font.PLAIN, 25));
        textPane_1.setEditable(false);
        textPane_1.setBackground(Color.WHITE);
        textPane_1.setBounds(59, 139, 487, 48);
        contentPane.add(textPane_1);
        
        textPane = new JTextPane();
        textPane.setText("tipo");
        textPane.setOpaque(false);
        textPane.setForeground(Color.WHITE);
        textPane.setFont(new Font("Kiona", Font.PLAIN, 25));
        textPane.setEditable(false);
        textPane.setBackground(Color.WHITE);
        textPane.setBounds(137, 233, 65, 48);
        contentPane.add(textPane);
        
        txtpnRaa = new JTextPane();
        txtpnRaa.setText("raça");
        txtpnRaa.setOpaque(false);
        txtpnRaa.setForeground(Color.WHITE);
        txtpnRaa.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnRaa.setEditable(false);
        txtpnRaa.setBackground(Color.WHITE);
        txtpnRaa.setBounds(129, 282, 74, 48);
        contentPane.add(txtpnRaa);
        
        txtpnCor = new JTextPane();
        txtpnCor.setText("COR");
        txtpnCor.setOpaque(false);
        txtpnCor.setForeground(Color.WHITE);
        txtpnCor.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnCor.setEditable(false);
        txtpnCor.setBackground(Color.WHITE);
        txtpnCor.setBounds(142, 334, 65, 48);
        contentPane.add(txtpnCor);
        
        txtpnPeso = new JTextPane();
        txtpnPeso.setText("PESO");
        txtpnPeso.setOpaque(false);
        txtpnPeso.setForeground(Color.WHITE);
        txtpnPeso.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnPeso.setEditable(false);
        txtpnPeso.setBackground(Color.WHITE);
        txtpnPeso.setBounds(129, 384, 74, 48);
        contentPane.add(txtpnPeso);
    }

    // Método auxiliar para criar os JTextPane com as descrições
//    private void criarTextPane(JPanel panel, String text, int x, int y, int width, int height, int fontSize) {
//        JTextPane textPane = new JTextPane();
//        textPane.setText(text);
//        textPane.setOpaque(false);
//        textPane.setForeground(Color.WHITE);
//        textPane.setFont(new Font("Kiona", Font.PLAIN, fontSize));
//        textPane.setEditable(false);
//        textPane.setBackground(Color.WHITE);
//        textPane.setBounds(111, 230, 65, 48);
//        panel.add(textPane);
//    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AtualizarAnimais frame = new AtualizarAnimais();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
