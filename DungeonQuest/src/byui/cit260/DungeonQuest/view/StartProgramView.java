/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.DungeonQuest.view;

import byui.cit260.DungeonQuest.control.GameControl;
import byui.cit260.DungeonQuest.model.Player;
import java.util.Scanner;

/**
 *
 * @author parrdyl
 */
public class StartProgramView extends View{
   
//    private String promptMessage;
//    
//    public StartProgramView() {
//        
//        this.promptMessage= "\nPlease enter your name: ";
//        this.displayBanner();
//        
//    }

    private void displayBanner() {
       
        System.out.println(
                "\n*******************************************"
                +"\n*                                        *"
                +"\n* Welcome! Will you be able to survive   *"
                +"\n* the dungeon?                           *"
                +"\n******************************************"
        );
        
    }

    @Override
    public boolean doAction(String playersName) {
        
        if (playersName.length() < 2){
            System.out.println("\nInvalid players name:"
                       + "The name must be greater than one character in length");
            return false;
        }
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) {
            System.out.println("\nError creating the player.");
            return false;
        }
        
        this.displayNextView(player);
        return true;
    }
    private void displayNextView(Player player) {
        System.out.println("\n======================================="
                            + "\n Welcome to the game " + player.getName()
                            + "\n We hope you have a lot of fun!"                   
                            + "\n===================================="
                            );
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();             
    }
}
    
