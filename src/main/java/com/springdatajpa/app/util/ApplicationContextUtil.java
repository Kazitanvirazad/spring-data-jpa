package com.springdatajpa.app.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdatajpa.app.config.AppConfig;
import com.springdatajpa.app.config.PersistentConfig;
import com.springdatajpa.app.config.PersistentConfigPG;

public class ApplicationContextUtil {

	public static ApplicationContext getApplicationContext() {
		ApplicationContext context = new AnnotationConfigApplicationContext(PersistentConfig.class,
				PersistentConfigPG.class, AppConfig.class);
		return context;
	}

}
