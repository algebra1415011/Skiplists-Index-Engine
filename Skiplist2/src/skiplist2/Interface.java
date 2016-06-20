/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiplist2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author algebra1415011
 */
public class Interface extends javax.swing.JFrame {
    
        Interface in;
        SkipList P;
        final static String LOOKANDFEEL = "Metal";
        final static String THEME = "Test";
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
    
     // create JTextFields
        JTextField textname = new JTextField();
        
        JTextField textFrequency = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");  
        JButton search = new JButton("Search"); 
        
        
        DefaultTableModel model;
        
        Object[] row = new Object[4];

    /**
     * Creates new form Interface
     */
    public Interface(SkipList S) {
       // initComponents();
        
        //initLookAndFeel();
        in=this;
        P=S;
        Scene scene;
        /* Frame foe the connected information**/
        
        VBox root = new VBox();
        scene = new Scene(root, 300, 250);
       
            
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"First Name","Frequency"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        //table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        //Font font = new Font("",1,22);
        //table.setFont(font);
        table.setRowHeight(30);
        
       
        table.setAutoCreateRowSorter(true);
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");  
        JButton search = new JButton("Search"); 
        JButton back = new JButton("Back"); 
        
               
        
        
        
        
        textname.setForeground(Color.BLUE);
        textFrequency.setForeground(Color.BLUE);
        textname.setBackground(Color.LIGHT_GRAY);
        textFrequency.setBackground(Color.LIGHT_GRAY);
        
        search.setBounds(20, 220, 100, 25);
        textname.setBounds(20, 265, 100, 25);
        
        textFrequency.setBounds(20, 310, 100, 25);
        
        btnAdd.setBounds(150, 220, 100, 25);
        btnUpdate.setBounds(150, 265, 100, 25);
        btnDelete.setBounds(150, 310, 100, 25);
        
        back.setBounds(80, 350, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 400);
        
        
        
         
		
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);

        // setting the title, size, location and default close operation for our JFrame
        setTitle("SkipLists");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        // using a panel with grid layout to group our four buttons
        JPanel p1 = new JPanel(new GridLayout(2, 2));

        p1.add(textname);
        p1.add(textFrequency);
        p1.add(btnDelete);
        p1.add(btnUpdate);

        // using a panel with defualt layout(flow layout) to group our three buttons
        JPanel p2 = new JPanel();
        p2.add(search);
        p2.add(btnAdd);
        p2.add(back);

        // grouping our two panes inside of another panel
        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p1, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.SOUTH);


        // adding the table to a scroll pane to make it scrollable(table is not scrollable by default)
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        // setting the selection mode to multiple interval(multiple items can be selected)
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //System.out.println("hi "+textname.getText()+" "+P.get(textname.getText()));
                if(P.get(textname.getText())!=null)
                {
                    System.out.println("duplicate");
                    SkipListEntry p= S.findEntry(textname.getText());
                    p.value=p.value+Integer.parseInt(textFrequency.getText());
                }
                else
                {
                    
                    model = new DefaultTableModel();
                    model.setColumnIdentifiers(columns);
        
                     // set the model to the table
                    table.setModel(model);
        
                    // Change A JTable Background Color, Font Size, Font Color, Row Height
                    //table.setBackground(Color.LIGHT_GRAY);
                    table.setForeground(Color.black);
                    //Font font = new Font("",1,22);
                    //table.setFont(font);
                    table.setRowHeight(30);
                    
                   
                    S.put(textname.getText(), Integer.parseInt(textFrequency.getText()));
                    //in.addName(textname.getText(),Integer.parseInt(textFrequency.getText()));
                    S.printHorizontal(in);
        
                }
                
                
                
           
               
            }
        });
        
        //back button
        
       back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 model = new DefaultTableModel();
                    model.setColumnIdentifiers(columns);
        
                     // set the model to the table
                    table.setModel(model);
        
                    // Change A JTable Background Color, Font Size, Font Color, Row Height
                    //table.setBackground(Color.LIGHT_GRAY);
                    table.setForeground(Color.black);
                    //Font font = new Font("",1,22);
                    //table.setFont(font);
                    table.setRowHeight(30);
                P.printHorizontal(in );
                back.setVisible(false);
            }
        });
        //search button
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    back.setEnabled(true);
           
                    model = new DefaultTableModel();
                    model.setColumnIdentifiers(columns);
        
                     // set the model to the table
                    table.setModel(model);
        
                    // Change A JTable Background Color, Font Size, Font Color, Row Height
                    //table.setBackground(Color.LIGHT_GRAY);
                    table.setForeground(Color.black);
                    //Font font = new Font("",1,22);
                    //table.setFont(font);
                    table.setRowHeight(30);
                    SkipListEntry p= S.findEntry(textname.getText());
                    if(P.get(textname.getText())!=null)
                        in.addName(p.key, p.value);
                    else
                        in.addName("not found",0);
                
                
            
            }
        });
        
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                int col=table.getSelectedColumn();
                if(i >= 0){
                    // remove a row from jtable
                    System.out.println(model.getValueAt(i, col).toString());
                    S.remove (model.getValueAt(i, col).toString());
                    model.removeRow(i);
                    
                   
                    
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            
            textname.setText(model.getValueAt(i, 0).toString());
            
            textFrequency.setText(model.getValueAt(i, 1).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   
                   model.setValueAt(textname.getText(), i, 0);
                
                   model.setValueAt(textFrequency.getText(), i, 1);
                   
                   SkipListEntry p= S.findEntry(textname.getText());
                   p.value=Integer.parseInt(textFrequency.getText());
                   
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        
        
        
        
        
        
        
        
        
        
    }
    
    public void addName(String Name,int frequency)
    {
                row[0] = Name;
                row[1] = frequency;
                
                // add row to the model
                model.addRow(row);
        
    }
    
    
    
    
    //set look and feel
    
    private static void initLookAndFeel() {
        String lookAndFeel = null;
       
        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("Metal")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
              //  an alternative way to set the Metal L&F is to replace the 
              // previous line with:
              // lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
                
            }
            
            else if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } 
            
            else if (LOOKANDFEEL.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } 
            
            else if (LOOKANDFEEL.equals("GTK")) { 
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } 
            
            else {
                System.err.println("Unexpected value of LOOKANDFEEL specified: "
                                   + LOOKANDFEEL);
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }

            try {
            	
            	
                UIManager.setLookAndFeel(lookAndFeel);
                
                // If L&F = "Metal", set the theme
                
                if (LOOKANDFEEL.equals("Metal")) {
                  if (THEME.equals("DefaultMetal"))
                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
                  else if (THEME.equals("Ocean"))
                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());
                  else
                     MetalLookAndFeel.setCurrentTheme(new TestTheme());
                     
                  UIManager.setLookAndFeel(new MetalLookAndFeel()); 
                }	
                	
                	
                  
                
            } 
            
            catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                                   + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                                   + lookAndFeel
                                   + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } 
            
            catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                                   + lookAndFeel
                                   + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }

    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>  
        
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
