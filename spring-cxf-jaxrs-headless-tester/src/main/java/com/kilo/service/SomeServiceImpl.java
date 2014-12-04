
package com.kilo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.kilo.domain.SomeObject;
import com.kilo.domain.SomeOtherObject;

@Produces("application/json")
@CrossOriginResourceSharing(allowAllOrigins = true, allowCredentials = true, maxAge = 6000, allowHeaders = {
        "Content-Type", "X-Requested-With" }, exposeHeaders = { "Content-Type",
        "X-Requested-With" })
@Path("someService")
public class SomeServiceImpl implements SomeService {

    @GET
    @Path("/getSomeComplexObjectsWithIntInputs/")
    @Override
    public List<? extends SomeObject<String>> getSomeComplexObjectsWithIntInputs(
            @QueryParam("ids") List<Integer> ids) {
        List<SomeObject<String>> complexObjects = new ArrayList<>();
        complexObjects.add(new SomeOtherObject("kilo", "k"));
        complexObjects.add(new SomeOtherObject("kahn", "n"));
        // Totally different object
        complexObjects.add(new SomeObject<String>("kahnnnn"));
        for (Integer id : ids) {
            complexObjects.add(new SomeOtherObject(id.toString(), Integer
                    .toString(id.hashCode())));
        }
        return complexObjects;
    }

}
