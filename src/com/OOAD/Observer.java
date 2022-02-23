package com.OOAD;

import java.util.ArrayList;

public interface Observer {
    default void update(String message){};
    default void updateTracker(ArrayList<Clerk> clerks){};
}
