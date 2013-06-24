package com.mkyong.rest;


import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PersonsManager  {

    private static final String _DbName = "alonEx";
    private static final String _CollactionName = "persons";

    @Autowired
    private DbManager _dbManager;

    public PersonsManager(){
        System.out.println("I am in default constructor of PersonsManager");

    }

	public PersonsManager(DbManager dbManager ) {
//        _dbManager = dbManager;
        System.out.println("I am in PersonsManager");
    }

    @PostConstruct
    void postConstruct(){
        System.out.println("set the dbManager in postConstruct");
//        _personsCollection =    _mongoDbCollection.getPersonsCollection();
    }

    public String toString(){
        return "PersonsManager is created" ;
    }

	public void addPerson(Person person) {
        person.set_id(getNumberOfPersons()+ 1);
        _dbManager.put(person);
	}


	public long getNumberOfPersons() {
	   return _dbManager.numberOfPersons();

	}

	public Collection<Person> getAllPersons() throws UnknownHostException {

        ArrayList<Person> persons = new ArrayList<Person>();

        List<DBObject> result = _dbManager.getAllPersons();
        System.out.println("result is: " +result);
        for (DBObject dbPerson : result){
              persons.add(dbPersomToPerson(dbPerson));
        }

        return persons;
	}

	public Person getPersonById(Long id) {
        DBObject dbPerson = _dbManager.getPersonById(id);
			return dbPersomToPerson(dbPerson);
	}

	public void deletePersonById(Long id) {
         _dbManager.deletePersonById(id);

	}

	public boolean changePersonName(Long id, String name) {

        _dbManager.changePersonName(id, name) ;

		return  _dbManager.changePersonName(id, name);
	}

    public Person dbPersomToPerson(DBObject dbPerson){
        if (dbPerson == null){
            return null;
        }else{
            return new Person(dbPerson.get("name").toString(), (Long) (dbPerson.get("_id"))) ;
        }
    }
}