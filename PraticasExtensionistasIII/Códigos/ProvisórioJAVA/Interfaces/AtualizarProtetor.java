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
import Classes.Protetor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AtualizarProtetor extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldRg;
    private JTextField textFieldEndereco;
    private JTextField textFieldTelefone;
    private JTextField textFieldQtdGatos;
    private JTextField textFieldQtdCaes;
    private JTextField textFieldCpf;  // Campo para CPF
    private Protetor protetor;        // Instância da classe Protetor para buscar e atualizar os dados

    // Construtor da tela de edição, com dados já preenchidos
    public AtualizarProtetor() throws ClassNotFoundException, SQLException {
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
        JTextPane txtpnEditarProtetor = new JTextPane();
        txtpnEditarProtetor.setText("EDITAR PROTETOR");
        txtpnEditarProtetor.setOpaque(false);
        txtpnEditarProtetor.setForeground(new Color(242, 121, 121));
        txtpnEditarProtetor.setFont(new Font("Just Another Hand", Font.PLAIN, 75));
        txtpnEditarProtetor.setEditable(false);
        txtpnEditarProtetor.setBackground(Color.WHITE);
        txtpnEditarProtetor.setBounds(333, 38, 533, 82);
        contentPane.add(txtpnEditarProtetor);
        
        JButton btnBuscar = new JButton("Buscar");

        // Campo de entrada para CPF
        textFieldCpf = new JTextField();
        textFieldCpf.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnBuscar.doClick();
        	}
        });
        textFieldCpf.setBounds(549, 142, 261, 30);
        contentPane.add(textFieldCpf);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(204, 233, 261, 30);
        contentPane.add(textFieldNome);

        textFieldEndereco = new JTextField();
        textFieldEndereco.setBounds(204, 282, 261, 30);
        contentPane.add(textFieldEndereco);

        textFieldTelefone = new JTextField();
        textFieldTelefone.setBounds(204, 334, 261, 30);
        contentPane.add(textFieldTelefone);

        textFieldQtdGatos = new JTextField();
        textFieldQtdGatos.setBounds(204, 386, 261, 30);
        contentPane.add(textFieldQtdGatos);

        textFieldQtdCaes = new JTextField();
        textFieldQtdCaes.setBounds(204, 438, 261, 30);
        contentPane.add(textFieldQtdCaes);

        // Botão de salvar
     // Botão de salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalvar.setBounds(349, 480, 116, 42);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String cpf = textFieldCpf.getText();
                String novoNome = textFieldNome.getText();
				String novoEndereco = textFieldEndereco.getText();
				String novoTelefone = textFieldTelefone.getText();
				int novaQtdGatos = Integer.parseInt(textFieldQtdGatos.getText());
				int novaQtdCaes = Integer.parseInt(textFieldQtdCaes.getText());

				// Atualizar o protetor
				try {
					protetor.atualizarProtetor(novoNome, novoEndereco, novoTelefone, novaQtdGatos, novaQtdCaes, cpf);
					System.out.println(novoNome);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(contentPane, "Dados do protetor atualizados com sucesso!");
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
                TelaProtetores tp = new TelaProtetores();
                tp.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVoltar);

        // Botão de buscar por CPF
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnBuscar.setBounds(699, 182, 116, 42);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = textFieldCpf.getText();
                try {
                    protetor = new Protetor();  // Instância da classe Protetor
                    String[] dados = protetor.encontrarProtetor(cpf);

                    if (dados != null) {
                        // Preencher os campos com os dados do protetor encontrado
                        textFieldNome.setText(dados[2]);
                        textFieldEndereco.setText(dados[3]);
                        textFieldTelefone.setText(dados[5]);
                        textFieldQtdGatos.setText(dados[4]);
                        textFieldQtdCaes.setText(dados[6]);
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Protetor não encontrado.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(contentPane, "Erro ao buscar protetor.");
                } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        contentPane.add(btnBuscar);

        // Textos de descrição
        criarTextPane(contentPane, "DIGITE O CPF QUE DESEJA BUSCAR:", 111, 137, 439, 48, 25);
        criarTextPane(contentPane, "NOME", 111, 230, 85, 48, 25);
        criarTextPane(contentPane, "ENDEREÇO", 56, 282, 143, 48, 25);
        criarTextPane(contentPane, "TELEFONE", 56, 334, 143, 48, 25);
        criarTextPane(contentPane, "QTD. GATOS", 34, 386, 170, 48, 25);
        criarTextPane(contentPane, "QTD. CÃES", 53, 438, 179, 48, 25);
    }

    // Método auxiliar para criar os JTextPane com as descrições
    private void criarTextPane(JPanel panel, String text, int x, int y, int width, int height, int fontSize) {
        JTextPane textPane = new JTextPane();
        textPane.setText(text);
        textPane.setOpaque(false);
        textPane.setForeground(Color.WHITE);
        textPane.setFont(new Font("Kiona", Font.PLAIN, fontSize));
        textPane.setEditable(false);
        textPane.setBackground(Color.WHITE);
        textPane.setBounds(x, y, width, height);
        panel.add(textPane);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AtualizarProtetor frame = new AtualizarProtetor();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
