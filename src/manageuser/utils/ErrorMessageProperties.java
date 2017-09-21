/**Copyright(C) 2017 Luvina
 * ErrorMessageProperties.java, Sep 21, 2017
 */
package manageuser.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author LA-PM
 *
 */
public class ErrorMessageProperties {
	static private Map<String, String> data = new HashMap<String, String>();

    static {
        Properties prop = new Properties();
        try {
        	prop.load(ErrorMessageProperties.class.getResourceAsStream(Constant.ERR_MESS_PROPERTIES));
        } catch (IOException e) {
            
        }

        Enumeration<String> en  = (Enumeration<String>)prop.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String)en.nextElement();
            data.put(key, prop.getProperty(key));
        }
    }


    /**
	 * 
	 * Thực hiện đọc từ hashmap
	 * @param key biến giá trị muốn đọc
	 * @return giá trị chuỗi cần lấy ra
	 * 
	 */
    static public String getErrorMessage(String key) {
        String string = "";
        if (data.containsKey(key)) {
            string = data.get(key);
        }
        return string;
    }

    public static void main(String[] args) {
		System.out.println("asdasd");
	}
}
