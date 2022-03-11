package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Debug {
    public void debug(String name) {
        NetworkTable table = NetworkTableInstance.getDefault().getTable(name);
    }
    

    void PutString(String key, String value) {
        NetworkTableEntry stringEntry = this.table.getEntry(key);
        stringEntry.setString(value);
    }

    void PutNumber(String key, Double value) {
        NetworkTableEntry numberEntry = this.table.getEntry(key);
        numberEntry.setNumber(value);
    }

    void PutBoolean(String key, Boolean value) {
        NetworkTableEntry booleanEntry = this.table.getEntry(key);
        booleanEntry.setBoolean(value);
    }

    void GetNumber(String key, Double defaultValue) {
        this.table.getEntry(key);
    }

    NetworkTable table;
    
}
