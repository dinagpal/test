package net.trajano.test;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class AppCacheProvider {

    @PostConstruct
    public void init() {

        final CacheManager cacheManager = Caching.getCachingProvider()
            .getCacheManager();
        final Set<String> cacheNames = new HashSet<>();
        for (final String name : cacheManager.getCacheNames()) {
            cacheNames.add(name);
        }
        System.out.println(cacheNames);
    }

    @PreDestroy
    public void contextDestroyed() {

        Caching.getCachingProvider()
            .close(Thread.currentThread()
                .getContextClassLoader());
    }
}
