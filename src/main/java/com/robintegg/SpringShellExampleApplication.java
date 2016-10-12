package com.robintegg;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.shell.support.logging.HandlerUtils;

@SpringBootApplication
public class SpringShellExampleApplication {

	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext ctx = SpringApplication.run(SpringShellExampleApplication.class, args);

		try {
			BootShim bs = new BootShim(args, ctx);
			bs.run();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			HandlerUtils.flushAllHandlers(Logger.getLogger(""));
		}

	}

}