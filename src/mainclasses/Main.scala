package mainclasses

import scalafx.Includes._       
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.BorderPane
import scalafx.scene.control.Label
import scalafx.geometry.Insets
import scalafx.application.JFXApp  
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import address.util.ResourceLoading._
import scala.collection.mutable.ArrayBuffer
import eventhandling._
import scalafxml.core.{NoDependencyResolver, FXMLLoader}
import javafx.scene.{control => jfxsc}
import javafx.scene.{layout => jfxsl}
import javafx.{event => jfxe}
import javafx.{fxml => jfxf}
import javafx.{fxml => jfxf}
import javafx.{scene => jfxs}
import javafx.scene.control.SplitPane
import mainclasses.view
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.layout.AnchorPane
import scala.collection.mutable.Map

object Main extends JFXApp{


    val userloader="view/userpage.fxml".loadFXML();    
 val usercontroller=userloader.getController[eventhandling.UserEventController#Controller]()
 val userpageroot=userloader.getRoot[javafx.scene.layout.AnchorPane]


 var resource = getClass.getResource("view/adminpage.fxml")
  val adminloader = new jfxf.FXMLLoader(resource)
  val adminpage = adminloader.load[jfxs.Parent]
  val admincontroller = adminloader.getController[AdminEventController]
 val adminroot= adminloader.getRoot[javafx.scene.layout.AnchorPane]
  
 val rootlayout="view/RootLayout.fxml".loadFXML();
 val roots = rootlayout.getRoot[javafx.scene.layout.BorderPane]
 
 val mainlayout = "view/mainpage.fxml".loadFXML(); 
 val mainpage=mainlayout.getRoot[javafx.scene.layout.AnchorPane]
 roots.setCenter(mainpage)
 
 val registrationpagelayout="view/registrationform.fxml".loadFXML();
 val registrationpage=registrationpagelayout.getRoot[javafx.scene.layout.AnchorPane]
 val registercontroler=registrationpagelayout.getController[eventhandling.RegistrationLogin#Controller]
 



  var user = ArrayBuffer[User]()
  var admin= ArrayBuffer[Admin]()
    
  def enable(node:Node*) {
     node.foreach(_.visible =true)
  }
   def disable(node:Node*) {
     node.foreach(_.visible =false)
  }
  
 
 /*def findById(id: Int): Option[User] = maps.get(id)
   def te(x: String) {

      println(Main.findById(x.toInt).flatMap(_.u_accno))
      show(Main.findById(x.toInt).flatMap(_.u_accno))
   }*/
   def show(x : Option[String])= x match{
     case Some(s) =>  {
       //for (y <- 0 to user.length-1) if (s==user(y).u_accno)return s
      // return "No account found"
       println("ye")
     }
     case None => println("sd")
   }
   
  user += new User("a",null,null,"23",null,null,null,"sadad",null,"1",1000)
  //def findById(id: Int): Option[User] = user.get(id)

  var counteraccno=2;
  var countertransaction=1;
  var loggedin : Integer = 1;
  //var maps=Map[Int,User]()
 // maps += (1->new User("a",null,null,"23",null,null,null,"sadad",null,"1"))
 // maps += (2->new User("SD",null,null,"23",null,null,null,"sadad",null,"2"))
 
  // Main.user += new User("a","","","","")
 Main.admin+=new Admin("b","","","")
  stage = new PrimaryStage(){
    scene=new Scene(600,450) {
      root=roots
    }
    
  }
}