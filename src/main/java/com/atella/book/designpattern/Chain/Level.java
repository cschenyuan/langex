package com.atella.book.designpattern.Chain;

/**
 * Created by chenyuan on 2017/4/24.
 */
public class Level {

    private int level;

    public Level(int level) {
        this.level = level;
    }

    public boolean equals(Level other) {
        return this.level == other.level;
    }

}
