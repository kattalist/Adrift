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
    public int x, y;
    public int rotX, rotY;
    static int rotScale = 0;
    static int centerX = 375;
    static int centerY = 375;
    Tile (int tx, int ty) {
        x = tx;
        y = ty;
    }
    public void display (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = new AffineTransform();
        AffineTransform old = g2d.getTransform();
        transform.rotate(Math.toRadians(rotScale),centerX,centerY);
        Point2D charPoint = new Point2D.Double(375,375);
        g2d.transform(transform);
        g.setColor(Color.gray);
        g.fillRect(x, y, 100, 100);
        g2d.setTransform(old);
    }
}
