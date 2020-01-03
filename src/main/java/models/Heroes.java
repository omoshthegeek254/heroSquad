package models;

import java.util.ArrayList;

public class Heroes {
    private String name;
    private String superPowers;
    private String weakness;
    private int age;
    private  static ArrayList<Heroes> allHeroes =new ArrayList<>();

    public Heroes(String name, int age, String superPowers, String weakness){
        this.name = name;
        this.age = age;
        this.superPowers = superPowers;
        this.weakness =weakness;

        allHeroes.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSuperPowers() {
        return superPowers;
    }

    public String getWeakness() {
        return weakness;
    }



    public static ArrayList<Heroes> getAllHeroes() {
        return allHeroes;
    }
}
