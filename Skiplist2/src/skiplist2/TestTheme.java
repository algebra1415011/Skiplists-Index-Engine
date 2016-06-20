/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiplist2;

/**
 *
 * @author algebra1415011
 */

import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
 
public class TestTheme extends DefaultMetalTheme {
 
    public String getName() { return "Toms"; }
 
    private final ColorUIResource primary1 = new ColorUIResource(100, 255, 0);
    private final ColorUIResource primary2 = new ColorUIResource(100, 220, 255);
    private final ColorUIResource primary3 = new ColorUIResource(205, 0, 255);
 
    protected ColorUIResource getPrimary1() { return primary1; }
    protected ColorUIResource getPrimary2() { return primary2; }
    protected ColorUIResource getPrimary3() { return primary3; }
 
}