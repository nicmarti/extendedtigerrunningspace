package controllers;

import java.util.ArrayList;

import models.Entry;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    public static Result cpage1(String name, int age) {
    	String s = "Extended Tiger Running Space. cpage1";
        return ok(vpage1.render(name, age));
    }
    
    public static Result displayObject() {
    	ArrayList <Entry> entries = new ArrayList<Entry>();
    	Entry entry1 = new Entry();
    	Entry entry2 = new Entry();
    	entry1.m1 = "entry from m1";
    	entry2.m2 = "entry from m2";
    	entries.add(entry1);
    	entries.add(entry2);
    	return ok(
    	    objectRenderer.render(entries)
    	);
    }

}
