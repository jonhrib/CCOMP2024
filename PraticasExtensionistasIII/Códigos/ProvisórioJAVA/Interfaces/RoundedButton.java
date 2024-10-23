package Interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class RoundedButton extends JButton {
    private static final int BORDER_RADIUS = 50; // Raio das bordas arredondadas
    private Color hoverBackground = new Color(207, 188, 188); // Cor ao passar o mouse
    private Color defaultBackground = new Color(224, 212, 212); // Cor padrão
    private Color defaultForeground = new Color(97, 97, 97); // Cor do texto padrão

    public RoundedButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(defaultBackground);
        setForeground(defaultForeground);

        // Adiciona um listener para o mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultBackground);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Desenha o botão com bordas arredondadas
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), BORDER_RADIUS, BORDER_RADIUS);
        super.paintComponent(g);
        // Desenha a borda
        g.setColor(Color.WHITE); // Cor da borda
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, BORDER_RADIUS, BORDER_RADIUS);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        repaint();
    }
}
