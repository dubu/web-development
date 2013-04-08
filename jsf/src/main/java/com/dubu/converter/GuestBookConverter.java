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
        guests.put("CC", new Guest("CC", "good2","2008"));
        guests.put("Golf", new Guest("Golf", "good4", "1974"));
        guests.put("Jetta", new Guest("Jetta", "good5", "1979"));
        guests.put("Passat", new Guest("Passat", "good6", "1973"));

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
