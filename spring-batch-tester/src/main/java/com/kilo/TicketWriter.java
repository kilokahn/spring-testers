
package com.kilo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class TicketWriter implements ItemWriter<Ticket> {

    private static Logger LOG = LoggerFactory.getLogger(TicketWriter.class);

    @Override
    public void write(List<? extends Ticket> items) throws Exception {
        LOG.info("Wrote tickets (" + items.size() + ")");
        LOG.debug("Wrote tickets " + items);
    }

}
