
package com.kilo;

public class City {

    private Integer cityId;

    private String description;

    private String code;

    public City(int cityId, String description, String code) {
        this.cityId = cityId;
        this.description = description;
        this.code = code;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "City [cityId=" + cityId + ", description=" + description
                + ", code=" + code + "]";
    }
}
