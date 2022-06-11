package tacos.security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import tacos.User;
import tacos.data.UserRepository;
 
@Configuration
public class SecurityConfig {
//	@Autowired
//	UserRepository userRepo;
	
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
 /*
  //method 1 of implementing single abstract method interface (SAM interface) without using Lambda (can be used for any java version)
  @Bean
 public UserDetailsService userDetailsService(UserRepository userRepo) {
	 return new UserDetailsService() {
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
			User user = userRepo.findByUsername(username);
		    if (user != null) return user;
		 
		    throw new UsernameNotFoundException("User '" + username + "' not found");
		}
	};
 }
 */
  
  
//method 2 of implementing single abstract method interface (SAM interface) USING Lambda (can be used for java 8 and above)
  @Bean
  public UserDetailsService userDetailsbService(UserRepository userRepo) {
    return username -> {
      User user = userRepo.findByUsername(username);
      if (user != null) return user;
   
      throw new UsernameNotFoundException("User '" + username + "' not found");
    };
  }
  
  @Bean //only design and order needs users to be authenticated
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeRequests()
        .antMatchers("/design", "/orders").access("hasRole('USER')")
        .antMatchers("/", "/**").access("permitAll()")
   
      .and()
        .formLogin()
          .loginPage("/login")
   
      .and()
      .build();
  }
  //in memory user authentication, not practical for production scenarios
//  @Bean
//  public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//    List<UserDetails> usersList = new ArrayList<>();
//    usersList.add(new User(
//        "buzz", encoder.encode("password"),
//            Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//    usersList.add(new User(
//        "woody", encoder.encode("password"),
//            Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//    return new InMemoryUserDetailsManager(usersList);
//  }
}