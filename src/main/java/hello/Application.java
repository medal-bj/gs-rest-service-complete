package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
    	//System.setProperty("datasource.url", "jdbc:mysql://localhost:3036");
    	//System.setProperty("datasource.username", "root");
    	//System.setProperty("datasource.password", "root");
    	//System.setProperty("datasource.driverClassName", "com.mysql.jdbc.Driver");
    	//System.setProperty("proxyPort", "8080");
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public CommandLineRunner demo(JoueurRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Joueur("Jack"));
			repository.save(new Joueur("Chloe"));
			repository.save(new Joueur("Kim"));
			repository.save(new Joueur("David"));
			repository.save(new Joueur("Michelle"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Joueur customer : repository.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
            Joueur customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");
		};
	}
}
