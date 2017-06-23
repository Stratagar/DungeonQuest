/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.DungeonQuest.model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author parrdyl
 */
public class Map implements Serializable {
    
    // class instance variables
    private String description;
    private double noOfRows;
    private double noOfColumns;
    private double currentRow;
    private double currentColumn;
    private String currentScene;
    private Location[][] locations;
    
    public Map() {
    }
    public Map(int noOfRows, int noOfColumns) {
        if (noOfRows < 1 || noOfColumns < 1) {
            System.out.println("The number of rows and columns must be > zero");
            return;
        }
        
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                
                locations[row][column] = location;
            }
        }         
    }

    
    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRowCount() {
        return noOfRows;
    }

    public void setRowCount(double rowCount) {
        this.noOfRows = rowCount;
    }

    public double getColumnCount() {
        return noOfColumns;
    }

    public void setColumnCount(double columnCount) {
        this.noOfColumns = columnCount;
    }

    public double getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(double currentRow) {
        this.currentRow = currentRow;
    }

    public double getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(double currentColumn) {
        this.currentColumn = currentColumn;
    }

    public String getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

    @Override
    public String toString() {
        return "Map{" + "description=" + description + ", rowCount=" + noOfRows + ", columnCount=" + noOfColumns + ", currentRow=" + currentRow + ", currentColumn=" + currentColumn + ", currentScene=" + currentScene + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.noOfRows) ^ (Double.doubleToLongBits(this.noOfRows) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.noOfColumns) ^ (Double.doubleToLongBits(this.noOfColumns) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.currentRow) ^ (Double.doubleToLongBits(this.currentRow) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.currentColumn) ^ (Double.doubleToLongBits(this.currentColumn) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.currentScene);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (Double.doubleToLongBits(this.noOfRows) != Double.doubleToLongBits(other.noOfRows)) {
            return false;
        }
        if (Double.doubleToLongBits(this.noOfColumns) != Double.doubleToLongBits(other.noOfColumns)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentRow) != Double.doubleToLongBits(other.currentRow)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentColumn) != Double.doubleToLongBits(other.currentColumn)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.currentScene, other.currentScene)) {
            return false;
        }
        return true;
    }  
}
