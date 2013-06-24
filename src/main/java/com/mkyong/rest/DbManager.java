package com.mkyong.rest;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 7/4/13
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class DbManager{

    private static final String _name = "name";
    private static final String _id = "_id";

    private static final String _DbName = "alonEx";
    private static final String _CollactionName = "persons";

    @Autowired
    private MongoDbCollection _mongoDbCollection;

    private  DBCollection  _personsCollection;

    private DbManager() throws IOException {

//        String mongoURIString = "mongodb://localhost";
//        final MongoClient client = new MongoClient(new MongoClientURI(mongoURIString));
////        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
//
//        DB database = client.getDB(_DbName);
//        _personsCollection = database.getCollection(_CollactionName);
//        _mongoDbCollection = new MongoDbCollection();
//        _personsCollection =    _mongoDbCollection.getPersonsCollection();

        System.out.println("DbManager created");
    }

    @PostConstruct
        void postConstruct(){
        System.out.println("set the personsCollection in postConstruct. _mongoDbCollection IS: " + _mongoDbCollection);
        _personsCollection =    _mongoDbCollection.getPersonsCollection();
    }

    @Override
    public String toString()  {

        return "Connecting to MongoDB DataBase. DbName: " +_DbName + ". CollactionName: " + _CollactionName ;

    }

    public boolean put(Person person){

        BasicDBObject user = new BasicDBObject();
        user.append(_id, person.get_id()).append(_name, person.get_name());

        try {
            _personsCollection.insert(user);
            return true;
        } catch (MongoException.DuplicateKey e) {
            System.out.println("Username already in use: " + person.get_name());
            return false;
        }

    }

    public boolean put(String personName){

        BasicDBObject user = new BasicDBObject();
        user.append(_id,numberOfPersons()+1).append(_name, personName);

        try {
            _personsCollection.insert(user);
            return true;
        } catch (MongoException.DuplicateKey e) {
            System.out.println("Username already in use: " + personName);
            return false;
        }

    }

    public Long numberOfPersons(){

        return _personsCollection.count();
    }


    public List<DBObject> getAllPersons(){
        DBCursor result = _personsCollection.find();
        try{
            if (result != null || result.size() == 0 ) {
                    return result.toArray();
            }else {

            }

        }  finally {
            result.close();
        }
        return new ArrayList<DBObject>();

    }

    public DBObject getPersonById(Long id){

        BasicDBObject user = new BasicDBObject();;
        user.append(_id, id);

        DBObject result = _personsCollection.findOne(user);

        return result;

    }

    public boolean deletePersonById(Long id){
        BasicDBObject user = new BasicDBObject();;
        user.append(_id, id);

        WriteResult result = _personsCollection.remove(user);
        if (result.getError() != null){
            return false;
        }else{
            return true;
        }
    }

    public boolean changePersonName(Long id, String name){
        BasicDBObject user = new BasicDBObject();;
        user.append(_id, id);

        BasicDBObject update = new BasicDBObject("$set", new BasicDBObject(_name, name));



        WriteResult result = _personsCollection.update(user, update ) ;
        if (result.getError() != null){
            return false;
        }else{
            return true;
        }
    }

}
