package com.app.maintenance;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MaintenanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MaintenanceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(AppCommandLineRunner appCommandLineRunner) {
//        return args -> appCommandLineRunner.run(args);
//    }
}













//package com.app.maintenance;


//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//
//@SpringBootApplication
//public class MaintenanceApplication implements CommandLineRunner {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
////    @Autowired
////    private App app;
////
////    public MaintenanceApplication(ApplicationContext applicationContext) {
////        this.applicationContext = applicationContext;
////    }
//    @Override
//    public void run(String... args) throws Exception {
////        App app = new App();
//        app.startCommandLineLoop();
//        ((ConfigurableApplicationContext)applicationContext).close();
//    }
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(MaintenanceApplication.class, args);
//    }
//}
