
package com.kilo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.kilo.domain.SpecialObject;

@Produces("application/json")
@CrossOriginResourceSharing(allowAllOrigins = true, allowCredentials = true, maxAge = 6000, allowHeaders = {
        "Content-Type", "X-Requested-With" }, exposeHeaders = { "Content-Type",
        "X-Requested-With" })
public class SpecialServiceImpl implements SpecialService {

    @GET
    @Path("/getSomeText/")
    @Override
    public String getSomeText() {
        return "kilo";
    }

    @GET
    @Path("/getSomeInt/")
    @Override
    public Integer getSomeInt() {
        return 7;
    }

    @GET
    @Path("/getSomeStrings/")
    @Override
    @Produces("application/xml")
    public List<String> getSomeStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("kilo");
        strings.add("kahn");
        return strings;
    }

    @GET
    @Path("/getSomeStringsWithInput/{data}/")
    @Override
    public List<String> getSomeStringsWithInput(@PathParam("data") String data) {
        List<String> strings = new ArrayList<>();
        strings.add("kilo");
        strings.add("kahn");
        strings.add(data);
        return strings;
    }

    @GET
    @Path("/getSomeStringsWithDateInput/")
    @Override
    public List<String> getSomeStringsWithDateInput(
            @QueryParam("date") Date date) {
        List<String> strings = new ArrayList<>();
        strings.add("kilo");
        strings.add("kahn");
        strings.add(date.toString());
        return strings;
    }

    @GET
    @Path("/getSomeStringsWithStringInputs/")
    @Override
    public List<String> getSomeStringsWithStringInputs(
            @QueryParam("ids") List<String> ids) {
        List<String> strings = new ArrayList<>();
        strings.add("kilo");
        strings.add("kahn");
        for (String id : ids) {
            strings.add(id.toString());
        }
        return strings;
    }

    @GET
    @Path("/getSomeIntsWithIntInputs/")
    @Override
    public List<Integer> getSomeIntsWithIntInputs(
            @QueryParam("ids") List<Integer> ids) {
        List<Integer> ints = new ArrayList<>();
        ints.add("kilo".hashCode());
        ints.add("kahn".hashCode());
        for (Integer id : ids) {
            ints.add(id);
        }
        return ints;
    }

    @GET
    @Path("/getSomeComplexObjectsWithIntInputs/")
    @Override
    public List<SpecialObject> getSomeComplexObjectsWithIntInputs(
            @QueryParam("ids") List<Integer> ids) {
        List<SpecialObject> complexObjects = new ArrayList<>();
        complexObjects.add(new SpecialObject("kilo", 1, new Date()));
        complexObjects.add(new SpecialObject("kahn", 2, new Date()));
        for (Integer id : ids) {
            complexObjects
                    .add(new SpecialObject(id.toString(), id, new Date()));
        }
        return complexObjects;
    }

    @GET
    @Path("/getSomeComplexObjectsWithMultipleInputs/")
    @Override
    public List<SpecialObject> getSomeComplexObjectsWithMultipleInputs(
            @QueryParam("name") String name, @QueryParam("value") Integer value) {
        List<SpecialObject> complexObjects = new ArrayList<>();
        complexObjects.add(new SpecialObject("kilo", 1, new Date()));
        complexObjects.add(new SpecialObject("kahn", 2, new Date()));
        complexObjects.add(new SpecialObject(name, value, new Date()));
        return complexObjects;

    }

    @GET
    @Path("/getSomeComplexObjectsWithDateInput/")
    @Override
    @Consumes("application/json")
    public List<SpecialObject> getSomeComplexObjectsWithDateInput(
            @QueryParam("ids") List<Integer> ids, @QueryParam("date") Date date) {
        List<SpecialObject> complexObjects = new ArrayList<>();
        complexObjects.add(new SpecialObject("kilo", 1, date));
        complexObjects.add(new SpecialObject("kahn", 2, date));
        for (Integer id : ids) {
            complexObjects.add(new SpecialObject(id.toString(), id, date));
        }
        return complexObjects;
    }

    @GET
    @Path("/getSomeComplexObjectsWithComplexInput/")
    @Override
    @Consumes("application/json")
    public List<SpecialObject> getSomeComplexObjectsWithComplexInput(
            @QueryParam("ids") List<Integer> ids,
            @QueryParam("date") Date date,
            @QueryParam("input") SpecialObject input) {
        List<SpecialObject> complexObjects = new ArrayList<>();
        complexObjects.add(new SpecialObject("kilo", 1, date));
        complexObjects.add(new SpecialObject("kahn", 2, date));
        for (Integer id : ids) {
            complexObjects.add(new SpecialObject(id.toString(), id, date));
        }
        complexObjects.add(input);
        return complexObjects;
    }
}
