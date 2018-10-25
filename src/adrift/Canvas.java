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
public class Canvas extends javax.swing.JPanel {
    static Point2D charPoint = new Point2D.Double(375,375);
    boolean collided = true;
    boolean keepGoing = true;

    /**
     * Creates new form Canvas
     */
    public Canvas() {
        initComponents();
    }

    public void drawBoard(Graphics g) {
        for (Tile t : MainFrame.board) {
            t.display(g);
        }
    }

    public void drawSquare(Graphics g) {//By doing this, we make sure you can't see the white lines
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rectBoard = new Rectangle2D.Double(MainFrame.board.get(0).x,MainFrame.board.get(0).y,100,100);
        AffineTransform transform = new AffineTransform();
        AffineTransform old = g2d.getTransform();
        transform.rotate(Math.toRadians(Tile.rotScale), charPoint.getX(), charPoint.getY());
        Shape rbRotated = transform.createTransformedShape(rectBoard);
        checkSquareCollision(rbRotated, charPoint);
        g2d.transform(transform);
        g.setColor(Color.gray);
        g.fillRect((int)(MainFrame.board.get(0).x), (int)(MainFrame.board.get(0).y), 500, 500);
        g2d.setTransform(old);
    }
    
    public void checkSquareCollision(Shape currentBoard, Point2D charPoint) {
        collided = (rotatePoint(charPoint).getX() <= Tile.centerX + MainFrame.board.get(0).x - 375 + 500 && rotatePoint(charPoint).getX() >= MainFrame.board.get(0).x && rotatePoint(charPoint).getY() <= MainFrame.board.get(0).y + 500 && rotatePoint(charPoint).getY() >= MainFrame.board.get(0).y);
    }

    public static Point2D rotatePoint(Point2D oldPoint) {
        double newpX = 375 + (oldPoint.getX()-375)*Math.cos(-Tile.rotScale) - (oldPoint.getY()-375)*Math.sin(-Tile.rotScale);
        double newpY = 375 + (oldPoint.getX()-375)*Math.sin(-Tile.rotScale) - (oldPoint.getY()-375)*Math.cos(-Tile.rotScale);
        return new Point2D.Double(newpX, newpY);
    }
    public void drawChar(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(370, 370, 10, 10);
    }

    @Override
    public void paintComponent(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        drawSquare(g);
        drawBoard(g);
        drawChar(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
