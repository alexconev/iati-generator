package info.snakea.artefacts.attributes;

import info.snakea.utils.StringUtil;

public enum ShirtSize {
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    XXXL("3XL"),
    NONE("None");

    private String label;

    ShirtSize(String s) {
        label = s;
    }

    public static ShirtSize getSize(String s) {
        for (ShirtSize ss : ShirtSize.values()) {
            if (StringUtil.containsIgnoreCase(s.replace(" ", ""), ss.label)) {
                return ss;
            }
        }
        return NONE;
    }
}
