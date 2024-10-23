package Interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 750);
		//contentPane.setBackground(new Color(0, 64, 128));
		contentPane = new JPanel() {
			// Sobrescreva o método paintComponent para desenhar a imagem de fundo
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\jonhv\\Downloads\\pngegg-1.png"); // Substitua pelo caminho correto
				Image backgroundImage = backgroundIcon.getImage();
				g.drawImage(backgroundImage, 670, 450, 398, 282, this);
				
				ImageIcon backgroundIcon2 = new ImageIcon("C:\\Users\\jonhv\\Downloads\\image-1.png"); // Substitua pelo caminho correto
				Image backgroundImage2 = backgroundIcon2.getImage();
				g.drawImage(backgroundImage2, 815, 170, 71, 73, this);
				
				ImageIcon backgroundIcon3 = new ImageIcon("C:\\Users\\jonhv\\Downloads\\image-2.png"); // Substitua pelo caminho correto
				Image backgroundImage3 = backgroundIcon3.getImage();
				g.drawImage(backgroundImage3, 0, 280, 438, 530, this);
			}
		
		};
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setLayout(null);  // Para posicionar componentes manualmente
		setContentPane(contentPane);
		
		setResizable(false);

		// Botões e demais componentes
		RoundedButton btnNewButton = new RoundedButton("Protetores");
		btnNewButton.setForeground(new Color(97, 97, 97));
		btnNewButton.setBackground(new Color(224, 212, 212));
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProtetores tp = new TelaProtetores();
				tp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(49, 203, 251, 48);
		contentPane.add(btnNewButton);

		RoundedButton btnAnimais = new RoundedButton("Animais");
		btnAnimais.setForeground(new Color(97, 97, 97));
		btnAnimais.setBackground(new Color(224, 212, 212));
		btnAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnimais ta = new TelaAnimais();
				ta.setVisible(true);
				dispose();
			}
		});
		btnAnimais.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnAnimais.setBounds(49, 276, 251, 48);
		contentPane.add(btnAnimais);

		RoundedButton btnAdotantes = new RoundedButton("Adotantes");
		btnAdotantes.setForeground(new Color(97, 97, 97));
		btnAdotantes.setBackground(new Color(224, 212, 212));
		btnAdotantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdotantes tad = new TelaAdotantes();
				tad.setVisible(true);
				dispose();
			}
		});
		btnAdotantes.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnAdotantes.setBounds(49, 347, 251, 48);
		contentPane.add(btnAdotantes);

		RoundedButton btnRao = new RoundedButton("Ração");
		btnRao.setEnabled(false);
		btnRao.setForeground(new Color(97, 97, 97));
		btnRao.setBackground(new Color(224, 212, 212));
		btnRao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRação tr = new TelaRação();
				tr.setVisible(true);
				dispose();
			}
		});
		btnRao.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnRao.setBounds(49, 424, 251, 48);
		contentPane.add(btnRao);

		RoundedButton btnCastrao = new RoundedButton("Castração");
		btnCastrao.setEnabled(false);
		btnCastrao.setForeground(new Color(97, 97, 97));
		btnCastrao.setBackground(new Color(224, 212, 212));
		btnCastrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCastração tc = new TelaCastração();
				tc.setVisible(true);
				dispose();
			}
		});
		btnCastrao.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnCastrao.setBounds(49, 500, 251, 48);
		contentPane.add(btnCastrao);

		JTextPane txtpnSelecioneASua = new JTextPane();
		txtpnSelecioneASua.setEditable(false);
		txtpnSelecioneASua.setForeground(Color.WHITE);
		txtpnSelecioneASua.setFont(new Font("Kiona", Font.PLAIN, 18));
		txtpnSelecioneASua.setText("Selecione a sua opção:");
		txtpnSelecioneASua.setBounds(49, 160, 251, 33);
		txtpnSelecioneASua.setOpaque(false);
		contentPane.add(txtpnSelecioneASua);


		JTextPane txtpnCemsa = new JTextPane();
		txtpnCemsa.setEditable(false);
		txtpnCemsa.setText("CEMSA");
		txtpnCemsa.setOpaque(false);
		txtpnCemsa.setForeground(new Color(242, 121, 121));
		txtpnCemsa.setFont(new Font("Just Another Hand", Font.PLAIN, 240));
		txtpnCemsa.setBounds(404, 231, 498, 234);
		contentPane.add(txtpnCemsa);

		JTextPane txtpnCoordenao = new JTextPane();
		txtpnCoordenao.setEditable(false);
		txtpnCoordenao.setText("COORDENAÇÃO");
		txtpnCoordenao.setOpaque(false);
		txtpnCoordenao.setForeground(Color.WHITE);
		txtpnCoordenao.setFont(new Font("Just Another Hand", Font.PLAIN, 45));
		txtpnCoordenao.setBounds(770, 417, 194, 48);
		contentPane.add(txtpnCoordenao);
	}
}
