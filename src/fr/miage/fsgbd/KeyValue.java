package fr.miage.fsgbd;

import java.util.Objects;

public class KeyValue<Type> {

    private Type key;
    private Object value;

    public KeyValue(Type key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Type getKey() {
        return key;
    }

    public void setKey(Type key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Key : " + key + " ;; value : " + value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValue keyValue = (KeyValue) o;
        return Objects.equals(key, keyValue.key);
    }

}
