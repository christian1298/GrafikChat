/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat.controller;

import grafikchat.model.ChatModel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import grafikchat.view.ChatView;
import grafikchat.view.View;

/**
 *
 * @author Christian
 */
public class ViewController extends MouseAdapter implements MouseMotionListener
{
  private View view;
  private ChatModel model;
  private ChatView window;
  
  public ViewController(View view, ChatModel model, ChatView window)
  {
    this.view = view;
    this.model = model;
    this.window = window;
  }
  
  public void registerEvents()
  {
    view.addMouseMotionListener(this);
    view.addMouseListener(this);
  }
  
  public void mouseReleased(MouseEvent e)
  {
    if(e.getButton() == MouseEvent.BUTTON1)
    {
      if(model.isConnected())
      model.sendFigure(model.getFigure());
      model.addFigure();
    }
  }

  @Override
  public void mouseDragged(MouseEvent e)
  {
    Point p = e.getPoint();
    view.drawPoint(p);
  }

  @Override
  public void mouseMoved(MouseEvent e)
  {
  }
}
