package eventhandling

import scalafx.Includes._   
import mainclasses._
import scalafx.scene.control._       
import scalafx.scene.control.TextField
import scalafx.scene.control.Button
import scalafx.scene.control.ListView
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import scalafx.scene.layout.AnchorPane
import scalafx.application.Platform
import scala.collection.mutable.ArrayBuffer
import scalafx.scene.layout._

import scalafx.event.ActionEvent
import scalafx.scene.control.Label
import scalafx.scene.Parent
import scalafx.scene.layout._
import scalafx.event.ActionEvent
import javax.swing.JOptionPane;
import java.time.LocalDate
import scala.util.Random
@sfxml
class RegistrationLogin(
    var r_fname: TextField,
    var r_lname : TextField,
    var r_username : TextField,
    var r_dob : DatePicker,
    var log_username : TextField,
    var log_password : TextField,
    var r_address : TextArea,
    var r_contactnum : TextField,
    private var r_password : PasswordField,
    private var r_confirmpass : PasswordField,
    private var r_male : RadioButton,
    private var r_female : RadioButton,
    private var r_other : RadioButton,
    private var r_nation : TextField,
    private var radioGroup : ToggleGroup
    ) {

    private var gender : String = null
    var loginasuser=false
    var loginasadmin=false
    
 def openRegistrationForm(e : ActionEvent) {
  Main.roots.setCenter(Main.registrationpage)
}
    
 def createUser(e : ActionEvent) {
    if (r_male.selected.value==true) gender="M"
    if (r_female.selected.value==true) gender="F"
    if (r_other.selected.value==true) gender="Other"
   
   if (r_dob.value.value==null) JOptionPane.showMessageDialog(null, "Please enter your birthdate");
   else if (r_username.text.value=="") JOptionPane.showMessageDialog(null, "Please enter your username");
   else if (r_password.text.value=="") JOptionPane.showMessageDialog(null, "Please enter your password");
   else if (r_username.text.value=="") JOptionPane.showMessageDialog(null, "Please enter your username");
   else if (r_password.text.value!=r_confirmpass.text.value) JOptionPane.showMessageDialog(null, "Your password do not match. Please retype your password.");
   else if (r_fname.text.value=="" || r_lname.text.value=="") JOptionPane.showMessageDialog(null, "Please enter your first name and/or last name");
   else {
    Main.user += new User(r_username.text.value,r_password.text.value, r_fname.text.value, r_lname.text.value,r_address.text.value,r_contactnum.text.value,gender,r_dob.getValue().toString(),r_nation.text.value,User.counteraccno.toString(),1000,0)
    User.counteraccno=User.counteraccno+1
    Main.roots.setCenter(Main.mainpage)
     }

   }

 def login(e : ActionEvent) {
      for (u_index <- 0 until Main.user.length) {
        if (Main.user(u_index).u_uname == log_username.text.value && Main.user(u_index).u_password == log_password.text.value){
          Main.usercontroller.displayusername.text="Welcome " + log_username.text.value
          Main.loggedin=u_index
          Main.usercontroller.display_balance.text.value=Main.user(Main.loggedin).u_balance.toString()
          Main.roots.setCenter(Main.userpageroot)
          Main.enable(Main.usercontroller.balancepane)
          Main.disable(Main.usercontroller.upgradepane,Main.usercontroller.transferpane,Main.usercontroller.aboutpane,Main.usercontroller.loanpane,Main.usercontroller.personaldetailspane)
          Main.usercontroller.balance.text="Your balance is : "+ Main.user(Main.loggedin).u_balance.toString
          Main.usercontroller.display_debt.text="Your debt is : " + Main.user(Main.loggedin).debt.toString

          Main.registercontroller.loginasuser=true
          Main.generatedRandInterest=Random.nextInt(9)+1
        }
        
      }
      
      for (admin <- Main.admin) {
        if (admin.s_uname == log_username.text.value && admin.s_password==log_password.text.value){
          
          Main.roots.setCenter(Main.adminroot)
          Main.registercontroller.loginasadmin=true
        }
      }
      
      if (Main.registercontroller.loginasuser==false && Main.registercontroller.loginasadmin==false)
        JOptionPane.showMessageDialog(null, "Please recheck your usename and/or password")
    }
 
 def quitwindow(e :ActionEvent) {
      Platform.exit()
    }
}