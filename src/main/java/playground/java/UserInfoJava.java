package playground.java;

import java.util.UUID;

public class UserInfoJava {

    private final String uuid;

    private final String name;

    private final Boolean hasAccess;

    private final Boolean isAdmin;

    private final String notes;

    public UserInfoJava(String uuid, String name, Boolean hasAccess, Boolean isAdmin, String notes) {
        this.uuid = uuid;
        this.name = name;
        this.hasAccess = hasAccess;
        this.isAdmin = isAdmin;
        this.notes = notes;
    }

    public UserInfoJava(String uuid, String name) {
        this(uuid, name, true, false, "");
    }

    public UserInfoJava(String name, Boolean hasAccess) {
        this(UUID.randomUUID().toString(), name, hasAccess, false, "");
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Boolean getHasAccess() {
        return hasAccess;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public String getNotes() {
        return notes;
    }
}
