package SpringTest;

import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 7/7/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DbBook implements Book{

    private static final String _id = "_id";

    private static final String _DbName = "alonEx";
    private static final String _CollactionName = "persons";


    private static DBCollection _personsCollection =null;

    @Autowired
    private DbManagerExe _dbManagerExe;

    String name = "the brain";

    @Override
    public String toString(){
        return ("I am a book with DB. " + name);

    }

    private DbBook() throws UnknownHostException {
//        String mongoURIString = "mongodb://localhost";
//        final MongoClient client = new MongoClient(new MongoClientURI(mongoURIString));
////        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
//
//        DB database = client.getDB(_DbName);
//        _personsCollection = database.getCollection(_CollactionName);

//        System.out.println("I am a  DbBook. My DB is: " +  _dbManagerExe);
    }

    @PostConstruct
    public void printDbType(){
        System.out.println("I am a  DbBook. My DB is: " +  _dbManagerExe);

    }
}
