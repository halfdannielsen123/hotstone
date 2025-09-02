package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.Player;

public class StandardHero implements Hero {

    private String heroType;
    private int health;
    private int mana;

    public StandardHero(){
        this.heroType = GameConstants.BABY_HERO_TYPE;
        this.health = 21;
        this.mana = 3;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void deductMana(int manaCost) {
        mana -= manaCost;
    }

    @Override
    public int getHealth() {
        return health;
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
