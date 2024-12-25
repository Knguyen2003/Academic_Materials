package entity;

import java.io.Serializable;

public enum Status implements Serializable {
    AVAILABLE, IN_USE, UNDER_MAINTENANCE, BROKEN
}
