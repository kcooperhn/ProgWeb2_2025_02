package uth.hn.demojsf.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@FacesConverter("myCustomDateConverter") // Assign a unique ID to the converter
public class MyDateConverter implements Converter<LocalDateTime> {

    @Override
    public LocalDateTime getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.trim().isEmpty()) {
            return null;
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd 'de' LLLL 'del' yyyy hh:mm a");
        LocalDateTime fecha = LocalDateTime.parse(submittedValue, format);
        return fecha;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, LocalDateTime value) {
        if (value == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' LLLL 'del' yyyy hh:mm a");
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = value.atZone(zoneId);
        Instant instant = zonedDateTime.toInstant();
        Date utilDate = Date.from(instant);

        return sdf.format(utilDate);
    }
}
