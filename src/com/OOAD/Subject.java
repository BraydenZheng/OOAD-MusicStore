package com.OOAD;

//Subject of Observer design pattern
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver(String message);
}
