
package com.kilo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class TicketPartitioner implements Partitioner {

    private static final String PARTITION_KEY = "partition";

    private static String[] parsePatterns = { "yyyy-mm-dd" };

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        List<Ticket> tickets = getTicketsFromService();
        Map<City, List<Ticket>> sourceCityTicketMap = new HashMap<>();
        for (Ticket ticket : tickets) {
            City sourceCity = ticket.getSourceCity();
            List<Ticket> existingList = sourceCityTicketMap.get(sourceCity);
            if (existingList == null) {
                existingList = new ArrayList<>();
            }
            existingList.add(ticket);
            sourceCityTicketMap.put(sourceCity, existingList);
        }

        Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>(
                gridSize);
        int count = 0;
        for (Entry<City, List<Ticket>> entry : sourceCityTicketMap.entrySet()) {
            ExecutionContext context = new ExecutionContext();
            context.put("sourceCity", entry.getKey());
            context.put("changes", entry.getValue());
            map.put(PARTITION_KEY + count, context);
            count++;
        }
        return map;
    }

    /**
     * @return
     */
    private List<Ticket> getTicketsFromService() {
        try {
            return getTickets();
        } catch (ParseException exception) {
            throw new RuntimeException("Horribly wrong", exception);
        }
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
