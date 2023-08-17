
package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Author {
    
    private int id;
    private String firstname;
    private String LastName;
    private String Field_of_Expertise;
    private String about;
    
    
    public Author(){}
     
    public Author(int _id,String _Fname,String _Lname,String _Expertise,String _About)
    {
    
        this.id = _id;
        this.firstname = _Fname;
        this.LastName = _Lname;
        this.Field_of_Expertise = _Expertise;
        this.about = _About;
        
    }
    

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setField_of_Expertise(String Field_of_Expertise) {
        this.Field_of_Expertise = Field_of_Expertise;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public String getField_of_Expertise() {
        return Field_of_Expertise;
    }

    public String getAbout() {
        return about;
    }
    
     
    //insert a new author page function
    public void addAuthor(String _Fname,String _Lname,String _Expertise,String _About)
    {
      String insertQuery = "INSERT INTO `author`(`firstname`, `lastname`, `expertise`, `about`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
           
               ps.setString(1, _Fname);
               ps.setString(2, _Lname);
               ps.setString(3, _Expertise);
               ps.setString(4, _About);
                        
                        
            
            if(ps.executeUpdate() !=0)
                
            {
            JOptionPane.showMessageDialog(null, "Author Added","Add Author",1);
            }else{
                
            JOptionPane.showMessageDialog(null, "Author Not Added","Add Author",2);   
           
        }
       
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      //edit author by id function
    public void editAuthor(int _id,String _Fname,String _Lname,String _Expertise,String _About) {
   String editQuery = "UPDATE `author` SET `firstname`=?, `lastname`=?, `expertise`=?, `about`=? WHERE `id` = ?";
    try {
        PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
        
        ps.setString(1,_Fname);
          ps.setString(2, _Lname);
            ps.setString(3,  _Expertise);
               ps.setString(4, _About);
                 ps.setInt(5,_id);
        
        
        
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Author Edited", "Edit Author", 1);
        } else {
           JOptionPane.showMessageDialog(null, "Author Not Edited", "Edit Author", 1);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    
       //remove genre by id function
    public void removeAuthor(int _id)
    {
       String removeQuery = "DELETE FROM `author` WHERE `id` = ?";
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeQuery);
            
            ps.setInt(1,_id);
         
            
            if(ps.executeUpdate() !=0)
                
            {
            JOptionPane.showMessageDialog(null, "Author Deleted","remove",1);
            }else{
            JOptionPane.showMessageDialog(null, "Author Not Deleted","remove",1);
            
        }
       
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    }
     
    
      //function to populate an arrayList with authors
    public ArrayList<Author> authorList(){
        
        ArrayList<Author> aList = new ArrayList<>();
        
        String selectQuery = "SELECT * FROM `author`";
        PreparedStatement ps;
        ResultSet rs;
        
        
        try {
            
            ps = DB.getConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
           
            Author author;
            
            while(rs.next()){ 
                
                //firstname`, `lastname`, `expertise`, `about
            author = new Author(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname" ),rs.getString("expertise" ),rs.getString("about" ));
            
            aList.add(author);
                    
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aList;
        
    
    }

}
