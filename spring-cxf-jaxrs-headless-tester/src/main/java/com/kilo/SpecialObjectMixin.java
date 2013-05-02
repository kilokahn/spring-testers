
package com.kilo;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
public interface SpecialObjectMixin {

    @JsonProperty
    String getName();

    @JsonProperty
    Integer getId();
}
