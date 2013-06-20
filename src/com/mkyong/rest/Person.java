package com.mkyong.rest;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Person {
	
	 @JsonProperty("_name")
	private String _name;
	 
	private long _id;
	
	
	public Person(String name,long id ) {
		_name = name;
		_id = id;
		
	}
	
	
	@JsonCreator
	public Person( @JsonProperty("_name") String name) {
		_name = name;
		_id = PersonsManager.getInstance().genMaxId();
	}
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public long get_id() {
		return _id;
	}
	
	@Override
	public String toString() {
		return "Person [NAME=" + _name + ", ID=" + _id + "]";
	}

	

}
