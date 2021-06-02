/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat.controller;

import grafikchat.model.ChatModel;
import grafikchat.view.ChatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import ohmlogger.OhmLogger;

/**
 *
 * @author Christian
 */
public class CommandConnect implements ActionListener
{
  private static Logger lg = OhmLogger.getLogger();
  private ChatView view;
  private ChatModel model;
  
  public CommandConnect(ChatView view, ChatModel model)
  {
    this.view = view;
    this.model = model;
  }
  
  public void registerEvents()
  {
    view.getBtnConnect().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(view.getSelectSC().getSelectedItem().equals("Server") && model.isConnected() == false)
    {
      lg.info("Server");
      model.setServer();
      model.start();
    }
    else if(view.getSelectSC().getSelectedItem().equals("Client") && model.isConnected() == false)
    {
      lg.info("Client");
      model.setClient();
      model.setIP(view.getTfIP().getText());
      model.start();
    }
  }
}
