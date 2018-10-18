/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift;

import java.awt.*;

/**
 *
 * @author 073787251
 */
public class Tile {
    public int x, y;
    Tile (int tx, int ty) {
        x = tx;
        y = ty;
    }
    public void display (Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 50, 50);
        System.out.println("Drawing");
    }
}
