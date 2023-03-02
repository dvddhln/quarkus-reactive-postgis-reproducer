package org.acme.getting.started;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationResource {

    @GET
    public Uni<List<Location>> getAll() {
        return Location.listAll();
    }


    @POST
    @ReactiveTransactional
    public Uni<Location> post() {
        Location l = new Location();

        var gf = new GeometryFactory();
        Point p = gf.createPoint(new Coordinate(-10, 10));

        l.geom = p;

        return l.persist();
    }
}
