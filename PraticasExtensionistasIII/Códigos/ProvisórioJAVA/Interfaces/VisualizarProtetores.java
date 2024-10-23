package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classes.Protetor;

public class VisualizarProtetores extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VisualizarProtetores frame = new VisualizarProtetores();
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
    public VisualizarProtetores() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1055, 750);
        contentPane = new JPanel() {
            // Sobrescreve o método paintComponent para desenhar a imagem de fundo
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
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título
        JTextPane txtpnVisualizarProtetor = new JTextPane();
        txtpnVisualizarProtetor.setText("VISUALIZAR PROTETOR");
        txtpnVisualizarProtetor.setOpaque(false);
        txtpnVisualizarProtetor.setForeground(new Color(242, 121, 121));
        txtpnVisualizarProtetor.setFont(new Font("Just Another Hand", Font.PLAIN, 75));
        txtpnVisualizarProtetor.setEditable(false);
        txtpnVisualizarProtetor.setBounds(299, 20, 533, 82);
        contentPane.add(txtpnVisualizarProtetor);

        // Configuração da JTable
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Impede edição de qualquer célula
                return false;
            }
        };

        // Adicionando as colunas
        tableModel.addColumn("CPF");
        tableModel.addColumn("RG");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Gatos");
        tableModel.addColumn("Cães");
        tableModel.addColumn("Ração (kg)");

        // Criando a JTable e aplicando o modelo
        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 103, 1021, 559);
        contentPane.add(scrollPane);

        // Carregar dados dos protetores do banco de dados e exibir
        try {
            carregarProtetores();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProtetores tp = new TelaProtetores();
				tp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnNewButton_2.setBackground(new Color(0, 64, 128));
		btnNewButton_2.setBounds(10, 668, 197, 35);
		contentPane.add(btnNewButton_2);
    }

    /**
     * Carregar os dados dos protetores do banco de dados e exibi-los na JTable.
     */
    private void carregarProtetores() throws SQLException, ClassNotFoundException {
        Protetor protetorDAO = new Protetor();
        List<String[]> protetores = protetorDAO.encontrarProtetores();

        // Limpa os dados antigos da tabela (se houver)
        tableModel.setRowCount(0);

        // Adiciona cada protetor à tabela
        for (String[] protetor : protetores) {
            tableModel.addRow(protetor);
        }
    }
}
