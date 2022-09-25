package org.acme.getting.started;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;
import com.vividsolutions.jts.io.WKBWriter;


@Converter(autoApply = true)
public class GeometryConverter implements AttributeConverter<Geometry, String> {
 
    Logger log = LogManager.getLogManager().getLogger(this.getClass().getName());

    private static WKBWriter writer = new WKBWriter();
    private static WKBReader reader = new WKBReader();
 
    @Override
    public String convertToDatabaseColumn(Geometry geom) {
        String wkbString = WKBWriter.toHex(writer.write(geom));
        log.info("Convert "+geom+" to "+wkbString);
        return wkbString;
    }
 
    @Override
    public Geometry convertToEntityAttribute(String wkbString) {
        Geometry geom;
        try {
            geom = reader.read(WKBReader.hexToBytes(wkbString));
            log.info("Convert "+wkbString+" to "+geom);
            return geom;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
