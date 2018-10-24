/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author 073787251
 */
public class Tile {
    public double x, y;
    static int rotScale = 0;
    static int centerX = 375;
    static int centerY = 375;
    Tile (double tx, double ty) {
        x = tx;
        y = ty;
    }
    public void display (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = new AffineTransform();
        AffineTransform old = g2d.getTransform();
        transform.rotate(Math.toRadians(rotScale),Canvas.charPoint.getX(),Canvas.charPoint.getY());
        g2d.transform(transform);
        g.setColor(Color.gray);
        g.fillRect((int)(x), (int)(y), 100, 100);
        g.setColor(Color.red);
        Point2D rotCenterPoint = new Point2D.Double(centerX,centerY);
        g.fillOval(centerX, centerY, 5, 5);
        g2d.setTransform(old);
        g.setColor(Color.red);
        Point2D realCenterPoint = new Point2D.Double(375,375);
        g.drawLine((int)rot_point(375,375,rotCenterPoint,rotScale%360).getX(),(int)rot_point(375,375,rotCenterPoint,rotScale%360).getY(),(int)Canvas.rotatePoint(realCenterPoint).getX(),(int)Canvas.rotatePoint(realCenterPoint).getY());
        g.fillOval(375, 375, 5, 5);
    }
    public static Point2D rot_point (float cx, float cy, Point2D oldPoint, double angle) {
        double s = Math.sin(Math.toRadians(angle));
        double c = Math.cos(Math.toRadians(angle));
        double xnew = (oldPoint.getX()-cx)*c - (oldPoint.getY()-cy)*s;
        double ynew = (oldPoint.getX()-cx)*s + (oldPoint.getY()-cy)*c;
        return new Point2D.Double(xnew + cx,ynew + cy);
        
    }
}
