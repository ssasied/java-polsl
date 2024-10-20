/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

import controller.consoleController;
import model.library;
import view.consoleView;

/**
 *
 * @author stani
 */
public class Mavenproject2 {

    public static void main(String[] args) {
       
        library lib = new library();
        consoleView view = new consoleView();        
        consoleController controller = new consoleController(lib,view);
        
        controller.displayMenu();
    }
}
