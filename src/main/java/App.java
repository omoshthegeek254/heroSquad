import models.Heroes;
import models.Squads;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main (String [] args){
        port(getHerokuAssignedPort());
        staticFileLocation( "/public");

//        get("/", (request, response) -> {
//        returning all heroes
        get("/heroes", (request, response) -> {


            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Heroes> allHeroes = Heroes.getAllHeroes();


            model.put("allHeroes", allHeroes);



//            return new ModelAndView(model,"index.hbs");
            return new ModelAndView(model,"heroes.hbs");
        }, new HandlebarsTemplateEngine());

//        returning squads

        get("/squads", (request, response) -> {


            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Heroes> allHeroes = Heroes.getAllHeroes();
            ArrayList<Squads> allSquads = Squads.getAllSquads();

            model.put("allHeroes", allHeroes);
            model.put("allSquads", allSquads);



//            return new ModelAndView(model,"index.hbs");
            return new ModelAndView(model,"squads.hbs");
        }, new HandlebarsTemplateEngine());

//        post ("/post-hero", (request, response) -> {
        post ("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String superPowers = request.queryParams("superPowers");
            String weakness = request.queryParams("weakness");

            Heroes newHero = new Heroes(name,age,superPowers,weakness);


            return new ModelAndView(model,"post-hero.hbs");
        }, new HandlebarsTemplateEngine());

//        handles heroes post and display

        post ("/squads", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            String squadName = request.queryParams("squadName");
            String squadMembers = request.queryParams("squadMembers");
            String squadCause = request.queryParams("squadCause");

            Squads newSquad = new Squads(squadName,squadMembers,squadCause);


            return new ModelAndView(model,"hero-team.hbs");
        }, new HandlebarsTemplateEngine());

        //handles post from signin on signin hbs

        post("/", (request, response) -> {
            Map<String, String> model =new HashMap<>();
            String username = request.queryParams("username");
            request.cookie("username");
            model.put("username",username);



            return new ModelAndView(model,"signin.hbs");
        }, new HandlebarsTemplateEngine());

//return usr cookies

        get("/", (request, response) -> {
            Map<String, String> model =new HashMap<>();
            model.put("username",request.cookie("username"));



            return new ModelAndView(model,"signin.hbs");
        }, new HandlebarsTemplateEngine());


    }

}
