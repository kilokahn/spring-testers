
package com.kilo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

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
}
