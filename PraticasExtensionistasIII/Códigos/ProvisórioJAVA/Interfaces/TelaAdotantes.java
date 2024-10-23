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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaAdotantes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdotantes frame = new TelaAdotantes();
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
	public TelaAdotantes() {
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
		
		JTextPane txtpnAdotantes = new JTextPane();
		txtpnAdotantes.setText("ADOTANTES");
		txtpnAdotantes.setOpaque(false);
		txtpnAdotantes.setForeground(new Color(242, 121, 121));
		txtpnAdotantes.setFont(new Font("Just Another Hand", Font.PLAIN, 240));
		txtpnAdotantes.setEditable(false);
		txtpnAdotantes.setBackground(Color.WHITE);
		txtpnAdotantes.setBounds(132, 228, 799, 208);
		contentPane.add(txtpnAdotantes);
		
		RoundedButton btnNewButton_1 = new RoundedButton("Visualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarAdotantes va = new VisualizarAdotantes();
				va.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		btnNewButton_1.setBounds(408, 446, 251, 48);
		contentPane.add(btnNewButton_1);
		
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
