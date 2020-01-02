import models.Heroes;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main (String [] args){
        staticFileLocation( "/public");

        get("/", (request, response) -> {

            return new ModelAndView(null,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post ("/post-hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String superPowers = request.queryParams("superPowers");
            String weakness = request.queryParams("weakness");

            Heroes newHero = new Heroes(name,age,superPowers,weakness);


            return new ModelAndView(null,"post-hero.hbs");
        }, new HandlebarsTemplateEngine());

        post ("/hero-team", (request, response) -> {

            return new ModelAndView(null,"hero-team.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
