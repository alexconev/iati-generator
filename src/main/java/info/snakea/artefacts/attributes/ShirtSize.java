package info.snakea.artefacts.attributes;

import info.snakea.utils.StringUtil;

public enum ShirtSize {
    XXXL("XXXL"),
    XXL("XXL"),
    XL("XL"),
    L("L"),
    M("M"),
    S("S"),
    NONE("None");

    private String label;

    ShirtSize(String s) {
        label = s;
    }

    public static ShirtSize getSize(String s) {
        for (ShirtSize ss : ShirtSize.values()) {
            if (StringUtil.containsIgnoreCase(s.trim().replace(" ", ""), ss.label)) {
                return ss;
            }
        }
        return NONE;
    }
}
