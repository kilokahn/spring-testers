
package com.kilo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("specialService")
public class SpecialServiceImpl implements SpecialService {

    @GET
    @Path("getSomeText")
    @Override
    public String getSomeText() {
        return "kilo";
    }
}
