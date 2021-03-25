import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


/**
* Program that creates a cafe review page.
* @author Jordan Collins
* @version 1.0
*/
public class CafeReviewPage extends Application {
    private TextField name = new TextField();
    private TextField feedback = new TextField();
    private TextField color = new TextField();
    private GridPane gridPane = new GridPane();
    private int count = 1;

    /** A main method to test our code.
    * @param args the arguments passed in the command line.
    */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        Button postButton = new Button("Post Review");
        postButton.setOnAction(e -> postReview());
        Image image = new Image("javalogo.png", 0, 291.5, true, true, true);
        ImageView imageView = new ImageView(image);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(new Label("Name: "), name);
        hbox.getChildren().addAll(new Label("Feedback: "), feedback);
        hbox.getChildren().addAll(new Label("Color: "), color);
        hbox.getChildren().add(postButton);
        hbox.setStyle("-fx-background-color: burlywood");
        pane.setBottom(hbox);
        Label reviewHeader = new Label("Cafe1331 Reviews");
        reviewHeader.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        gridPane.add(reviewHeader, 0, 0);
        gridPane.setStyle("-fx-background-color: floralwhite");
        pane.setTop(gridPane);
        pane.setCenter(imageView);
        Scene scene = new Scene(pane, 725, 500);
        stage.setTitle("Cafe1331 Reviews");
        stage.setScene(scene);
        stage.show();
    }

    private void postReview() {
        String reviewerName;
        String reviewerFeedback = feedback.getText();
        Color textColor;
        try {
            textColor = Color.web(color.getText());
        } catch (Exception e) {
            textColor = Color.web("black");
        }
        if (name.getText().isEmpty()) {
            reviewerName = "Anonymous";
        } else {
            reviewerName = name.getText();
        }
        if (!(feedback.getText().isEmpty())) {
            Label review = new Label(reviewerName + ": " + reviewerFeedback);
            review.setTextFill(textColor);
            gridPane.add(review, 0, count);
            count++;
            name.setText("");
            feedback.setText("");
            color.setText("");
        } else {
            name.setText("");
            feedback.setText("");
            color.setText("");
        }
    }
}


