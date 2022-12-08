
package visao;

import com.raven.component.Menu;
import controle.EventMenuSelected;
import controle.EventShowPopupMenu;
import controle.MenuItem;
import controle.PopupMenu1;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import visao.form.Form_Agenda;
import visao.form.Form_Ensino;
import visao.form.Form_Finança;
import visao.form.Form_Grupo;
import visao.form.Form_Aniver;
import visao.form.Form_Ata;
import visao.form.Form_Email;
import visao.form.Form_Home;
import visao.form.Form_Info;
import visao.form.Form_Membros;
import visao.form.Form_Pesquisa_Membros;
import visao.form.Form_Pesquisa_Visitante;

import visao.form.Form_Visitante;

public class TelaPrincipal extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    public MainForm main;
    private Animator animator;

    public TelaPrincipal() throws SQLException, ParseException {
        initComponents();
        init();
        
        
    }

    private void init() throws SQLException, ParseException {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            
            
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                
                // Form Home:
                
              /*  if (menuIndex == 0) {
                    
                    try {
                        main.showForm(new Form_Home());
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }*/
                
                // Secretaria:
                 
                if (menuIndex != 0) {}
                else if (subMenuIndex == 0){
                    
                    try {
                        main.showForm(new Form_Membros());
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                
                else if (subMenuIndex == 1) {
                    
                main.showForm(new Form_Visitante());   
                } 
                
                // Form_Pesquisa_Membros:
                
                if (menuIndex != 1) {}
                
                else if (subMenuIndex == 0) {
                    
                    try {            
                        main.showForm(new Form_Pesquisa_Membros());
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                } 
                else if (subMenuIndex == 1) {
                    
                    try {            
                        main.showForm(new Form_Pesquisa_Visitante());
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                } 
                
                else if (subMenuIndex == 2) {
                    
                    try {
                        main.showForm(new Form_Info());
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                } 
                
                // Form_Grupo:
                
                if (menuIndex == 2) { try {
                    
                    main.showForm(new Form_Grupo());
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                
                // Form_Aniversario:
                
                if (menuIndex == 3) { try {
                    
                    main.showForm(new Form_Aniver());
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
              
                
                // Form_Agenda:
                
                if (menuIndex == 4) { try {
                    
                    main.showForm(new Form_Agenda());
                    } catch (SQLException ex) {
                        
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                
                // Form_Email:
                
               /* if (menuIndex == 5) { main.showForm(new Form_Email());
                
                    }*/
                
                // Form_Ensino:
                
                if (menuIndex == 5) { try {
                    
                    main.showForm(new Form_Ensino());
                    
                    } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                
                
                // Form_Finança:
                
                if (menuIndex == 6) { try {
                    main.showForm(new Form_Finança());
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                
                // Form_Ata:
                
                if (menuIndex == 7) { try {
                    main.showForm(new Form_Ata());
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
             }
           
        });
        
        menu.addEventShowPopup(new EventShowPopupMenu() {
            
            @Override
            
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu1 popup = new PopupMenu1(TelaPrincipal.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = TelaPrincipal.this.getX() + 52;
                int y = TelaPrincipal.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        
        TimingTarget target = new TimingTargetAdapter() {
            
            @Override
            
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            
            public void end() {
                
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            
            @Override
            
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
      
        //  Start with this form
        main.showForm(new Form_Membros());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1039, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        setSize(new java.awt.Dimension(1055, 694));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TelaPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
