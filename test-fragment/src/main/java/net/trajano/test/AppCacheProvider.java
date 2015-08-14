package net.trajano.test;

import javax.annotation.PostConstruct;
import javax.cache.Caching;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class AppCacheProvider {
	@PostConstruct
	public void init() {
		Caching.getCachingProvider().getCacheManager();
	}
}
