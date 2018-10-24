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
        g.fillRect((int)(centerX+x-375), (int)(centerY+y-375), 100, 100);
        g.setColor(Color.red);
        g.fillOval(centerX, centerY, 5, 5);
        g2d.setTransform(old);
        g.setColor(Color.red);
        g.fillOval(375, 375, 5, 5);
    }
}
