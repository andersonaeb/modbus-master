import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Button extends JPanel implements ActionListener{
  JButton botao;
  String aux;

  public Button(String nome, boolean select){ //true para room, false para data
    botao = new JButton(nome);
    aux = nome;
    if(select) botao.setActionCommand("showInfo");
    else botao.setActionCommand("showRoom");
    botao.addActionListener(this);
    add(botao);
  }

  public void actionPerformed(ActionEvent evento) {
    if ("showInfo".equals(evento.getActionCommand())) {
      JFrame tmp = new JFrame(aux);
      JPanel q = new JPanel();
      switch(aux){
        case "Piscina":
          Button lampada1Piscina = new Button("Lâmpada 1", false);
          q.add(lampada1Piscina);
          Button lampada2Piscina = new Button("Lâmpada 2", false);
          q.add(lampada2Piscina);
          Button lampada3Piscina = new Button("Lâmpada 3", false);
          q.add(lampada3Piscina);
          Button alarmePiscina = new Button("Alarme", false);
          q.add(alarmePiscina);
          Button temperaturaPiscina = new Button("Temperatura", false);
          q.add(temperaturaPiscina);
          Button aguafriaPiscina = new Button("Água Fria", false);
          q.add(aguafriaPiscina);
          Button aguaquentePiscina = new Button("Água Quente", false);
          q.add(aguaquentePiscina);
        break;
        case "Garagem":
          Button lampadaGaragem = new Button("Lâmpada", false);
          q.add(lampadaGaragem);
          Button alarmeGaragem = new Button("Alarme", false);
          q.add(alarmeGaragem);
        break;
        case "Lavanderia":
          Button lampadaLavanderia = new Button("Lâmpada", false);
          q.add(lampadaLavanderia);
        break;
        case "Varanda":
          Button lampadaVaranda = new Button("Lâmpada", false);
          q.add(lampadaVaranda);
        break;
        case "Varanda da Piscina":
          Button lampadaVarandaPiscina = new Button("Lâmpada", false);
          q.add(lampadaVarandaPiscina);
        break;
        case "Lavatório":
          Button lampadaLavatório = new Button("Lâmpada", false);
          q.add(lampadaLavatório);
        break;
        case "Closet":
          Button lampadaCloset = new Button("Lâmpada", false);
          q.add(lampadaCloset);
        break;
        case "Depósito":
          Button lampadaDepósito = new Button("Lâmpada", false);
          q.add(lampadaDepósito);
        break;
        case "Lavabo":
          Button lampadaLavabo = new Button("Lâmpada", false);
          q.add(lampadaLavabo);
        break;
        case "Circulação":
          Button lampadaCirculação = new Button("Lâmpada", false);
          q.add(lampadaCirculação);
        break;
        case "Cozinha":
          Button lampada1Cozinha = new Button("Lâmpada 1", false);
          q.add(lampada1Cozinha);
          Button lampada2Cozinha = new Button("Lâmpada 2", false);
          q.add(lampada2Cozinha);
          Button lampada3Cozinha = new Button("Lâmpada 3", false);
          q.add(lampada3Cozinha);
          Button alarmeCozinha = new Button("Alarme", false);
          q.add(alarmeCozinha);
        break;
        case "Sala de Estar":
          Button lampada1Estar = new Button("Lâmpada 1", false);
          q.add(lampada1Estar);
          Button lampada2Estar = new Button("Lâmpada 2", false);
          q.add(lampada2Estar);
          Button lampada3Estar = new Button("Lâmpada 3", false);
          q.add(lampada3Estar);
          Button alarmeEstar = new Button("Alarme", false);
          q.add(alarmeEstar);
          Button temperaturaEstar = new Button("Temperatura", false);
          q.add(temperaturaEstar);
        break;
        case "Sala de Jantar":
          Button lampada1Jantar = new Button("Lâmpada 1", false);
          q.add(lampada1Jantar);
          Button lampada2Jantar = new Button("Lâmpada 2", false);
          q.add(lampada2Jantar);
        break;
        case "Sala de Jogos":
          Button lampada1Jogos = new Button("Lâmpada 1", false);
          q.add(lampada1Jogos);
          Button lampada2Jogos = new Button("Lâmpada 2", false);
          q.add(lampada2Jogos);
          Button alarmeJogos = new Button("Alarme", false);
          q.add(alarmeJogos);
          Button temperaturaJogos = new Button("Temperatura", false);
          q.add(temperaturaJogos);
        break;
        case "Dormitório 1":
          Button lampadaDormitório1 = new Button("Lâmpada", false);
          q.add(lampadaDormitório1);
          Button alarmeDormitório1 = new Button("Alarme", false);
          q.add(alarmeDormitório1);
          Button temperaturaDormitório1 = new Button("Temperatura", false);
          q.add(temperaturaDormitório1);
        break;
        case "Dormitório 2":
          Button lampadaDormitório2 = new Button("Lâmpada", false);
          q.add(lampadaDormitório2);
          Button alarmeDormitório2 = new Button("Alarme", false);
          q.add(alarmeDormitório2);
          Button temperaturaDormitório2 = new Button("Temperatura", false);
          q.add(temperaturaDormitório2);
        break;
        case "BWC 1":
          Button lampadaBWC1 = new Button("Lâmpada", false);
          q.add(lampadaBWC1);
          Button temperaturaBWC = new Button("Temperatura", false);
          q.add(temperaturaBWC);
          Button aguafriaBWC = new Button("Água Fria", false);
          q.add(aguafriaBWC);
          Button aguaquenteBWC = new Button("Água Quente", false);
          q.add(aguaquenteBWC);
          Button nivelBWC = new Button("Nível da Água", false);
          q.add(nivelBWC);
          Button esgotaBWC = new Button("Esgotar Água", false);
          q.add(esgotaBWC);
        break;
        case "BWC 2":
          Button lampadaBWC2 = new Button("Lâmpada", false);
          q.add(lampadaBWC2);
        break;
        case "BWC 3":
          Button lampadaBWC3 = new Button("Lâmpada", false);
          q.add(lampadaBWC3);
        break;
        case "Suite":
          Button lampada1Suite = new Button("Lâmpada 1", false);
          q.add(lampada1Suite);
          Button lampada2Suite = new Button("Lâmpada 2", false);
          q.add(lampada2Suite);
          Button lampada3Suite = new Button("Lâmpada 3", false);
          q.add(lampada3Suite);
          Button alarmeSuite = new Button("Alarme", false);
          q.add(alarmeSuite);
          Button temperaturaSuite = new Button("Temperatura", false);
          q.add(temperaturaSuite);
        break;
        default:
        break;
      }
      tmp.add(q);
      tmp.setSize(500, 300);
      tmp.setVisible(true);
	  } else if ("showRoom".equals(evento.getActionCommand())) {
      JFrame tmp = new JFrame(aux);
      JPanel q = new JPanel();
      switch(aux){
        case "Lâmpada 1":

        break;
        case "Lâmpada 2":

        break;
        case "Lâmpada 3":

        break;
        case "Lâmpada":

        break;
        case "Alarme":

        break;
        case "Temperatura":

        break;
        case "Água Fria":

        break;
        case "Água Quente":

        break;
        case "Nível da Água":

        break;
        case "Esgotar Água":

        break;
        default:
        break;
      }
    }
  }
}
