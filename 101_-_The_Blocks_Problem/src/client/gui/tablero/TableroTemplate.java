package client.gui.tablero;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TableroTemplate extends JPanel{
    
    private int[][] tablero;
    private Graphics g;
    
    protected TableroTemplate(int[][] t){
        tablero = t;
        repaint();
        setBounds(0, 0, 2 + 34*t.length + 32, 32 + 25*t.length + 32);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero.length; j++){
                if(tablero[i][j]!=-1){
                    int cx= j * 34 + 16;
                    int cy= i * 25 + 16;

                    g.setColor(new Color(255, 225, 0));
                    g.fillRect(cx, cy, 34, 25);

                    g.setColor(new Color(169, 105, 0));
                    g.drawRect(cx, cy, 34, 25);
                    g.drawRect(cx+1, cy+1, 32, 23);

                    g.setColor(BLACK);
                    g.drawString(String.valueOf(tablero[i][j]), cx + 11, cy + 18);
                }
            }
        }
    }
    
}
