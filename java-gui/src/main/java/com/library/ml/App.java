package com.library.ml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import model.library;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static library lib = new library();
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(p -> {
        switch (fxml) {
            case "viewAddUser":
                return new ViewAddUserController(lib); 
            case "viewAddAdmin":
                return new ViewAddAdminController(lib); 
            case "viewDisplayUser":
                return new ViewDisplayUserController(lib); 
            case "viewDisplayAdmins":
                return new ViewDisplayAdminsController(lib); 
            case "viewAddAlbum":
                return new ViewAddAlbumController(lib);
            case "mainMenu":
            default:
                return new MainMenuController(lib); // Default to MainMenuController
                
        
        
        }
    });
        //fxmlLoader.setControllerFactory( p -> { return new MainMenuController(lib);} );   
        //fxmlLoader.setControllerFactory( p -> { return new DisplayUsersController(lib);} );   
        //fxmlLoader.setControllerFactory( p -> { return new ViewAddUserController(lib);} );   
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        
    }

}