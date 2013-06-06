
package com.kilo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class EmbeddedJettyDriver {

    private static Logger LOG = LoggerFactory
            .getLogger(EmbeddedJettyDriver.class);

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            throw new IllegalArgumentException("Port number is mandatory");
        }
        Integer portNumber = Integer.parseInt(args[0]);
        StopWatch sw = new StopWatch();
        sw.start();
        LOG.info("Starting driver context load");
        Server server = new Server(portNumber);
        WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setWar("src/main/webapp");

        server.setHandler(root);

        sw.stop();
        LOG.info("Done driver context load in " + sw.getLastTaskTimeMillis());

        server.start();
        server.join();

    }
}
