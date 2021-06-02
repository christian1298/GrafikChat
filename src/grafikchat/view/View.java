/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat.view;

import grafikchat.model.ChatModel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class View extends JComponent implements Printable
{
  //private final static Dimension DIM_ONE = new Dimension(1,1);
  
  private Line2D.Float line;
  private ChatModel model;
  private Point p0;
  
  public View()
  {
    line = new Line2D.Float();
  }
  
  public void setModel(ChatModel model)
  {
    this.model = model;
  }
  
  public void drawPoint(Point p)
  {
    Graphics2D g2 = (Graphics2D)this.getGraphics();
    if(model.getPoint() == null)
    {
      model.addPoint(p);
    }
    else
    {
    line.setLine(model.getPoint(), p);
    g2.draw(line);
    model.addPoint(p);
    }
    g2.dispose();
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    model.getFigures().forEach(f->
    {
      p0 = null;
      f.getPoints().forEach(p->{
        if(p0 != null)
        {
          line.setLine(p0, p);
          g2.draw(line);
        }
        p0 = p;      
      });
    });
  }

  @Override
  public int print(Graphics gp, PageFormat pf, int pageIndex) throws PrinterException
  {
    Graphics2D g2p = (Graphics2D)gp;
    if(pageIndex == 0)
    {
      g2p.translate(pf.getImageableX(),pf.getImageableY());
      g2p.scale(pf.getImageableWidth()/this.getWidth(),
              pf.getImageableHeight()/this.getHeight());
      super.print(g2p);
      return Printable.PAGE_EXISTS;
    }
    else
    {
      return Printable.NO_SUCH_PAGE;
    }
  }
  
  public void doPrint()
  {
    HashPrintRequestAttributeSet printSet = new HashPrintRequestAttributeSet();
    printSet.add(DialogTypeSelection.NATIVE);
    PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setPrintable(this);
    if(pj.printDialog(printSet))
    {
      try
      {
        pj.print(printSet);
      }
      catch (PrinterException ex)
      {
        JOptionPane.showMessageDialog(this, ex.toString());
      }
    }
  }
}
