package cl.scrapp.converters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateConverter.class);

    @Override
    public Date convert(String s) {
        Date parse = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parse = sdf.parse(s);
        } catch (ParseException e) {
            LOGGER.error("Parse exception", e);
        }
        return parse;
    }
}
