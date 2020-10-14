package org.logSpin;

public class Info {
    private String name;
    private String key;
    private String description;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    private Info(String name, String key, String description) {
        this.name = name;
        this.key = key;
        this.description = description;
    }

    public void name(String name) {
        this.name = name;
    }

    public void key(String key) {
        this.key = key;
    }

    public void description(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String key = "DefaultKey";
        private String description = "DefaultDescription";

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Info build() {
            return new Info(name, key, description);
        }
    }
}
