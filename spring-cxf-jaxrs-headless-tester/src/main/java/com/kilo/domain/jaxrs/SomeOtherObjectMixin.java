
package com.kilo.domain.jaxrs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public interface SomeOtherObjectMixin {

    @JsonProperty
    public String getName();

    @JsonProperty
    public String getCode();
}
