import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main (String [] args){
        staticFileLocation( "/public");

        get("/", (request, response) -> {

            return new ModelAndView(null,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post ("/post-hero", (request, response) -> {

            return new ModelAndView(null,"post-hero.hbs");
        }, new HandlebarsTemplateEngine());

        post ("/hero-team", (request, response) -> {

            return new ModelAndView(null,"hero-team.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
