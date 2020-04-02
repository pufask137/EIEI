import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestJavaFX extends Application{

    private Stage window;
    private Scene scene1, scene2;
    private Button button1;
    private Button button2;
    private boolean result;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        Label label1 = new Label("HALO MATHAR FUCKERRRRRR");
        
        button1 = new Button("Change password");
        button1.setOnAction(e -> ChangePass.display());
        
        VBox layout1;
        layout1 = new VBox(100);
        layout1.getChildren().addAll(label1, button1);
        layout1.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout1,250,200);
        
        window.setScene(scene1);
        window.setTitle("EIEIEI");
        window.show();
    }
    
    
}
