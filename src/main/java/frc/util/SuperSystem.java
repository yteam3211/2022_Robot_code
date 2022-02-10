package frc.util;

import java.util.HashMap;
import frc.util.dashboard.SuperSubSystemTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Matan Steinmetz
 */
public class SuperSystem extends SubsystemBase {
    private String nameSystem;
    private final SuperSubSystemTab tab;
    private static HashMap<String, SuperSubSystemTab> allTabs = new HashMap<>();

    public SuperSystem(String nameSystem) {
        this.nameSystem = nameSystem;
        if (!allTabs.containsKey(nameSystem))
            allTabs.put(nameSystem, new SuperSubSystemTab(nameSystem, this));
        tab = allTabs.get(nameSystem);
    }

    public SuperSubSystemTab getTab() {
        return tab;
    }

    public String getNameSystem() {
        return nameSystem;
    }

}
