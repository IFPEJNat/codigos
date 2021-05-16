import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;

public class MyPanel extends JPanel 
{

    MainWindow obtainNumber = new MainWindow();
    int tamanho = obtainNumber.getValue(); //Obtém o valor digitado para desenhar o gráfico

    @Override
    protected void paintComponent(Graphics g) {

        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        List<Integer> numbers = new ArrayList<>();

        for(int i=0; i<tamanho ;i++)
        {
            numbers.add(i+1); //Adiciona os valores na lista a partir do 1
        }

        Collections.shuffle(numbers);
        int outerSpace = 5;
        int innerSpace = 1;
        int QTD = numbers.size();
        int width = (this.getWidth() - 2 * outerSpace - (QTD - 1) * innerSpace) / QTD;
        int height = (this.getHeight() - 2 * outerSpace) / QTD;
        g.setColor(Color.white);
        for (int idx = 0; idx < QTD; idx++) {
            int n = numbers.get(idx);
            g.fillRect(idx * (width + innerSpace) + outerSpace, this.getHeight() - n * height - outerSpace, width, n * height);
        }
    }
}
