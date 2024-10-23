package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classes.Animal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizarAnimais extends JFrame {

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
                    VisualizarAnimais frame = new VisualizarAnimais();
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
    public VisualizarAnimais() {
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
        txtpnVisualizarProtetor.setText("VISUALIZAR ANIMAIS");
        txtpnVisualizarProtetor.setOpaque(false);
        txtpnVisualizarProtetor.setForeground(new Color(242, 121, 121));
        txtpnVisualizarProtetor.setFont(new Font("Just Another Hand", Font.PLAIN, 75));
        txtpnVisualizarProtetor.setEditable(false);
        txtpnVisualizarProtetor.setBounds(289, 20, 533, 82);
        contentPane.add(txtpnVisualizarProtetor);

        // Configuração da JTable
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Código");
        tableModel.addColumn("Tipo (Cão/Gato)");
        tableModel.addColumn("Raça");
        tableModel.addColumn("Cor");
        tableModel.addColumn("Peso (kg)");
        tableModel.addColumn("Status"); // Nova coluna para status de adoção

        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 103, 1021, 548);
        contentPane.add(scrollPane);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaAnimais tp = new TelaAnimais();
        		tp.setVisible(true);
        		dispose();
        	}
        });
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnVoltar.setBackground(new Color(0, 64, 128));
        btnVoltar.setBounds(10, 661, 197, 35);
        contentPane.add(btnVoltar);

        // Carregar dados dos animais do banco de dados e exibir
        try {
            carregarAnimais();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carregar os dados dos animais do banco de dados e exibi-los na JTable.
     */
    private void carregarAnimais() throws SQLException, ClassNotFoundException {
        Animal animalDAO = new Animal();
        List<String[]> animais = animalDAO.encontrarAnimais();

        // Limpa os dados antigos da tabela (se houver)
        tableModel.setRowCount(0);

        // Adiciona cada animal à tabela
        for (String[] animal : animais) {
            // Supondo que você tenha um método que retorna se o animal está adotado
            String codigo = animal[0]; // O código do animal está na primeira coluna
            boolean adotado = animalDAO.isAdotado(codigo); // Verifica se o animal está adotado
            String status = adotado ? "Adotado" : "Disponível"; // Define o status
            
            // Adiciona o animal e o status na tabela
            tableModel.addRow(new Object[]{animal[0], animal[1], animal[2], animal[3], animal[4], status});
        }
    }
}
