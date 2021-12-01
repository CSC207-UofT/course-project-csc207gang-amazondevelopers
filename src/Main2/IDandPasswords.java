import java.util.HashMap;

public class IDandPasswords {

    HashMap<String, String> logininfo = new HashMap<String,String>();

    IDandPasswords(){
        logininfo.put("Bro", "pizza");
        logininfo.put("Sup", "PASSWORD");
        logininfo.put("BroCode", "abc123");

    }
    protected HashMap getLoginInfo(){return logininfo;
    }
    public void add(String key, String value) {
        getLoginInfo().put(key, value);

    }
}
