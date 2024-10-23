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

import Classes.Adotante;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizarAdotantes extends JFrame {

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
                    VisualizarAdotantes frame = new VisualizarAdotantes();
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
    public VisualizarAdotantes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1055, 750);
        contentPane = new JPanel() {
            // Sobrescreve o método paintComponent para desenhar a imagem de fundo
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\jonhv\\Downloads\\image-2.png"); // Substitua pelo caminho correto
                Image backgroundImage = backgroundIcon.getImage();
                g.drawImage(backgroundImage, 0, 280, 438, 530, this);
            }
        };
        contentPane.setBackground(new Color(0, 64, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título
        JTextPane txtpnVisualizarAdotantes = new JTextPane();
        txtpnVisualizarAdotantes.setText("VISUALIZAR ADOTANTES");
        txtpnVisualizarAdotantes.setOpaque(false);
        txtpnVisualizarAdotantes.setForeground(new Color(242, 121, 121));
        txtpnVisualizarAdotantes.setFont(new Font("Just Another Hand", Font.PLAIN, 75));
        txtpnVisualizarAdotantes.setEditable(false);
        txtpnVisualizarAdotantes.setBounds(289, 20, 533, 82);
        contentPane.add(txtpnVisualizarAdotantes);

        // Configuração da JTable
        tableModel = new DefaultTableModel();
        tableModel.addColumn("CPF");
        tableModel.addColumn("RG");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("Telefone");

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
        		TelaAdotantes ta = new TelaAdotantes();
        		ta.setVisible(true);
        		dispose();
        	}
        });
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnVoltar.setBackground(new Color(0, 64, 128));
        btnVoltar.setBounds(10, 661, 197, 35);
        contentPane.add(btnVoltar);

        // Carregar dados dos adotantes do banco de dados e exibir
        try {
            carregarAdotantes();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carregar os dados dos adotantes do banco de dados e exibi-los na JTable.
     */
    private void carregarAdotantes() throws SQLException, ClassNotFoundException {
        Adotante adotanteDAO = new Adotante();
        List<String[]> adotantes = adotanteDAO.encontrarAdotantes();

        // Limpa os dados antigos da tabela (se houver)
        tableModel.setRowCount(0);

        // Adiciona cada adotante à tabela
        for (String[] adotante : adotantes) {
            tableModel.addRow(adotante);
        }
    }
}
