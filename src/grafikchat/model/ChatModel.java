/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat.model;

import java.awt.Point;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.SubmissionPublisher;

/**
 *
 * @author Christian
 */
public class ChatModel implements Publisher
{
  private Transmitter tm;
  private GrafikDaten gd;
 
  private SubmissionPublisher<Figur> iPublisher;
  
  public ChatModel(Transmitter tm, GrafikDaten gd)
  {
    this.tm = tm;
    this.gd = gd;

    iPublisher = new SubmissionPublisher<>();
  }
  
  public void addSubscription(Flow.Subscriber<Figur> subscriber)
  {
    iPublisher.subscribe(subscriber);
  }
  
  public void submit(Figur msg)
  {
    iPublisher.submit(msg);
  }
  
  public void setServer()
  {
    tm.setServer();
  }
  
  public void setClient()
  {
    tm.setClient();
  }
  
  public void start()
  {
    tm.start();
  }
  
  public void setIP(String ip)
  {
    tm.setIP(ip);
  }
  
  public boolean isConnected()
  {
    return tm.isConnected();
  }
  
  public void sendFigure(Figur figur)
  {
    tm.sendFigure(figur);
  }
  
  public void addFigure()
  {
    gd.addFigure();
  }
  
  public Figur getFigure()
  {
    return gd.getFigure();
  }
  
  public void setFigure(Figur figur)
  {
    gd.setFigure(figur);
  }
  
  public Point getPoint()
  {
    return gd.getPoint();
  }
  
  public void addPoint(Point p)
  {
    gd.addPoint(p);
  }
  
  public List<Figur> getFigures()
  {
    return gd.getFigures();
  }
  
  @Override
  public void subscribe(Flow.Subscriber subscriber)
  {
  }
}
