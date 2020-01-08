package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroesTest {
    //heroes helper method
    public Heroes setUpHero(){
        return new Heroes("omosh",23,"flying","dopeness");
    }


    @Test
    public void getName_savesHeroNameSuccessful_String() {
        Heroes testHeroName = setUpHero();
        assertEquals("omosh", testHeroName.getName());

    }

    @Test
    public void getAge_savesHeroAgeSuccessful_int() {
        Heroes testHeroAge= setUpHero();
        assertEquals(23,testHeroAge.getAge());



    }

    @Test
    public void getSuperPowers_testHeroSuperpowerSaveSuccessful_String() {
        Heroes testHeroSuperpower = setUpHero();
        assertEquals("flying",testHeroSuperpower.getSuperPowers());
    }

    @Test
    public void getWeakness_testHeroWeaknessSaveSuccessful_String() {
        Heroes testHeroWeakness = setUpHero();
        assertEquals("dopeness",testHeroWeakness.getWeakness());
    }


}