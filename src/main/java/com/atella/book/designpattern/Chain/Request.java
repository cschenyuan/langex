package com.atella.book.designpattern.Chain;

/**
 * Created by chenyuan on 2017/4/24.
 */
public class Request {

    private Level currentLevel;

    public Request(Level level) {
        this.currentLevel = level;
    }

    public Request() {
        this.currentLevel = new Level(0);
    }

    public Level getLevel() {
        return this.currentLevel;
    }

}
