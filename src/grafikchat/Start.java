/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat;

import grafikchat.controller.CommandConnect;
import grafikchat.controller.ReceiveAdapter;
import grafikchat.controller.ViewController;
import grafikchat.model.ChatModel;
import grafikchat.model.Transmitter;
import grafikchat.model.GrafikDaten;
import grafikchat.view.ChatView;
import grafikchat.view.View;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author Christian
 */
public class Start 
{
  public Start()
  {
    ChatView view = new ChatView();

    Transmitter tm = new Transmitter();
    GrafikDaten gd = new GrafikDaten();
    ChatModel chatmodel = new ChatModel(tm,gd);
    CommandConnect con = new CommandConnect(view,chatmodel);
    con.registerEvents();
    tm.setModel(chatmodel);   
       
    View drawview = view.getView1();
    GrafikDaten model = new GrafikDaten();
    ReceiveAdapter rec = new ReceiveAdapter(drawview,chatmodel);
    rec.onSubscription();
    drawview.setModel(chatmodel);
    ViewController controller = new ViewController(drawview, chatmodel, view);
    controller.registerEvents();
    
    view.setSize(800,600);
    view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    view.setVisible(true);
    
  }

  public static void main(String[] args) 
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, e.toString());
    }
    new Start();
  }

}
