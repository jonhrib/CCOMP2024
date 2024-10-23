package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;


import Classes.Animal;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.sql.SQLException;
import java.util.List;

public class CadastroAnimais extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCodigo;
    private JTextField textFieldRaca;
    private JTextField textFieldCor;
    private JTextField textFieldPeso;
    private JComboBox<String> comboBox;
    private Animal animal; // Instância da classe Animal

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastroAnimais frame = new CadastroAnimais();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CadastroAnimais() {
        try {
            animal = new Animal(); // Inicializa a conexão com o banco de dados
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1055, 750);
        contentPane = new JPanel() {
            // Sobrescreva o método paintComponent para desenhar a imagem de fundo
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon3 = new ImageIcon("C:\\Users\\jonhv\\Downloads\\image-2.png"); // Substitua pelo caminho correto
                Image backgroundImage3 = backgroundIcon3.getImage();
                g.drawImage(backgroundImage3, 0, 280, 438, 530, this);
            }
        };
        contentPane.setBackground(new Color(0, 64, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTextPane txtpnCdigoJExiste = new JTextPane();
        txtpnCdigoJExiste.setText("CÓDIGO já existe");
        txtpnCdigoJExiste.setOpaque(false);
        txtpnCdigoJExiste.setForeground(Color.WHITE);
        txtpnCdigoJExiste.setFont(new Font("Kiona", Font.PLAIN, 15));
        txtpnCdigoJExiste.setEditable(false);
        txtpnCdigoJExiste.setBackground(Color.WHITE);
        txtpnCdigoJExiste.setBounds(473, 220, 105, 48);
        contentPane.add(txtpnCdigoJExiste);
        txtpnCdigoJExiste.setVisible(false);

        JTextPane txtpnAdicioneSuasInformaes = new JTextPane();
        txtpnAdicioneSuasInformaes.setBounds(38, 152, 711, 48);
        txtpnAdicioneSuasInformaes.setText("Adicione as informações de cadastro:");
        txtpnAdicioneSuasInformaes.setOpaque(false);
        txtpnAdicioneSuasInformaes.setForeground(new Color(255, 255, 255));
        txtpnAdicioneSuasInformaes.setFont(new Font("Futura Hv BT", Font.PLAIN, 30));
        txtpnAdicioneSuasInformaes.setEditable(false);
        txtpnAdicioneSuasInformaes.setBackground(Color.WHITE);
        contentPane.add(txtpnAdicioneSuasInformaes);

        JTextPane txtpnCadastroDeAnimais = new JTextPane();
        txtpnCadastroDeAnimais.setText("CADASTRO DE ANIMAIS");
        txtpnCadastroDeAnimais.setOpaque(false);
        txtpnCadastroDeAnimais.setForeground(new Color(242, 121, 121));
        txtpnCadastroDeAnimais.setFont(new Font("Just Another Hand", Font.PLAIN, 75));
        txtpnCadastroDeAnimais.setEditable(false);
        txtpnCadastroDeAnimais.setBackground(Color.WHITE);
        txtpnCadastroDeAnimais.setBounds(257, 49, 533, 82);
        contentPane.add(txtpnCadastroDeAnimais);

        JTextPane txtpnCodigo = new JTextPane();
        txtpnCodigo.setText("CÓDIGO");
        txtpnCodigo.setOpaque(false);
        txtpnCodigo.setForeground(Color.WHITE);
        txtpnCodigo.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnCodigo.setEditable(false);
        txtpnCodigo.setBackground(Color.WHITE);
        txtpnCodigo.setBounds(95, 220, 105, 48);
        contentPane.add(txtpnCodigo);

        textFieldCodigo = new JTextField();
        textFieldCodigo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String[] animalExistente = null;
				try {
					animalExistente = animal.encontrarAnimal(textFieldCodigo.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                if (animalExistente != null) {
                    System.out.println("Código já cadastrado.");
                    comboBox.setEnabled(false);
                    textFieldRaca.setEnabled(false);
                    textFieldCor.setEnabled(false);
                    textFieldPeso.setEnabled(false);
                    txtpnCdigoJExiste.setVisible(true);
                }
                else {
                	txtpnCdigoJExiste.setVisible(false);
                	comboBox.setEnabled(true);
                	comboBox.requestFocus();
                }
        	}
        });
        textFieldCodigo.setColumns(10);
        textFieldCodigo.setBounds(202, 225, 261, 30);
        contentPane.add(textFieldCodigo);

        JTextPane txtpnTipo = new JTextPane();
        txtpnTipo.setText("TIPO");
        txtpnTipo.setOpaque(false);
        txtpnTipo.setForeground(Color.WHITE);
        txtpnTipo.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnTipo.setEditable(false);
        txtpnTipo.setBackground(Color.WHITE);
        txtpnTipo.setBounds(133, 272, 67, 48);
        contentPane.add(txtpnTipo);

        String[] opcoes = {"Cachorro", "Gato"};
        comboBox = new JComboBox<>(opcoes);
        comboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textFieldRaca.setEnabled(true);
        		textFieldRaca.requestFocus();
        	}
        });
        comboBox.setFont(new Font("Kiona", Font.PLAIN, 20));
        comboBox.setBounds(202, 278, 261, 30);
        contentPane.add(comboBox);

        JTextPane txtpnRaca = new JTextPane();
        txtpnRaca.setText("RAÇA");
        txtpnRaca.setOpaque(false);
        txtpnRaca.setForeground(Color.WHITE);
        txtpnRaca.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnRaca.setEditable(false);
        txtpnRaca.setBackground(Color.WHITE);
        txtpnRaca.setBounds(120, 327, 85, 48);
        contentPane.add(txtpnRaca);

        textFieldRaca = new JTextField();
        textFieldRaca.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textFieldCor.setEnabled(true);
        		textFieldCor.requestFocus();
        	}
        });
        textFieldRaca.setColumns(10);
        textFieldRaca.setBounds(202, 330, 261, 30);
        contentPane.add(textFieldRaca);

        JTextPane txtpnCor = new JTextPane();
        txtpnCor.setText("COR");
        txtpnCor.setOpaque(false);
        txtpnCor.setForeground(Color.WHITE);
        txtpnCor.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnCor.setEditable(false);
        txtpnCor.setBackground(Color.WHITE);
        txtpnCor.setBounds(135, 379, 67, 48);
        contentPane.add(txtpnCor);

        textFieldCor = new JTextField();
        textFieldCor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textFieldPeso.setEnabled(true);
        		textFieldPeso.requestFocus();
        	}
        });
        textFieldCor.setColumns(10);
        textFieldCor.setBounds(204, 384, 261, 30);
        contentPane.add(textFieldCor);

        JTextPane txtpnPeso = new JTextPane();
        txtpnPeso.setText("PESO");
        txtpnPeso.setOpaque(false);
        txtpnPeso.setForeground(Color.WHITE);
        txtpnPeso.setFont(new Font("Kiona", Font.PLAIN, 25));
        txtpnPeso.setEditable(false);
        txtpnPeso.setBackground(Color.WHITE);
        txtpnPeso.setBounds(125, 431, 77, 48);
        contentPane.add(txtpnPeso);

        RoundedButton btnCadastrar = new RoundedButton("CADASTRAR");
        
        textFieldPeso = new JTextField();
        textFieldPeso.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnCadastrar.doClick();
        	}
        });
        textFieldPeso.setColumns(10);
        textFieldPeso.setBounds(204, 437, 261, 30);
        contentPane.add(textFieldPeso);

        
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCadastrar.setBounds(349, 477, 116, 42);
        contentPane.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtém os valores dos campos
                String codigo = textFieldCodigo.getText();
                boolean tipo = comboBox.getSelectedItem().equals("Cachorro");
                String raca = textFieldRaca.getText();
                String cor = textFieldCor.getText();
                double peso;

                // Valida o peso
                try {
                    peso = Double.parseDouble(textFieldPeso.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("Peso inválido.");
                    return; // Interrompe se o peso for inválido
                }

                // Verifica se o código já existe
                try {
                    String[] animalExistente = animal.encontrarAnimal(codigo);
                    if (animalExistente != null) {
                        System.out.println("Código já cadastrado.");
                        return; // Interrompe se o código já existir
                    }
                    // Cadastra o novo animal
                    animal.cadastrarAnimal(codigo, tipo, raca, cor, peso);
                    
                 // Mostra mensagem de sucesso
                    JOptionPane.showMessageDialog(contentPane, "Animal cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaAnimais ta = new TelaAnimais();
                ta.setVisible(true);
                setVisible(false);
            }
        });
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnVoltar.setBackground(new Color(0, 64, 128));
        btnVoltar.setBounds(24, 35, 89, 23);
        contentPane.add(btnVoltar);
        
    }
}
