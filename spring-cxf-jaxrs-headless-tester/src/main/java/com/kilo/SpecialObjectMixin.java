
package com.kilo;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
public interface SpecialObjectMixin {

    @JsonProperty
    public String getName();

    @JsonProperty
    public Date getDate();
}
