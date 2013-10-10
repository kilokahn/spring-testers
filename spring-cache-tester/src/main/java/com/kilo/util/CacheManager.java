
package com.kilo.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.cache.Cache;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Manages cache operations")
public class CacheManager {

    private static Logger LOG = Logger.getLogger(CacheManager.class);

    private List<Cache> caches;

    @ManagedOperation(description = "Flush spring caches")
    public void flushSpringCaches() {
        LOG.info("Flushing spring caches");
        for (Cache cache : caches) {
            LOG.info("Flushing spring cache " + cache.getName());
            cache.clear();
        }
    }

    public void setCaches(List<Cache> caches) {
        this.caches = caches;
    }

}
