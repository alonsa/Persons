package com.mkyong.rest;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 7/8/13
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class MongoDbCollection {
    private static final String _name = "name";
    private static final String _id = "_id";
    private static final String _mongoURIString = "mongodb://localhost";
    private static final String _CollactionName = "persons";

    private DBCollection _personsCollection;


    private static final String _DbName = "alonEx";

    public MongoDbCollection() throws UnknownHostException {

        final MongoClient client = new MongoClient(new MongoClientURI(_mongoURIString));

        DB database = client.getDB(_DbName);
        _personsCollection = database.getCollection(_CollactionName);
        System.out.println("I am in mongoDbCollection");

    }

    public DBCollection getPersonsCollection(){
           return _personsCollection;
    }

    public String toString(){
       return ("I am in mongoDbCollection");

    }
}
