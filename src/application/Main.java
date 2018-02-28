package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,700,650);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			FormView formView = new FormView();
			root.setTop(formView.createMenuBar());
			root.setCenter(formView.createTabPane());
			root.setBottom(formView.statusBar());
			
			FormController formController = new FormController();
			formController.setCellsAlbumTable();
			formController.loadDataFromDatabaseAlbums();
			formController.setValueToAlbumTextFields();
			
			formController.setCellsEmployeeTable();
			formController.loadDataFromDatabaseEmployees();
			formController.setValueToEmployeesTextFields();
			formController.onAction();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
