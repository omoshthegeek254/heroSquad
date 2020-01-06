import models.Heroes;
import models.Squads;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main (String [] args){
        staticFileLocation( "/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Heroes> allHeroes = Heroes.getAllHeroes();
            ArrayList<Squads> allSquads = Squads.getAllSquads();

            model.put("allHeroes", allHeroes);
            model.put("allSquads", allSquads);


            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post ("/post-hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String superPowers = request.queryParams("superPowers");
            String weakness = request.queryParams("weakness");

            Heroes newHero = new Heroes(name,age,superPowers,weakness);


            return new ModelAndView(model,"post-hero.hbs");
        }, new HandlebarsTemplateEngine());

        post ("/hero-team", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            String squadName = request.queryParams("squadName");
            String squadMembers = request.queryParams("squadMembers");
            String squadCause = request.queryParams("squadCause");

            Squads newSquad = new Squads(squadName,squadMembers,squadCause);


            return new ModelAndView(null,"hero-team.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
