
package com.kilo;

import java.util.Date;

public class Ticket {

    private City sourceCity;

    private City destinationCity;

    private Date journeyDate;

    public Ticket(Date journeyDate, City sourceCity, City destinationCity) {
        this.journeyDate = journeyDate;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
    }

    public City getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(City sourceCity) {
        this.sourceCity = sourceCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Ticket [sourceCity=" + sourceCity + ", destinationCity="
                + destinationCity + ", journeyDate=" + journeyDate + "]";
    }
}
