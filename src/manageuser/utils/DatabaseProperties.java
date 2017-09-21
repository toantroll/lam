/**
 * Copyright(C) 2017 Luvina
 * DatabaseProperties.java, Jul 10, 2017
 */
package manageuser.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import manageuser.utils.Constant;

/**
 * Chứa phương thức đọc dữ liệu từ file .properties
 * @author DinhHop
 *
 */
@SuppressWarnings("unchecked")
public class DatabaseProperties {
	static private Map<String, String> data = new HashMap<String, String>();

    static {
        Properties prop = new Properties();
        try {
        	prop.load(DatabaseProperties.class.getResourceAsStream(Constant.FILE_NAME_PROPERTIES));
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
    static public String getDatabase(String key) {
        String string = "";
        if (data.containsKey(key)) {
            string = data.get(key);
        }
        return string;
    }
}
