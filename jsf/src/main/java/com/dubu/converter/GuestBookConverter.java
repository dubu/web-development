package com.dubu.converter;

/**
 * User: Administrator
 * Date: 13. 4. 4
 * Time: ?? 5:39
 */


import com.dubu.model.Guest;
import org.apache.commons.lang3.StringUtils;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;

@FacesConverter(value = "org.primefaces.cookbook.converter.GuestBookConverter")
public class GuestBookConverter implements Converter{

    public static Map<String, Guest> guests = new HashMap<String, Guest>();

    static {
        guests.put("guest01", new Guest("guest01", "good~!","2013-04-11"));
        guests.put("guest02", new Guest("guest02", "호..", "2013-04-11"));
        guests.put("guest03", new Guest("guest03", "좋아요.", "2013-04-11"));
        guests.put("guest04", new Guest("guest04", "멋짐", "2013-04-11"));
        guests.put("guest05", new Guest("guest05", "짱", "2013-04-11"));
        guests.put("guest06", new Guest("guest06", "보통", "2013-04-11"));
        guests.put("guest07", new Guest("guest07", "홋", "2013-04-11"));
        guests.put("guest08", new Guest("guest08", "주저리 주저리 어쩌구 저쩌구", "2013-04-11"));

    }

    public Object getAsObject(final FacesContext fc, final UIComponent component, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        else {
            return guests.get(value);
        }
    }

    public String getAsString(final FacesContext fc, final UIComponent component, final Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Guest) value).getName());
        }
    }
}
