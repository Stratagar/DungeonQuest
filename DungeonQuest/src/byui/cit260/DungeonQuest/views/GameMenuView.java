/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.DungeonQuest.views;

import byui.cit260.DungeonQuest.control.MapControl;
import byui.cit260.DungeonQuest.model.Game;
import byui.cit260.DungeonQuest.model.Inventory;
import byui.cit260.DungeonQuest.model.Location;
import byui.cit260.DungeonQuest.model.Map;
import dungeonquest.DungeonQuest;
import java.util.Scanner;

/**
 *
 * @author ZiksMS_Sophia
 */
public class GameMenuView extends View{
//    private final String menu;
//    private String promptMessage;
    
    
    public GameMenuView (){
        super( "\n"
            + "\n--------------------------------"
            +"\n| Game Menu"
            + "\n--------------------------------"
//            + "\nS - Find the Item with the greatest strength"
//            + "\nI - Review Your Character’s Inventory and Player Level"
            + "\nM - Go to map menu"
            + "\nN - View Inventory Menu"
            + "\nH - View the Help Menu"
            + "\nR - Reports and stats of game"
            + "\nQ - Quit to Main Menu"
                
            + "\n--------------------------------");
    }
    
    @Override
    public boolean doAction(String value){
        
        value = value.toUpperCase();
        
        switch (value){
            
//            case "S"://Display the inventory item with the greatest strength
//                this.displayInventoryStrength();
//                break;
//            case "I": //Review your characters's inventory and player levol
//                this.displayInventory();
//                break;
            case "M":  
                this.displayMapMenu();
                break;  
            case "N": //View the Inventory Menu
                this.InventoryView();
                break;
            case "H": //View the Help Menu
                this.displayHelpMenu();
                break;
            case "R": //Prompt to Menu with List of Actors and Descriptions
                this.displayReports();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }
    
    public void displayMapMenu() {
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.display();
    } 

    public void displayHelpMenu() {
        HelpMenuView helpView = new HelpMenuView();
        helpView.display();
    }

//    private void displayInventoryStrength() {
//       InventoryStrengthView StrengthView = new InventoryStrengthView();
//       StrengthView.display();
//    }

    private void InventoryView() {
        InventoryView inventoryView = new InventoryView();
        inventoryView.display();
    }        

    private void displayReports() {
        PrintReportsView reportsView = new PrintReportsView();
        reportsView.display();
    }
}
