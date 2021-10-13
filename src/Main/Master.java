import java.util.HashMap;


public class Master {

    private HashMap<String, User> userDict = new HashMap<>();
    private HashMap<String, Product> productDict = new HashMap<>();




    public HashMap<String, User> getterUser(){
        return userDict;
    }

    public HashMap<String, Product> getterProduct(){
        return productDict;
    }


    public void setterUser(String username, User userProfile){
        userDict.put(username, userProfile);
    }

    public void setterProduct(String productID, Product item){
        productDict.put(productID, item);

    }



}
