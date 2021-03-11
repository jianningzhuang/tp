package seedu.duke.data;

import seedu.duke.Assignment;
import seedu.duke.Module;

import java.util.ArrayList;

public class Data {
    public ArrayList<Module> modules = new ArrayList<>();

    public Data() {
    }

    public void add(Module module) {
        modules.add(module);
    }

    public Module find(String moduleCode) {
        Module mod = null;
        for (Module m: modules) {
            if (m.getModuleCode().equals(moduleCode)) {
                mod = m;
            }
        }
        return mod;
    }
}
