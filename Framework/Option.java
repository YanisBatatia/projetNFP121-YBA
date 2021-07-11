package Framework;

public class Option {
    private char access;
    private String description;
    private boolean needValue;

    public Option(char access, String description, boolean needValue) {
        this.access = access;
        this.description = description;
        this.needValue = needValue;
    }

    public char getAccess() {
        return access;
    }

    public void setAccess(char access) {
        this.access = access;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNeedValue() {
        return needValue;
    }

    public void setNeedValue(boolean needValue) {
        this.needValue = needValue;
    }

    @Override
    public String toString() {
        return "Option{" +
                "access=" + access +
                ", description='" + description + '\'' +
                ", needValue=" + needValue +
                '}';
    }
}
