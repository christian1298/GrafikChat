/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohmlogger.OhmLogger;

/**
 *
 * @author Christian
 */
public class Transmitter implements Runnable
{
  private static Logger lg = OhmLogger.getLogger();
  
  private ExecutorService eService;
  //private BufferedReader in;
  //private PrintWriter out;
  private Boolean running;
  private Boolean mode; // true = Server, false = client
  private String IP;
  private static final int PORT = 35000;
  private Boolean connected;
  private ObjectOutputStream oos = null;
  private ObjectInputStream ois = null;
  
  ChatModel model;
  
  public Transmitter()
  {
    eService = Executors.newSingleThreadExecutor();

    running = false;
    mode = false;
    IP = "";
    connected = false;
    
    this.model = null;
  }
  
  public void setModel(ChatModel model)
  {
    this.model = model;
  }
  
  public Boolean isConnected()
  {
    return connected;
  }
  
 public synchronized void start()
  {
    running = true;
    lg.info("Start");
    // LSG 3 \\
    //notifyAll();
    // LSG 3 \\
    
    eService.submit(this);
  }
  
  public void setServer() // Set Mode to SERVER mode
  {
    mode = true;
  }
  
  public void setClient() // Set Mode to CLIENT mode
  {
    mode = false;
  }
  
  public void setIP(String newIP)
  {
    IP = newIP;
  }
  
  public void sendFigure(Figur figur)
  {
    lg.info("Sending Figur");
    try
    {
      oos.writeObject(figur);
      oos.flush();
    }
    catch (IOException ex)
    {
      Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  @Override
  public void run()
  {
    
    
    while(running)
    {
      try
      {
        ServerSocket sSocket;
        Socket s = null;
        
        if(mode == true) // if Server
        {
          lg.info("Starting Server");
          sSocket = new ServerSocket(PORT);
          s = sSocket.accept();
        }
        else if(mode == false) // if Client
        {
          lg.info("Starting Client");
          s = new Socket(IP, PORT);  // ACHTUNG blockiert!!!
        }
        lg.info("Connected");
        connected = true;
        
        OutputStream oStream = s.getOutputStream();
        InputStream iStream = s.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(oStream);
        BufferedInputStream bis = new BufferedInputStream(iStream);
        oos = new ObjectOutputStream(bos);
        ois = new ObjectInputStream(bis);
      }catch(IOException ex)
      {
        Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      while(true)
      {
        try
        {
          Figur figur = (Figur)ois.readObject();
          lg.info("Neue Figur");
          model.submit(figur);
        }
        catch (Exception ex)
        {
          lg.severe(ex.toString());
        }
      }
    }
  }
}
