package com.example.myPackage;

public class SharedResource {
    private Worker owner;

    public SharedResource(final Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(final Worker owner) {
        this.owner = owner;
    }
}
