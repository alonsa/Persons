package SpringTest;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 7/7/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
//@Service
public class NormalBook implements Book{

    String name = "the brain";

    @Override
    public String toString(){
        return ("I am a Normal Book. " + name);

    }
}
