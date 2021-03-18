package fr.eql.ai108.pandami.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="localDateTimeConverter")
public class LocalDateTimeConverter implements Converter {
 
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
 
        LocalDateTime dateValue = (LocalDateTime) value;

        return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

}