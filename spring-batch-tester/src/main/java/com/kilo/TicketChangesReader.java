
package com.kilo;

import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class TicketChangesReader implements ItemReader<Ticket> {

    private StepExecution stepExecution;

    @BeforeStep
    public void setStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    private int current = 0;

    @Override
    public Ticket read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        @SuppressWarnings("unchecked")
        List<Ticket> tickets = (List<Ticket>) stepExecution.getJobExecution()
                .getExecutionContext().get("changes");
        return current != tickets.size() ? tickets.get(current++) : null;
    }

}
