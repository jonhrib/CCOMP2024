package Interfaces;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Protetor;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastroProtetores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Endereco;
	private JTextField textField_Telefone;
	private JTextField textField_gatos;
	private JTextField textField_Cpf;
	private JTextField textField_Rg;
	private JTextField textField_Nome;
	private JTextField textField_caes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProtetores frame = new CadastroProtetores();
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
	public CadastroProtetores() {
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
		
		JTextPane txtpnCpfJExiste = new JTextPane();
		txtpnCpfJExiste.setText("CPF JÁ EXISTE");
		txtpnCpfJExiste.setOpaque(false);
		txtpnCpfJExiste.setForeground(Color.WHITE);
		txtpnCpfJExiste.setFont(new Font("Kiona", Font.PLAIN, 15));
		txtpnCpfJExiste.setEditable(false);
		txtpnCpfJExiste.setBackground(Color.WHITE);
		txtpnCpfJExiste.setBounds(461, 221, 179, 48);
		contentPane.add(txtpnCpfJExiste);
		txtpnCpfJExiste.setVisible(false);
		
		JTextPane txtpnAdicioneSuasInformaes = new JTextPane();
		txtpnAdicioneSuasInformaes.setBounds(38, 152, 711, 48);
		txtpnAdicioneSuasInformaes.setText("Adicione suas informações de cadastro:");
		txtpnAdicioneSuasInformaes.setOpaque(false);
		txtpnAdicioneSuasInformaes.setForeground(new Color(255, 255, 255));
		txtpnAdicioneSuasInformaes.setFont(new Font("Futura Hv BT", Font.PLAIN, 30));
		txtpnAdicioneSuasInformaes.setEditable(false);
		txtpnAdicioneSuasInformaes.setBackground(Color.WHITE);
		contentPane.add(txtpnAdicioneSuasInformaes);
		
		JTextPane txtpnCadastroDeProtetor = new JTextPane();
		txtpnCadastroDeProtetor.setText("CADASTRO DE PROTETOR");
		txtpnCadastroDeProtetor.setOpaque(false);
		txtpnCadastroDeProtetor.setForeground(new Color(242, 121, 121));
		txtpnCadastroDeProtetor.setFont(new Font("Just Another Hand", Font.PLAIN, 75));
		txtpnCadastroDeProtetor.setEditable(false);
		txtpnCadastroDeProtetor.setBackground(Color.WHITE);
		txtpnCadastroDeProtetor.setBounds(257, 49, 533, 82);
		contentPane.add(txtpnCadastroDeProtetor);
		
		JTextPane txtpnCpfDeveConter = new JTextPane();
		txtpnCpfDeveConter.setText("CPF deve conter somente números e ser válido");
		txtpnCpfDeveConter.setOpaque(false);
		txtpnCpfDeveConter.setForeground(Color.WHITE);
		txtpnCpfDeveConter.setFont(new Font("Kiona", Font.PLAIN, 15));
		txtpnCpfDeveConter.setEditable(false);
		txtpnCpfDeveConter.setBackground(Color.WHITE);
		txtpnCpfDeveConter.setBounds(461, 221, 371, 48);
		contentPane.add(txtpnCpfDeveConter);
		txtpnCpfDeveConter.setVisible(false);
		
		JTextPane txtpnCpf = new JTextPane();
		txtpnCpf.setText("CPF");
		txtpnCpf.setOpaque(false);
		txtpnCpf.setForeground(Color.WHITE);
		txtpnCpf.setFont(new Font("Kiona", Font.PLAIN, 25));
		txtpnCpf.setEditable(false);
		txtpnCpf.setBackground(Color.WHITE);
		txtpnCpf.setBounds(145, 221, 65, 48);
		contentPane.add(txtpnCpf);
		
		textField_Endereco = new JTextField();
		textField_Endereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_Telefone.setEnabled(true);
				textField_Telefone.requestFocus();
			}
		});
		textField_Endereco.setColumns(10);
		textField_Endereco.setBounds(204, 384, 261, 30);
		contentPane.add(textField_Endereco);
		
		JTextPane txtpnRg = new JTextPane();
		txtpnRg.setText("RG");
		txtpnRg.setOpaque(false);
		txtpnRg.setForeground(Color.WHITE);
		txtpnRg.setFont(new Font("Kiona", Font.PLAIN, 25));
		txtpnRg.setEditable(false);
		txtpnRg.setBackground(Color.WHITE);
		txtpnRg.setBounds(155, 272, 65, 48);
		contentPane.add(txtpnRg);
		
		JTextPane txtpnTelefoneDeveConter = new JTextPane();
		txtpnTelefoneDeveConter.setText("Telefone deve conter somente números");
		txtpnTelefoneDeveConter.setOpaque(false);
		txtpnTelefoneDeveConter.setForeground(Color.WHITE);
		txtpnTelefoneDeveConter.setFont(new Font("Kiona", Font.PLAIN, 15));
		txtpnTelefoneDeveConter.setEditable(false);
		txtpnTelefoneDeveConter.setBackground(Color.WHITE);
		txtpnTelefoneDeveConter.setBounds(470, 431, 244, 48);
		contentPane.add(txtpnTelefoneDeveConter);
		txtpnTelefoneDeveConter.setVisible(false);
		
		textField_Telefone = new JTextField();
		textField_Telefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(textField_Telefone.getText())) {
					txtpnTelefoneDeveConter.setVisible(false);
					textField_gatos.setEnabled(true);
					textField_gatos.requestFocus();
				}
				else {
					txtpnTelefoneDeveConter.setVisible(true);
					textField_gatos.setEnabled(false);
				}
				
			}
		});
		textField_Telefone.setColumns(10);
		textField_Telefone.setBounds(204, 437, 261, 30);
		contentPane.add(textField_Telefone);
		
		JTextPane txtpnAQuantidadeDeve = new JTextPane();
		txtpnAQuantidadeDeve.setText("a quantidade deve ser maior que 0");
		txtpnAQuantidadeDeve.setOpaque(false);
		txtpnAQuantidadeDeve.setForeground(Color.WHITE);
		txtpnAQuantidadeDeve.setFont(new Font("Kiona", Font.PLAIN, 15));
		txtpnAQuantidadeDeve.setEditable(false);
		txtpnAQuantidadeDeve.setBackground(Color.WHITE);
		txtpnAQuantidadeDeve.setBounds(468, 483, 266, 48);
		contentPane.add(txtpnAQuantidadeDeve);
		txtpnAQuantidadeDeve.setVisible(false);
		
		JTextPane txtpnAQuantidadeDeve_1 = new JTextPane();
		txtpnAQuantidadeDeve_1.setText("a quantidade deve ser maior que 0");
		txtpnAQuantidadeDeve_1.setOpaque(false);
		txtpnAQuantidadeDeve_1.setForeground(Color.WHITE);
		txtpnAQuantidadeDeve_1.setFont(new Font("Kiona", Font.PLAIN, 15));
		txtpnAQuantidadeDeve_1.setEditable(false);
		txtpnAQuantidadeDeve_1.setBackground(Color.WHITE);
		txtpnAQuantidadeDeve_1.setBounds(468, 535, 266, 48);
		contentPane.add(txtpnAQuantidadeDeve_1);
		txtpnAQuantidadeDeve_1.setVisible(false);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setText("NOME");
		txtpnNome.setOpaque(false);
		txtpnNome.setForeground(Color.WHITE);
		txtpnNome.setFont(new Font("Kiona", Font.PLAIN, 25));
		txtpnNome.setEditable(false);
		txtpnNome.setBackground(Color.WHITE);
		txtpnNome.setBounds(115, 327, 85, 48);
		contentPane.add(txtpnNome);
		
		JTextPane txtpnEndereo = new JTextPane();
		txtpnEndereo.setText("ENDEREÇO");
		txtpnEndereo.setOpaque(false);
		txtpnEndereo.setForeground(Color.WHITE);
		txtpnEndereo.setFont(new Font("Kiona", Font.PLAIN, 25));
		txtpnEndereo.setEditable(false);
		txtpnEndereo.setBackground(Color.WHITE);
		txtpnEndereo.setBounds(60, 379, 143, 48);
		contentPane.add(txtpnEndereo);
		
		textField_gatos = new JTextField();
		textField_gatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(textField_gatos.getText())) {
					if (Integer.parseInt(textField_gatos.getText()) > 0) {
						txtpnAQuantidadeDeve.setVisible(false);
						textField_caes.setEnabled(true);
						textField_caes.requestFocus();
					}
					else {
						txtpnAQuantidadeDeve.setVisible(true);
						textField_caes.setEnabled(false);
					}
				}
				else {
					txtpnAQuantidadeDeve.setVisible(true);
					textField_caes.setEnabled(false);
				}
				
				
			}
		});
		textField_gatos.setColumns(10);
		textField_gatos.setBounds(204, 489, 261, 30);
		contentPane.add(textField_gatos);
		
		JTextPane txtpnQtdGatos = new JTextPane();
		txtpnQtdGatos.setText("QTD. GATOS");
		txtpnQtdGatos.setOpaque(false);
		txtpnQtdGatos.setForeground(Color.WHITE);
		txtpnQtdGatos.setFont(new Font("Kiona", Font.PLAIN, 25));
		txtpnQtdGatos.setEditable(false);
		txtpnQtdGatos.setBackground(Color.WHITE);
		txtpnQtdGatos.setBounds(38, 483, 170, 48);
		contentPane.add(txtpnQtdGatos);
		
		JTextPane txtpnQtdCes = new JTextPane();
		txtpnQtdCes.setText("QTD. CÃES");
		txtpnQtdCes.setOpaque(false);
		txtpnQtdCes.setForeground(Color.WHITE);
		txtpnQtdCes.setFont(new Font("Kiona", Font.PLAIN, 25));
		txtpnQtdCes.setEditable(false);
		txtpnQtdCes.setBackground(Color.WHITE);
		txtpnQtdCes.setBounds(57, 535, 179, 48);
		contentPane.add(txtpnQtdCes);
		
		JTextPane txtpnNomeDeveConter = new JTextPane();
		txtpnNomeDeveConter.setText("nome deve conter somente letras");
		txtpnNomeDeveConter.setOpaque(false);
		txtpnNomeDeveConter.setForeground(Color.WHITE);
		txtpnNomeDeveConter.setFont(new Font("Kiona", Font.PLAIN, 15));
		txtpnNomeDeveConter.setEditable(false);
		txtpnNomeDeveConter.setBackground(Color.WHITE);
		txtpnNomeDeveConter.setBounds(461, 327, 234, 48);
		contentPane.add(txtpnNomeDeveConter);
		txtpnNomeDeveConter.setVisible(false);
		
		JTextPane txtpnTelefone = new JTextPane();
		txtpnTelefone.setText("TELEFONE");
		txtpnTelefone.setOpaque(false);
		txtpnTelefone.setForeground(Color.WHITE);
		txtpnTelefone.setFont(new Font("Kiona", Font.PLAIN, 25));
		txtpnTelefone.setEditable(false);
		txtpnTelefone.setBackground(Color.WHITE);
		txtpnTelefone.setBounds(60, 431, 143, 48);
		contentPane.add(txtpnTelefone);
		
		JTextPane txtpnRgDeveConter = new JTextPane();
		txtpnRgDeveConter.setText("RG deve conter apenas números");
		txtpnRgDeveConter.setOpaque(false);
		txtpnRgDeveConter.setForeground(Color.WHITE);
		txtpnRgDeveConter.setFont(new Font("Kiona", Font.PLAIN, 15));
		txtpnRgDeveConter.setEditable(false);
		txtpnRgDeveConter.setBackground(Color.WHITE);
		txtpnRgDeveConter.setBounds(461, 279, 292, 48);
		contentPane.add(txtpnRgDeveConter);
		txtpnRgDeveConter.setVisible(false);
		
		textField_Cpf = new JTextField();
		textField_Cpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Protetor p = null;
				try {
					p = new Protetor();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (validaCpf(textField_Cpf.getText())) {
						txtpnCpfDeveConter.setVisible(false);
						if (p.protetorExiste(textField_Cpf.getText())) {
							System.out.println("Existe");
							txtpnCpfJExiste.setVisible(true);
							textField_Rg.setEnabled(false);
							textField_Nome.setEnabled(false);
							textField_Endereco.setEnabled(false);
							textField_Telefone.setEnabled(false);
							textField_caes.setEnabled(false);
							textField_gatos.setEnabled(false);
						}
						else {
							System.out.println("Não Existe");
							txtpnCpfJExiste.setVisible(false);
							textField_Rg.setEnabled(true);
							textField_Rg.requestFocus();
						}
					}
					else {
						txtpnCpfDeveConter.setVisible(true);
						textField_Rg.setEnabled(false);
						textField_Nome.setEnabled(false);
						textField_Endereco.setEnabled(false);
						textField_Telefone.setEnabled(false);
						textField_caes.setEnabled(false);
						textField_gatos.setEnabled(false);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_Cpf.setColumns(10);
		textField_Cpf.setBounds(202, 225, 261, 30);
		contentPane.add(textField_Cpf);
		
		textField_Rg = new JTextField();
		textField_Rg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaRg(textField_Rg.getText())) {
					txtpnRgDeveConter.setVisible(false);
					textField_Nome.setEnabled(true);
					textField_Nome.requestFocus();
				}
				else {
					txtpnRgDeveConter.setVisible(true);
					textField_Nome.setEnabled(false);
					textField_Endereco.setEnabled(false);
					textField_Telefone.setEnabled(false);
					textField_caes.setEnabled(false);
					textField_gatos.setEnabled(false);
				}
				
				textField_Nome.requestFocus();
			}
		});
		textField_Rg.setColumns(10);
		textField_Rg.setBounds(202, 278, 261, 30);
		contentPane.add(textField_Rg);
		
		textField_Nome = new JTextField();
		textField_Nome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isOnlyLetters(textField_Nome.getText())) {
					txtpnNomeDeveConter.setVisible(false);
					textField_Endereco.setEnabled(true);
					textField_Endereco.requestFocus();
				}
				else {
					txtpnNomeDeveConter.setVisible(true);
					textField_Endereco.setEnabled(false);
					textField_Telefone.setEnabled(false);
					textField_caes.setEnabled(false);
					textField_gatos.setEnabled(false);
				}
			}
		});
		textField_Nome.setColumns(10);
		textField_Nome.setBounds(202, 330, 261, 30);
		contentPane.add(textField_Nome);
		
		RoundedButton botaoCadastrar = new RoundedButton("CADASTRAR");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		            Protetor p = null;
					try {
						p = new Protetor();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            
		            // Verifica se o CPF já exist

		                // Realiza o cadastro
		                String cpf = textField_Cpf.getText();
		                String rg = textField_Rg.getText();
		                String nome = textField_Nome.getText();
		                String endereco = textField_Endereco.getText();
		                String telefone = textField_Telefone.getText();
		                int qtdGatos = Integer.parseInt(textField_gatos.getText());
		                int qtdCaes = Integer.parseInt(textField_caes.getText());
		                
		                try {
							p.cadastrarProtetor(cpf, rg, nome, endereco, telefone, qtdGatos, qtdCaes, 0.0);
							JOptionPane.showMessageDialog(contentPane, "Protetor cadastrado com sucesso!");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                
		                System.out.println("Protetor cadastrado com sucesso.");
			}
		});
		
		textField_caes = new JTextField();
		textField_caes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(textField_caes.getText())) {
					if (Integer.parseInt(textField_caes.getText()) > 0) {
						txtpnAQuantidadeDeve_1.setVisible(false);
						botaoCadastrar.doClick();
					}
					else {
						txtpnAQuantidadeDeve_1.setVisible(true);
						botaoCadastrar.setEnabled(false);
					}
				}
				else {
					txtpnAQuantidadeDeve_1.setVisible(true);
					botaoCadastrar.setEnabled(false);
				}
				
			}
		});
		textField_caes.setColumns(10);
		textField_caes.setBounds(204, 539, 261, 30);
		contentPane.add(textField_caes);
		
		
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(349, 579, 116, 42);
		contentPane.add(botaoCadastrar);
		
		JButton BotaoVoltar = new JButton("Voltar");
		BotaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProtetores tp = new TelaProtetores();
				tp.setVisible(true);
				dispose();
			}
		});
		BotaoVoltar.setForeground(Color.WHITE);
		BotaoVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		BotaoVoltar.setBackground(new Color(0, 64, 128));
		BotaoVoltar.setBounds(10, 668, 197, 35);
		contentPane.add(BotaoVoltar);
	
	}
	
	private boolean validaRg(String rg) {
		if (isNumeric(rg)) return true;
		else return false;
	}
	
	
	private boolean validaCpf(String cpf) {
		// Verifica se o CPF tem 11 dígitos e se é um número válido
		if (cpf.length() != 11 || !isNumeric(cpf)) {
			return false;
		}
		
		 // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigito = (soma % 11 < 2) ? 0 : 11 - (soma % 11);
        
        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        soma += primeiroDigito * 2;
        int segundoDigito = (soma % 11 < 2) ? 0 : 11 - (soma % 11);

        // Compara os dígitos verificadores
        return (Character.getNumericValue(cpf.charAt(9)) == primeiroDigito &&
                Character.getNumericValue(cpf.charAt(10)) == segundoDigito);
	}
	
	private boolean isNumeric(String str) {
		return str.matches("\\d+");
	}
	
	public static boolean isOnlyLetters(String input) {
        if (input == null || input.isEmpty()) {
            return false; // Retorna falso se a string for nula ou vazia
        }
        
        // Verifica se cada caractere é uma letra
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
            	if (c != ' ') {
            		return false; // Retorna falso se encontrar um caractere não permitido
            	}
                
            }
        }
        
        return true; // Retorna verdadeiro se todos os caracteres forem letras
    }
}
