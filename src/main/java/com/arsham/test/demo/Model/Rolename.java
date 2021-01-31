package com.arsham.test.demo.Model;

public enum Rolename {
    Use(1),Admin(2),Super(3);

    private final int num;

    Rolename(int num) {
        this.num=num;
    }
}
