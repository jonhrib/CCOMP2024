package Interfaces;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRação extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRação frame = new TelaRação();
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
	public TelaRação() {
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
		
		JTextPane txtpnRao = new JTextPane();
		txtpnRao.setText("RAÇÃO");
		txtpnRao.setOpaque(false);
		txtpnRao.setForeground(new Color(242, 121, 121));
		txtpnRao.setFont(new Font("Just Another Hand", Font.PLAIN, 240));
		txtpnRao.setEditable(false);
		txtpnRao.setBackground(Color.WHITE);
		txtpnRao.setBounds(289, 237, 639, 247);
		contentPane.add(txtpnRao);
		
		RoundedButton btnEntrada = new RoundedButton("Entrada");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrada.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnEntrada.setBounds(111, 462, 251, 48);
		contentPane.add(btnEntrada);
		
		RoundedButton btnNewButton_1 = new RoundedButton("Saída");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnNewButton_1.setBounds(395, 462, 251, 48);
		contentPane.add(btnNewButton_1);
		
		RoundedButton btnNewButton_1_1 = new RoundedButton("Relatório");
		btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnNewButton_1_1.setBounds(676, 462, 251, 48);
		contentPane.add(btnNewButton_1_1);
		
		JTextPane txtpnCastrao_1 = new JTextPane();
		txtpnCastrao_1.setText("~");
		txtpnCastrao_1.setOpaque(false);
		txtpnCastrao_1.setForeground(new Color(242, 121, 121));
		txtpnCastrao_1.setFont(new Font("Kristen ITC", Font.PLAIN, 99));
		txtpnCastrao_1.setEditable(false);
		txtpnCastrao_1.setBackground(Color.WHITE);
		txtpnCastrao_1.setBounds(576, 148, 805, 247);
		contentPane.add(txtpnCastrao_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		//btnNewButton_2.setEnabled(false);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 64, 128));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnNewButton_2.setBounds(9, 667, 197, 35);
		contentPane.add(btnNewButton_2);
	}

}
