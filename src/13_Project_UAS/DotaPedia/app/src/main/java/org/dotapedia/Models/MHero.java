package org.dotapedia.Models;

import java.util.List;

public class MHero {
    private List<Hero> hero;

    public MHero() {
    }

    public MHero(List<Hero> hero) {
        this.hero = hero;
    }

    public List<Hero> getHero() {
        return hero;
    }

    public void setHero(List<Hero> hero) {
        this.hero = hero;
    }
}
