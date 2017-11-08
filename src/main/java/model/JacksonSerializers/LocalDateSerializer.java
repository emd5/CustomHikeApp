package model.JacksonSerializers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * This class is the Deserializer used by an objectmapper for localdates
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {

    private static final long serialVersionUID = 1L;

    public LocalDateSerializer() {
        super(LocalDate.class);
    }

    /**
     * This serializes a localdate, see super
     *
     * @param value the localdate
     * @param gen   the jsonGenerator
     * @param sp    the serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider sp) throws IOException {
        gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
