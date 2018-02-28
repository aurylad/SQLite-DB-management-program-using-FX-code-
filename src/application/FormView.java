package application;

import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class FormView {
	
	
	public static AnchorPane statusPane;
	public static HBox statusBar;
	public static MenuBar menuBar;
	public static Menu menuFile;
	public static Menu menuView;
	public static MenuItem exitMenuItem;
	public static MenuItem hideFormMenuItem;
	public static 	MenuItem showFormMenuItem;
	public static 	MenuItem enableFormMenuItem;
	public static 	MenuItem disableFormMenuItem;
	public static 	TabPane tabPane;
	public static 	Tab albumTab;
	public static 	Tab employeesTab;
	public static TableView <AlbumList> tableAlbums;
	public static TableColumn columnAlbumId;
	public static TableColumn columnTitle;
	public static TableColumn columnArtistId;
	public static AnchorPane albumTabAnchor;
	public static 	VBox albumLabelsVBox;
	public static 	VBox albumTextFieldsVBox;
	public static 	HBox albumButtonsHBox;
	public static Label albumIdLabel;
	public static Label titleLabel;
	public static Label artistIdLabel;
	public static TextField txtFieldAlbumId;
	public static TextField txtFieldTitle;
	public static TextField txtFieldArtistId;
	public static Button buttonUpdate;
	public static Button buttonDelete;
	public static Button buttonAdd;
	public static Separator seperator;
	public static Label statusLabel = new Label();
	public static Label dateLabel;
	
	public static TableView <EmployeeList> tableEmployee;
	public static 	TableColumn columnEmployeeId;
	public static 	TableColumn columnLastName;
	public static 	TableColumn columnFirstName;
	public static TableColumn columnSecondTitle;
	public static 	AnchorPane employeeTabAnchor;
	public static 	VBox employeeLabelsVBox;
	public static 	VBox employeeTextFieldsVBox;
	public static 	HBox employeeButtonsHBox;
	public static 	Label employeeIdLabel;
	public static 	Label lastNameLabel;
	public static 	Label firstNameLabel;
	public static 	Label EmployeesTitleLabel;
	public static TextField txtFieldEmployeeId;
	public static TextField txtFieldLastName;
	public static TextField txtFieldFirstName;
	public static TextField txtFieldSecondTitle;
	public static Button buttonUpdateEmployees;
	public static Button buttonDeleteEmployees;
	public static Button buttonAddEmployees;
	public static Separator secondSeparator;
	
	
	public AnchorPane statusBar(){
		
		statusPane = new AnchorPane();
		{
			statusLabel = new Label();
			dateLabel = new Label();
			
    		AnchorPane.setLeftAnchor(statusLabel, 10.0);
    		AnchorPane.setBottomAnchor(statusLabel, 5.0);
    		AnchorPane.setRightAnchor(dateLabel, 10.0);
    		AnchorPane.setBottomAnchor(dateLabel, 5.0);


    		
    		statusPane.getChildren().addAll(statusLabel, dateLabel);
		}
		return statusPane;
	}
	
	public MenuBar createMenuBar(){
		
		menuBar = new MenuBar();
		{
			menuFile = new Menu("File");
			{
                exitMenuItem   = new MenuItem("Exit");
                menuFile.getItems().add(exitMenuItem);
			}
			
			menuView = new Menu("View");
			{
				hideFormMenuItem = new MenuItem("Hide From");
				showFormMenuItem = new MenuItem("Show From");
				disableFormMenuItem = new MenuItem("Make fields non editable");
				enableFormMenuItem = new MenuItem("Make fields editable");
				menuView.getItems().addAll(hideFormMenuItem, showFormMenuItem, disableFormMenuItem, enableFormMenuItem);
			}
			menuBar.getMenus().add(menuFile);
			menuBar.getMenus().add(menuView);
		}
		return menuBar;
	}
	
	
	public TabPane createTabPane(){
		
		tabPane = new TabPane();
		{
			tabPane.setSide(Side.TOP);
			
			albumTab = new Tab("Album Database");
			albumTab.setContent(createAlbumsTabAnchorPane());
	       
	        employeesTab = new Tab("Employees Database");
	        employeesTab.setContent(createEmployeesTabAnchorPane());
	        
	        tabPane.getTabs().addAll(albumTab, employeesTab);
		}
		
		return tabPane;
	}
	
	
	public AnchorPane createAlbumsTabAnchorPane(){
		
		albumTabAnchor = new AnchorPane();
		{
			tableAlbums = new TableView();
			{
				tableAlbums.setPrefWidth(349.0);
				tableAlbums.minWidth(Region.USE_COMPUTED_SIZE);
				tableAlbums.maxWidth(Region.USE_COMPUTED_SIZE);
				
				columnAlbumId = new TableColumn("AlbumId");
				columnAlbumId.setResizable(false);
				columnAlbumId.setPrefWidth( 75.0 );  
				
				columnTitle = new TableColumn("Title");
				columnTitle.setResizable(false);
				columnTitle.setPrefWidth( 160.0 );  

				columnArtistId = new TableColumn("ArtistId");
				columnArtistId.setResizable(false);
				columnArtistId.setPrefWidth( 98.0 );  
				
			    tableAlbums.getColumns().addAll(columnAlbumId, columnTitle, columnArtistId);
			}
			
			albumLabelsVBox = new VBox(35);
			{
				albumIdLabel = new Label("AlbumId");
				titleLabel = new Label("Title");
				artistIdLabel = new Label("ArtistId");
	    		
	    		albumLabelsVBox.getChildren().addAll(albumIdLabel, titleLabel, artistIdLabel);
			}
			
			albumTextFieldsVBox = new VBox(25);
			{
				 txtFieldAlbumId = new TextField();
				 txtFieldAlbumId.prefWidth(139);
				 txtFieldAlbumId.setPromptText("Selects record from a table");
				 
				 txtFieldTitle = new TextField();
				 txtFieldTitle.setPromptText("Selects record from a table");
				 
				 txtFieldArtistId = new TextField();
				 txtFieldArtistId.setPromptText("Selects record from a table");
				 
				 albumTextFieldsVBox.getChildren().addAll(txtFieldAlbumId, txtFieldTitle, txtFieldArtistId);
			}
			
			albumButtonsHBox = new HBox(40);
			{
				buttonUpdate = new Button("Update");
				buttonDelete = new Button("Delete");
				buttonAdd = new Button ("Add");
				
				albumButtonsHBox.getChildren().addAll(buttonUpdate, buttonDelete, buttonAdd);
			}
			
			seperator = new Separator();
			
			AnchorPane.setTopAnchor(tableAlbums, 15.0);
    		AnchorPane.setLeftAnchor(tableAlbums, 10.0);
    		AnchorPane.setBottomAnchor(tableAlbums, 10.0);
    		
    		AnchorPane.setTopAnchor(albumLabelsVBox, 100.0);
    		AnchorPane.setLeftAnchor(albumLabelsVBox, 380.0);
    		
    		AnchorPane.setTopAnchor(albumTextFieldsVBox, 95.0);
    		AnchorPane.setRightAnchor(albumTextFieldsVBox, 15.0);
    		AnchorPane.setLeftAnchor(albumTextFieldsVBox, 440.0);
    		
    		AnchorPane.setTopAnchor(albumButtonsHBox, 270.0);
    		AnchorPane.setLeftAnchor(albumButtonsHBox, 380.0);
    		
    		AnchorPane.setTopAnchor(seperator, 250.0);
    		AnchorPane.setLeftAnchor(seperator, 380.0);
    		AnchorPane.setRightAnchor(seperator, 15.0);
    		
    		albumTabAnchor.getChildren().addAll(tableAlbums, albumLabelsVBox, albumTextFieldsVBox, albumButtonsHBox, seperator);
		}
		return albumTabAnchor;
	}
	
	
	public AnchorPane createEmployeesTabAnchorPane(){
			
			employeeTabAnchor = new AnchorPane();
			{
				tableEmployee = new TableView();
				{
					tableEmployee.setPrefWidth(349.0);
					tableEmployee.minWidth(Region.USE_COMPUTED_SIZE);
					tableEmployee.maxWidth(Region.USE_COMPUTED_SIZE);
					
					columnEmployeeId = new TableColumn("EmployeeId");
					columnEmployeeId.setResizable(false);
					columnEmployeeId.setPrefWidth( 75.0 );  
					
					columnLastName = new TableColumn("LastName");
					columnLastName.setResizable(false);
					columnLastName.setPrefWidth( 87.0 );  
	
					columnFirstName = new TableColumn("FirstName");
					columnFirstName.setResizable(false);
					columnFirstName.setPrefWidth( 87.0 );
					
					columnSecondTitle = new TableColumn("Title");
					columnSecondTitle.setResizable(false);
					columnSecondTitle.setPrefWidth( 87.0 );
					
					tableEmployee.getColumns().addAll(columnEmployeeId, columnLastName, columnFirstName, columnSecondTitle);
				}
				
				employeeLabelsVBox = new VBox(35);
				{
					employeeIdLabel = new Label("EmployeeId");
					lastNameLabel = new Label("LastName");
					firstNameLabel = new Label("FirstName");
					EmployeesTitleLabel = new Label("Title");

					employeeLabelsVBox.getChildren().addAll(employeeIdLabel, lastNameLabel, firstNameLabel, EmployeesTitleLabel);
				}
				
				employeeTextFieldsVBox = new VBox(25);
				{
					 txtFieldEmployeeId = new TextField();
					 txtFieldEmployeeId.prefWidth(139);
					 txtFieldEmployeeId.setPromptText("Selects record from a table");
					 
					 txtFieldLastName = new TextField();
					 txtFieldLastName.setPromptText("Selects record from a table");
					 
					 txtFieldFirstName = new TextField();
					 txtFieldFirstName.setPromptText("Selects record from a table");
					 
					 txtFieldSecondTitle = new TextField();
					 txtFieldSecondTitle.setPromptText("Selects record from a table");
					 
					 employeeTextFieldsVBox.getChildren().addAll(txtFieldEmployeeId, txtFieldLastName, txtFieldFirstName, txtFieldSecondTitle);
				}
				
				employeeButtonsHBox = new HBox(40);
				{
					buttonUpdateEmployees = new Button("Update");
					buttonDeleteEmployees = new Button("Delete");
					buttonAddEmployees = new Button ("Add");
					
					employeeButtonsHBox.getChildren().addAll(buttonUpdateEmployees, buttonDeleteEmployees, buttonAddEmployees);
				}
				
				secondSeparator = new Separator();
				
				AnchorPane.setTopAnchor(tableEmployee, 15.0);
	    		AnchorPane.setLeftAnchor(tableEmployee, 10.0);
	    		AnchorPane.setBottomAnchor(tableEmployee, 10.0);
	    		
	    		AnchorPane.setTopAnchor(employeeLabelsVBox, 100.0);
	    		AnchorPane.setLeftAnchor(employeeLabelsVBox, 380.0);
	    		
	    		AnchorPane.setTopAnchor(employeeTextFieldsVBox, 95.0);
	    		AnchorPane.setRightAnchor(employeeTextFieldsVBox, 15.0);
	    		AnchorPane.setLeftAnchor(employeeTextFieldsVBox, 460.0);
	    		
	    		AnchorPane.setTopAnchor(employeeButtonsHBox, 320.0);
	    		AnchorPane.setLeftAnchor(employeeButtonsHBox, 380.0);
	    		
	    		AnchorPane.setTopAnchor(secondSeparator, 300.0);
	    		AnchorPane.setLeftAnchor(secondSeparator, 380.0);
	    		AnchorPane.setRightAnchor(secondSeparator, 15.0);
	    		
	    		employeeTabAnchor.getChildren().addAll(tableEmployee, employeeLabelsVBox, employeeTextFieldsVBox, employeeButtonsHBox, secondSeparator);
			}
			return employeeTabAnchor;
		}
}
