
package com.kilo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchTesterDriver {

    private static Logger LOG = LoggerFactory
            .getLogger(SpringBatchTesterDriver.class);

    private static ClassPathXmlApplicationContext classPathXmlApplicationContext;

    public static void main(String[] args) {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/applicationContext.xml",
                "classpath:com/kilo/logging.xml");
        LOG.info("Inited");

        JobLauncher jobLauncher = classPathXmlApplicationContext.getBean(
                "jobLauncher", JobLauncher.class);
        Job job = classPathXmlApplicationContext.getBean("populateTicketsJob",
                Job.class);
        try {
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            ExitStatus exitStatus = execution.getExitStatus();
            LOG.info("Exit status is : " + exitStatus);
        } catch (JobExecutionAlreadyRunningException | JobRestartException
                | JobInstanceAlreadyCompleteException
                | JobParametersInvalidException exception) {
            throw new RuntimeException("Unable to run job", exception);
        }
        LOG.info("Done");
    }
}
