package models;

import java.util.ArrayList;

public class Heroes {
    private String name;
    private String superPowers;
    private String weakness;
    private int age;
    private int id;
    private  static ArrayList<Heroes> allHeroes =new ArrayList<>();

    public Heroes(String name, int age, String superPowers, String weakness){
        this.name = name;
        this.age = age;
        this.superPowers = superPowers;
        this.weakness =weakness;
        this.id = allHeroes.size()+1;

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

    public int getId() {
        return id;
    }

    public static ArrayList<Heroes> getAllHeroes() {
        return allHeroes;
    }
}
