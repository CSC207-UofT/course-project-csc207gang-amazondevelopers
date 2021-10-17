import java.util.ArrayList;

/**
 * take user input from command line interface and
 * Takes in user input tag words and and returns a list of all products that match that description to the user,
 * taking this information from a the masterManager which accese the tageProduct dictionary in master.
 * That dictionary has keys as the tag words for each product, and a list of product associated with that tag
 * word.
 */

public class searchController {

    public Object getSearchItems(String tagWord){

        if (masterManager.getSearchList(tagWord).equals(false)){
            return false;}
        else{

            return masterManager.getSearchList(tagWord);

        }
    }
}
