package info.snakea.artefacts.attributes;

import info.snakea.utils.StringUtil;

public enum OS {
    WINDOWS("Windows"),
    LINUX("Linux"),
    NONE("None"),
    EMPTY("Empty");

    private String label;

    OS(String s) {
        label = s;
    }

    public static OS getOS(String s) {
        if (s.replace(" ", "").isEmpty()) {
            return EMPTY;
        }

        for (OS os : OS.values()) {
            if (StringUtil.containsIgnoreCase(s.replace(" ", ""), os.label)) {
                return os;
            }
        }

        return NONE;
    }
}
