/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafikchat.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Christian
 */
public class Figur implements Serializable
{
  private ArrayList<Point> points;
  private Point lastPoint;
  
  public Figur()
  {
    points = new ArrayList<>();
    //lastPoint = new Point();
    lastPoint = null;
  }
    
  public void addPoint(Point p)
  {
    points.add(p);
    lastPoint = p;
  }
  
  public List<Point> getPoints()
  {
    return Collections.unmodifiableList(points);
  }
  
  public Point getlP()
  {
    return lastPoint;
  }
  
  public void setlP(Point p)
  {
    lastPoint = p;
  }
}
