import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {

  public static void main(String[] args){
    JFrame j = new JFrame("Controle da Casa");
    Button[] botao = new Button[20];
    JPanel p = new JPanel();

    botao[0] = new Button("Piscina", true);
    botao[1] = new Button("Garagem", true);
    botao[2] = new Button("Lavanderia", true);
    botao[3] = new Button("Varanda", true);
    botao[4] = new Button("Varanda da Piscina", true);
    botao[5] = new Button("Lavatório", true);
    botao[6] = new Button("Closet", true);
    botao[7] = new Button("Depósito", true);
    botao[8] = new Button("Lavabo", true);
    botao[9] = new Button("Circulação", true);
    botao[10] = new Button("Cozinha", true);
    botao[11] = new Button("Sala de Estar", true);
    botao[12] = new Button("Sala de Jantar", true);
    botao[13] = new Button("Sala de Jogos", true);
    botao[14] = new Button("Dormitório 1", true);
    botao[15] = new Button("Dormitório 2", true);
    botao[16] = new Button("BWC 1", true);
    botao[17] = new Button("BWC 2", true);
    botao[18] = new Button("BWC 3", true);
    botao[19] = new Button("Suite", true);

    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j.pack();
    j.setSize(500, 300);

    for(int i = 0; i < 20; i++){
      p.add(botao[i]);
  }

    j.add(p);
    j.setSize(500, 300);
    j.setVisible(true);
  }


}
