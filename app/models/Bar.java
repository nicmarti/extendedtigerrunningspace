package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Bar extends Model {
	
	@Id
	public String id;

    @Constraints.Required
	public String name;

    //@Constraints.Email
    //public String email;

    //@Constraints.MinLength(8)
    //public String password;
}
