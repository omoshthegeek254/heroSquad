package models;

import java.util.ArrayList;

public class Squads {
    private String squadName;
    private String squadMembers;
    private String squadCause;
    private int id;



    private  static ArrayList<Squads> allSquads =new ArrayList<>();

    public Squads(String squadName, String squadMembers, String squadCause) {
        this.squadName = squadName;
        this.squadMembers = squadMembers;
        this.squadCause = squadCause;
        this.id = allSquads.size()+1;

        allSquads.add(this);
    }

    public String getSquadName() {
        return squadName;
    }

    public String getSquadMembers() {
        return squadMembers;
    }

    public String getSquadCause() {
        return squadCause;
    }

    public static ArrayList<Squads> getAllSquads() {
        return allSquads;
    }

    public int getId() {
        return id;
    }
}
