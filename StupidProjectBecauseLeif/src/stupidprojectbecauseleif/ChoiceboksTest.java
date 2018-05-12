import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//  w w w  . j a v  a 2 s .c  o m
public class ChoiceboksTest extends Application {
  ObservableList<String> cursors = FXCollections.observableArrayList("a","b","c"); 
    @Override
    public void start(Stage stage) {
      ChoiceBox choiceBox = new ChoiceBox(cursors);
          
      //System.out.println(choiceBox.getItems());
      VBox box = new VBox();
      box.getChildren().add(choiceBox);
      final Scene scene = new Scene(box,300, 250);
      scene.setFill(null);
      stage.setScene(scene);
      stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}