/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.DungeonQuest.view;

import byui.cit260.DungeonQuest.model.Game;
import byui.cit260.DungeonQuest.model.Inventory;
import dungeonquest.DungeonQuest;
import java.io.IOException;

/**
 *
 * @author parrdyl
 */
public class VampireDracoView extends View{
    
public VampireDracoView (){
        super( "\n"
            + "\nDraco: A human has entered my presence. Your blood i'm sure is tasty"
            + "\nDraco has a strength of 45."
            + "\nWhat would you like to do?"
            + "\n--------------------------------"
            +"\n| Combat Menu"
            + "\n--------------------------------"
            + "\nQ - Run away"
            + "\nF - Fight the Vampire"
            + "\nI - Review Your Character’s Inventory and Player Level"
            + "\nH - View the Help Menu"
            + "\n--------------------------------");
    }
    
    @Override
    public boolean doAction(String value){
        
        value = value.toUpperCase();
        
        switch (value){
            case "F": //Fight the Goblin
                this.fightMoster();
                break;

            case "I": //Review your characters's inventory and player levol
                this.displayInventory();
                break;
            case "H": //View the Help Menu
                this.displayHelpMenu();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }
    
    public void fightMoster() {
        String result;
        
        Game game = DungeonQuest.getCurrentGame();
        Inventory[] inventory = game.getInventory();
        
            int playerWEP = 0;
            int playerARM = 0;
            int playerSTR = 0;
        
            for (int i = 0; i <= 9; i++){
                inventory[i].getAmount();
                if (inventory[i].getAmount() != 0) {
//                this.console.println(inventory[i].getInventoryItem());    
                    playerWEP = inventory[i].getItemLevel();
                } 
//                    if (playerWEP < inventory[i].getItemLevel()) {
//                        playerWEP = inventory[i].getItemLevel();
//                        this.console.println(inventory[i].getItemLevel());
//                    }
//                    else {
//                        playerWEP = playerWEP;
//                    }
                }
 
            for (int i = 10; i < inventory.length; i++){
                inventory[i].getAmount();
                if (inventory[i].getAmount() != 0) {
//                    this.console.println(inventory[i].getInventoryItem());
                    playerARM = inventory[i].getItemLevel();
                }
//                    if (playerARM < inventory[i].getItemLevel()) {
//                        playerARM = inventory[i].getItemLevel();
//                        this.console.println(inventory[i].getItemLevel());
//                    }
//                    else {
//                    playerARM = playerARM;
//                    }
            }
        playerSTR = playerWEP + playerARM;
            if(playerSTR>45) 
                try{
                    this.console.println("You have beat Draco!"
                        + "But wait! Draco has dropped "
                        + "the Holy Spear. Do you want to "
                        + "pick up this powerful weapon?"
                        + "-----------------------------------"
                        + "Y - Yes "
                        + "N - No ");
                     try {    
                        result = keyboard.readLine();
                        result = result.toUpperCase();
                        switch(result){
                            case "Y":
                                this.console.println("You have picked up the "
                                    + "Holy Spear. May the Gods blesss you "
                                    + "with all their sacred might.");  
                                inventory[9].setAmount(1);
                            break;
                            case "N":
                                this.console.println("You did not pick up the "
                                    + "Holy Spear. Move on to the "
                                    + "next room.");
                        }

                    } catch (IOException ex) {
                        ErrorView.display(this.getClass().getName(),
                                        "\nYou must enter a 'Y' or an 'N'.");
                    }
                } catch (Exception e){
                    System.out.println("Error reading input: " + e.getMessage());
                }
            else
                this.console.println("You have lost! Game over"); 
    }    

    public void displayInventory() {
        InventoryView inventoryView = new InventoryView();
        inventoryView.display();
    }

    public void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }   
    
}

