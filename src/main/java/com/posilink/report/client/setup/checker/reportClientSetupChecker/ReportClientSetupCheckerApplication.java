package com.posilink.report.client.setup.checker.reportClientSetupChecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReportClientSetupCheckerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ReportClientSetupCheckerApplication.class);
	}
}