
package com.kilo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TicketProcessor implements ItemProcessor<Ticket, Ticket> {

    private static Logger LOG = LoggerFactory.getLogger(TicketProcessor.class);

    @Override
    public Ticket process(Ticket item) throws Exception {
        LOG.debug("Processing item " + item);
        return item;
    }

}
