package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import models.Bar;
import models.Entry;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.*;
import services.BarService;

public class Application extends Controller {

    @Autowired
    static BarService barService;

    public static Result index() {
        return ok(views.html.index.render("Some String param can eventually appear.."));
    }

    public static Result cpage1(String name, int age) {
        String s = "Extended Tiger Running Space. cpage1";
        return ok(views.html.vpage1.render(name, age));
    }

    public static Result displayObject() {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entry1.m1 = "entry from m1";
        entry2.m2 = "entry from m2";
        entries.add(entry1);
        entries.add(entry2);
        return ok(
                views.html.objectRenderer.render(entries)
        );
    }

    public static Result cpage3() {
        return ok(views.html.vpage3.render("plop"));
    }

    public static Result addBar(){
        //Bar bar = Form.form(Bar.class).bindFromRequest().get();
        //barService.addBar(bar);
//        Bar bar = form.get();
//        bar.save();
        return play.mvc.Controller.redirect(controllers.routes.Application.cpage3());
    }

    public static Result createNewBarAction() {
        Form<Bar> form = Form.form(Bar.class);
        return ok(views.html.createNewBar.render(form));
    }

    public static Result saveBar() {
        Form<Bar> form = Form.form(Bar.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(views.html.createNewBar.render(form)); // display the form with errors
        } else {
            Bar bar = form.get();
            bar.save();
            flash("success",String.format("New bar %s has been created",bar.name));
            return play.mvc.Controller.redirect(controllers.routes.Application.cpage3());
        }
    }

    public static Result getBars() {
        //return play.mvc.Controller.ok(Json.toJson(barService.getAllBars()));
        List<Bar> bars = new Model.Finder(String.class, Bar.class).all();

        // JAVA - content type est mis automatiquement
        // voir http://www.playframework.com/documentation/2.3.x/JavaResponse
        return ok(Json.toJson(bars));

    }

}
