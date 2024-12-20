package pl.krakow.uken.web_service_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class WebService2Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(WebService2Application.class);

	@Autowired
	JdbcTemplate jdbc;

	public static void main(String[] args) {
		SpringApplication.run(WebService2Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("start aplikacji WebService");
		checkDatabase();
	}

	private void checkDatabase(){
		log.info("Sprawdzanie bazy danych");
		jdbc.execute(" CREATE TABLE IF NOT EXISTS `Person` (" + //
		  	"  `id` int(11) NOT NULL AUTO_INCREMENT," + //
			"  `first_name` varchar(100) COLLATE utf8_polish_ci NOT NULL," + //
			"  `last_name` varchar(150) COLLATE utf8_polish_ci NOT NULL," + //
			"  `age` int(11) NOT NULL," + //
			"  `city` varchar(150) COLLATE utf8_polish_ci NOT NULL," + //
			"  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP," + //
			"  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP," + //
			"	PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;");
		
		log.info("Sprawdzanie bazy danych zakończone");
	}
}
