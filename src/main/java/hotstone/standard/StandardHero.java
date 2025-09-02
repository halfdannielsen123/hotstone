package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.Player;

public class StandardHero implements Hero {

    private String heroType;

    public StandardHero(){
        this.heroType = GameConstants.BABY_HERO_TYPE;
    }

    @Override
    public int getMana() {
        return 0;
    }

    @Override
    public int getHealth() {
        return 21;
    }

    @Override
    public boolean canUsePower() {
        return false;
    }

    @Override
    public String getType() {
        return GameConstants.BABY_HERO_TYPE;
    }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getEffectDescription() {
        return GameConstants.BABY_HERO_EFFECT_DESCRIPTION;
    }
}
