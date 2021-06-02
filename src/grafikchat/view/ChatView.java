/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafikchat.view;

/**
 *
 * @author Christian
 */
public class ChatView extends javax.swing.JFrame
{

  /**
   * @return the TfIP
   */
  public javax.swing.JTextField getTfIP()
  {
    return TfIP;
  }

  /**
   * @return the SelectSC
   */
  public javax.swing.JComboBox<String> getSelectSC()
  {
    return SelectSC;
  }

  /**
   * @return the BtnConnect
   */
  public javax.swing.JToggleButton getBtnConnect()
  {
    return BtnConnect;
  }

  /**
   * @return the TfAdress
   */
  public javax.swing.JTextField getTfAdress()
  {
    return TfIP;
  }

  /**
   * Creates new form NewJFrame
   */
  public ChatView()
  {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    North = new javax.swing.JPanel();
    SelectSC = new javax.swing.JComboBox<>();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel1 = new javax.swing.JLabel();
    TfIP = new javax.swing.JTextField();
    jSeparator2 = new javax.swing.JSeparator();
    BtnConnect = new javax.swing.JToggleButton();
    view1 = new grafikchat.view.View();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Grafik-Chat");

    SelectSC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Server", "Client" }));
    North.add(SelectSC);
    North.add(jSeparator1);

    jLabel1.setText("IP:");
    North.add(jLabel1);

    TfIP.setColumns(15);
    TfIP.setText("127.0.0.1");
    TfIP.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        TfIPActionPerformed(evt);
      }
    });
    North.add(TfIP);
    North.add(jSeparator2);

    BtnConnect.setText("Connect");
    North.add(BtnConnect);

    getContentPane().add(North, java.awt.BorderLayout.NORTH);

    view1.setToolTipText("");
    getContentPane().add(view1, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void TfIPActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TfIPActionPerformed
  {//GEN-HEADEREND:event_TfIPActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_TfIPActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new ChatView().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JToggleButton BtnConnect;
  private javax.swing.JPanel North;
  private javax.swing.JComboBox<String> SelectSC;
  private javax.swing.JTextField TfIP;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private grafikchat.view.View view1;
  // End of variables declaration//GEN-END:variables

  /**
   * @return the view1
   */
  public grafikchat.view.View getView1()
  {
    return view1;
  }
}