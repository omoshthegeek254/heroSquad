import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main (String [] args){
        staticFileLocation( "/public");

        get("/", (request, response) -> {

            return new ModelAndView(null,"index.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
