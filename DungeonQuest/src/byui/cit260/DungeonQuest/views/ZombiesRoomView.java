/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.DungeonQuest.views;

import byui.cit260.DungeonQuest.Exceptions.ZombiesControlException;
import byui.cit260.DungeonQuest.control.GameControl;
import dungeonquest.DungeonQuest;
import java.util.Scanner;
/**
 *
 * @author ZiksMS_Sophia
 */
public class ZombiesRoomView extends View {
    public ZombiesRoomView (){
        super("\n"
                + "\n---------------------------------------------------------------- "
                + "\n|  Zombies Room                                           "
                + "\n There are hungry Zombies sleeping in this room.          "
                + "\n They are all over the floor.                             "
                + "\n You must pass throuth without awake them!                "
                + "\n Watch your steps! A wrong move and you might become one of them."
                + "\n To complete this task successfully, you must enter the right "
                + "\n number of steps needed to pass the zombies in the room."
                + "\n You must cross 160ft to be safe from the zombies.  "
                + "\n Considere your height and estimate your steps to safety."
                + "\n A step shorter, and you'll be trapped between them."
                + "\n A step longer, and you'll hit the pile of old can and awake them."
                + "\n                                                          "
                + "\n You must enter the number of steps now:                 "
            );
    }
    
    @Override
    public boolean doAction(String value){
//Individual Assignment L:11, by Dylan
        int steps = 0;
        try{
            steps = Integer.parseInt(value);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),
                    "\nYou must enter a valid number.");
          return false;
        }

 //Individual Assignment L:11, by Sophia.
         try {
        if (GameControl.zombiesRoom(steps)){
            this.console.println("Congratulations, you are at safe zone");
            return true;
        }
     
        } catch (ZombiesControlException te) {
            ErrorView.display(this.getClass().getName(),
                    te.getMessage());
        }
        return false;
    }
 }

       
    

