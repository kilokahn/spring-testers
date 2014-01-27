
package com.kilo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.item.ExecutionContext;

public class PopulateTicketsJobListener implements JobExecutionListener {

    private static Logger LOG = LoggerFactory
            .getLogger(PopulateTicketsJobListener.class);

    private static String[] parsePatterns = { "yyyy-mm-dd" };

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOG.info("Job starting now");
        try {
            List<Ticket> tickets = getTickets();
            ExecutionContext executionContext = jobExecution
                    .getExecutionContext();
            executionContext.put("changes", tickets);
        } catch (ParseException exception) {
            throw new RuntimeException("Horribly wrong", exception);
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        LOG.info("Job ending now");
    }

    private List<Ticket> getTickets() throws java.text.ParseException {
        List<Ticket> tickets = new ArrayList<>();
        City city1 = new City(1, "Mumbai", "MUM");
        City city2 = new City(2, "New Delhi", "DEL");
        City city3 = new City(3, "Calcutta", "CAL");
        City city4 = new City(4, "Chennai", "MAD");
        City city5 = new City(5, "Hyderabad", "HYD");
        City city6 = new City(6, "Bangalore", "BLR");
        Ticket ticket1 = new Ticket(DateUtils.parseDateStrictly("2014-01-01",
                parsePatterns), city1, city2);
        Ticket ticket2 = new Ticket(DateUtils.parseDateStrictly("2014-01-01",
                parsePatterns), city2, city3);
        Ticket ticket3 = new Ticket(DateUtils.parseDateStrictly("2014-01-01",
                parsePatterns), city3, city4);
        Ticket ticket4 = new Ticket(DateUtils.parseDateStrictly("2014-01-01",
                parsePatterns), city4, city5);
        Ticket ticket5 = new Ticket(DateUtils.parseDateStrictly("2014-01-01",
                parsePatterns), city5, city6);
        Ticket ticket6 = new Ticket(DateUtils.parseDateStrictly("2014-01-01",
                parsePatterns), city6, city1);

        for (int i = 0; i < 100; i++) {
            tickets.add(ticket1);
        }
        for (int i = 0; i < 100; i++) {
            tickets.add(ticket2);
        }
        for (int i = 0; i < 100; i++) {
            tickets.add(ticket3);
        }
        for (int i = 0; i < 100; i++) {
            tickets.add(ticket4);
        }
        for (int i = 0; i < 100; i++) {
            tickets.add(ticket5);
        }
        for (int i = 0; i < 100; i++) {
            tickets.add(ticket6);
        }
        return tickets;
    }
}
