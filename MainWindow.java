import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener //Deve implementar a interface Listener
{
    //Implementações no corpo da classe para poderem ser usadas pelos métodos

    JTextField textBox = new JTextField(5); // Caixa de texto
    JButton shuffleButton = new JButton("Shuffle"); // Botão
    private MyPanel pCanvas; // Painel das barras
    public static String s; // Valor digitado na caixa

    private void createWindow() {
        
        this.setPreferredSize(new Dimension(618, 726));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        
        /*Painel de cima*/
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel("Ordena\u00e7\u00e3o"); //Código pra funcionar os acentos no VSCODE
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        topPanel.add(titulo);
        topPanel.setMaximumSize(new Dimension(640, 50));
        this.add(topPanel);
        
        /* Painel de baixo - Caixa de Texto e Botão */
        JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        downPanel.add(textBox);
    
        shuffleButton.setSize(10, 10);
        shuffleButton.setFont(new Font("Serif", Font.BOLD, 12));
        downPanel.add(shuffleButton);
                
        downPanel.setMaximumSize(new Dimension(640, 50));
        this.add(downPanel);

        shuffleButton.addActionListener(this); // Adiciona evento ao botão

        /*Criando as barras*/

        MainWindow.setsValue("10"); // Seta o valor inicial das barras
        pCanvas = new MyPanel(); // Instancia o painel com as barras
        this.add(pCanvas); // Adiciona
        this.pack();
    }
    
    public MainWindow() {
        super("Sorting Algorithms");
    }
    
    public static void main(String[] args) {
        MainWindow w = new MainWindow();
        w.createWindow();
    }

    @Override //Método de ação do botão
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == shuffleButton) //Se o botão apertado for o Shuffle
        {
            if(textBox.getText()!=null)
            {
                MainWindow.setsValue(textBox.getText()); // Seta o novo valor de dentro da caixa
                this.remove(pCanvas); // Remove o painel antigo
                pCanvas = new MyPanel(); // Instancia um novo painel com novo valor
                this.add(pCanvas); // Adiciona
                this.pack();
            }
        }
    }
    
    public int getValue()
    {
        return Integer.parseInt(s); // Pega o valor da caixa e transforma em inteiro
    }

    public static void setsValue(String value)
    {
        MainWindow.s = value; // Seta o valor de s para o digitado na caixa
    }

}