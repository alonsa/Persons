package com.mkyong.rest;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//import org.codehaus.jackson.annotate.JsonCreator;
//import org.codehaus.jackson.annotate.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	 @JsonProperty("name")
	private String _name;

	private long _id;


	public Person(String name,long id ) {
		_name = name;
		_id = id;
	}

	@JsonCreator
	public Person( @JsonProperty("name") String name) {
		_name = name;
        _id = -1;
	}

    @JsonProperty("name")
    public String get_name( ) {

		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public long get_id() {
		return _id;
	}

    public void set_id(long id){
        this._id = id;
    }

	@Override
	public String toString() {
		return "Person [NAME = " + _name + ", ID = " + _id + "]";
	}



}
