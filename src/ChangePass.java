import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ChangePass {
    
        static boolean result;
        static Stage window,window2;
        static Scene scene1,scene2;
        static Button confirmButton,closeButton;
        static Label old,neww,numtext1,numtext2,question,error;
        static int num1,num2;
        static VBox layout1,layout2;
        static TextField oldpass = new TextField();
        static TextField newpass = new TextField();
        static TextField answer = new TextField();
        
        
    public  static void display(){
 
        //windows
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ChangePassword");
        
        
        //Generate numbers
        num1 = new Random().nextInt(98) + 1;
        num2 = new Random().nextInt(98) + 1;
        
        //Labels
        old = new Label("Old Password");
        neww = new Label("New Password");
        numtext1 = new Label(String.valueOf(num1));
        numtext2 = new Label(String.valueOf(num2));
        question = new Label("What is the sum of these numbers?");
        error = new Label();
        
        //Buttons
        confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e ->{
            try {
                result = verify(answer,oldpass,newpass);
            } catch (IOException ex) {
                Logger.getLogger(ChangePass.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(result);
            if(result){
                window.close();
            }
        });
        closeButton = new Button("Cancel");
        closeButton.setOnAction(e -> window.close());
        
        //Layout
        layout1 = new VBox(10);
        layout1.getChildren().addAll(old,oldpass,neww,newpass,numtext1,numtext2,question,answer,confirmButton,closeButton);
        layout1.setAlignment(Pos.CENTER);
        layout2 = new VBox(10);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(error);
        
        //Scenes
        scene1 = new Scene(layout1,800,600);
        scene2 = new Scene(layout2,200,200);
        
        //Stage
        window.setScene(scene1);
        
        window.showAndWait();

    }
    
    static private boolean verify(TextField sum,TextField oldpass,TextField newpass) throws IOException{
        File files = new File("mypass.txt");  
        Scanner scan = new Scanner(files);
        String pass =scan.nextLine();
        scan.close();
        window2 = new Stage();       
        window2.initModality(Modality.APPLICATION_MODAL);
        window2.setScene(scene2);
        boolean verified;
        //Verify sum
        if(sum.getText().compareTo(String.valueOf(num1 + num2))==0){
            //Verify oldpass
            if(oldpass.getText().compareTo(pass)==0){
                FileWriter writer = new FileWriter("mypass.txt");
                writer.write(newpass.getText());
                writer.close();
                sum.clear();
                oldpass.clear();
                newpass.clear();
                error.setText("Success!!");
                window2.showAndWait();
                verified = true;
            }
            else{
                error.setText("Incorrect password. Please try again.");
                window2.showAndWait();     
                verified = false;
            }
        }
        else{
            error.setText("The sum is Incorrect. Please try again.");
            window2.showAndWait();
            verified = false;
        }
        return verified;
    }
}
