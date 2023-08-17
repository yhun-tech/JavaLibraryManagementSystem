
package My_Classes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jhung
 */
public class Function_Class {
    
    
      //create function to display image in jlabel>
    public void displayImage(int width, int height,String imagePath,JLabel label){
    ImageIcon imgIcon = new ImageIcon(getClass().getResource("/My_Images/HeirarchalStructures Black.png"));
    
  
    
    //make the image fit the jLabel>
    Image image = imgIcon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
    
    // set the image into the jLabel>
    
   label.setIcon(new ImageIcon(image));
    }
    
    public void displayAuthorImage(int width,int height,String ImagePath,JLabel label){
    ImageIcon AuthorimgIcon = new ImageIcon(getClass().getResource("/My_Images/AuthorImage.jpg"));
    
    }
    
}
