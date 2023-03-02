package org.acme.getting.started;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

@Entity
public class Location extends PanacheEntity {

    public String name;

    @Column(columnDefinition = "Geometry(Point,25832)")
    @Convert(converter = GeometryConverter.class)
    @JsonSerialize(contentUsing = GeometrySerializer.class)
    public Point geom;

}
