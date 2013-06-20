package com.mkyong.rest;

import java.util.Collection;
import java.util.HashMap;

public class PersonsManager {
	
	private static PersonsManager _instance = new PersonsManager();
	
	private HashMap<Long, Person> _persons = new  HashMap<Long, Person>();

	private long _maxId = 0;
	
	private PersonsManager(){
		
	}
	
	public static PersonsManager getInstance() {
		return _instance;
		
	}
	

	public Person addPerson(Person person) {
		
		_persons.put(_maxId, person);
		
		return person;
		
	}
	
	public Person addPerson(String name) {
		
		_maxId +=1;
		Person person = new Person(name, _maxId);
		_persons.put(_maxId, person);
		
		return person;
		
	}
	
	public long getNumberOfPersons() {
		return _persons.size();
		
	}
	
	public Collection<Person> getAllPersons() {
		return _persons.values();
	}
	
	public long genMaxId() {
		_maxId += 1;
		return _maxId;
		
	}
	
	
	public Person getPersonById(Long id) {
		if (_persons.containsKey(id)){
			return _persons.get(id);
		}
		
		return null;
	}
	
	public Person deletePersonById(Long id) {
		if (_persons.containsKey(id)){
			return _persons.remove(id);
		}
		
		return null;
	}
	
	
	
	public boolean changePersonName(Long id, String name) {
		
		if (_persons.containsKey(id)){
			Person person = _persons.get(id);
			person.set_name(name);
			return true;
		}
		
		return false;
	}
}
