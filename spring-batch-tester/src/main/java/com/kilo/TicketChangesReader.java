
package com.kilo;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class TicketChangesReader implements ItemReader<Ticket> {

    private transient List<Ticket> tickets;

    private int current = 0;

    @Override
    public Ticket read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        return current != tickets.size() ? tickets.get(current++) : null;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
