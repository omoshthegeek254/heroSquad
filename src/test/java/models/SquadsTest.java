package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadsTest {

    //squads helper method
    public Squads setUpSquad(){
        return new Squads("wabebe","wakanda","feminism");

    }

    @Test
    public void getSquadName_testSquadNameSuccessful_String() {
        Squads testSquadName= setUpSquad();
        assertEquals("wabebe",testSquadName.getSquadName());
    }

    @Test
    public void getSquadMembers_testSquadMembersSuccessful_String() {
        Squads testSquadMembers= setUpSquad();
        assertEquals("wakanda",testSquadMembers.getSquadMembers());
    }

    @Test
    public void getSquadCause_testSquadCauseSuccessful_String() {
        Squads testSquadCause = setUpSquad();
        assertEquals("feminism",testSquadCause.getSquadCause());
    }


}