
package com.kilo;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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

        Server server = new Server(portNumber);
        File webappDir = findContainingFileName();
        String contextPath = "/";
        LOG.info(
                "Attempting to start webapp located at {} at context path {} and port {}",
                new Object[] { webappDir, contextPath, portNumber });
        WebAppContext root = new WebAppContext(webappDir.getAbsolutePath(),
                contextPath);
        server.setHandler(root);
        server.start();

        sw.stop();
        LOG.info("Server started in " + sw.getLastTaskTimeMillis());

        server.join();

    }

    /**
     * When running exploded, this will return path to a directory like
     * 'target/classes'. If running from jar, this will return the path to the
     * jar/war
     * 
     * Borrowed from
     * http://javajing.com/2012/08/03/executable-standalone-web-apps.html
     * 
     * @return path to wherever the class files exist
     * @throws IOException
     */
    private static File findContainingFileName() throws IOException {
        URL url = EmbeddedJettyDriver.class.getProtectionDomain()
                .getCodeSource().getLocation();
        return new File(url.getFile());
    }

}
