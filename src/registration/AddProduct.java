 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;
import static confegurator.NewClass.conUrl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class AddProduct {
  frame f = new frame();
   public int ap(String rq, int wq, double vr) {
      int r = 0;
      
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(conUrl);
           String query = "insert into addproduct values"
                   + "(null,?,?,?)";
           PreparedStatement p = con.prepareStatement(query);
           p.setString(1,rq);
           p.setInt(2, wq);
           p.setDouble(3, vr);
      r =  p.executeUpdate();
           
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
       }
       
      return r;
  }
   public void dproduct(String id){
     try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection c = DriverManager.getConnection(conUrl);
         String q ="Delete from addproduct where Id = ?";
         PreparedStatement p = c.prepareStatement(q);
         p.setString(1, id);
         p.executeUpdate();
         JOptionPane.showMessageDialog(f, "Successfully Deleted","Successfull", JOptionPane.INFORMATION_MESSAGE); 
         
     } catch (ClassNotFoundException ex) {
           Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
       }
        
   }

    void protable(String sid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

