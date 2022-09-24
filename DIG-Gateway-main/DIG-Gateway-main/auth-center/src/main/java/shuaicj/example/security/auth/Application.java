package shuaicj.example.security.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot app.
 *
 */
@SpringBootApplication(scanBasePackages = {"shuaicj.example.security.*","shuaicj.example.security.common.*"})
@EnableJpaRepositories(basePackages = "shuaicj.example.security.common.repository.*")
@EntityScan(basePackages = {"shuaicj.example.security.common.*"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
