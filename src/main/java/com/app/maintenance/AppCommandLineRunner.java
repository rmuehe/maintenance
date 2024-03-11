package com.app.maintenance;

import com.app.maintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ConfigurableApplicationContext context;
    @Override
    public void run(String... args) throws Exception {
        App app = new App(userService);
        app.startCommandLineLoop();
        context.close();
    }
}
