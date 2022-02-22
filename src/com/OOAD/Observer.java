package com.OOAD;

public interface Observer {
    default void update(String message){};
}
