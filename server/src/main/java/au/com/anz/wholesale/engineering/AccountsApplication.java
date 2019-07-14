package au.com.anz.wholesale.engineering;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AccountsApplication {

	public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

    @Bean
    ApplicationRunner init(AccountsRepository accRepository, TransactionsRepository transRepository) throws IOException {

    	File accFile = new File(
    			getClass().getClassLoader().getResource("accountData.txt").getFile()
        );
        BufferedReader accBr = Files.newBufferedReader(Paths.get(accFile.getPath()));
        
        File transFile = new File(
    			getClass().getClassLoader().getResource("transactionData.txt").getFile()
        );
        BufferedReader transBr = Files.newBufferedReader(Paths.get(transFile.getPath()));
            
        return args ->
        {
        	String accLine;
            Accounts account = null;
            String transLine;
            Transactions transaction = null;
            
            while ((accLine = accBr.readLine()) != null) {
                account = new ObjectMapper().readValue(accLine, Accounts.class);
                accRepository.save(account);
            }
            
            while ((transLine = transBr.readLine()) != null) {
                transaction = new ObjectMapper().readValue(transLine, Transactions.class);
                transRepository.save(transaction);
            }
            
        };


    }

    @Bean
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
