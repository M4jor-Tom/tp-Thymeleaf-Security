package com.example.demo.model;

/**
 * La classe PersonForm représentent des données de FORM lorsque vous créez une
 * nouvelle Person sur la page addPerson.
 *
 */
public class PersonForm {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean fieldsAreFilled() {
		return
				!getLastName().equalsIgnoreCase("")
				&& !getFirstName().equalsIgnoreCase("");
	}
}
