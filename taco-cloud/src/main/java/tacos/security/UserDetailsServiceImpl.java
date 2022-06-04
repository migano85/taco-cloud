//package tacos.security;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
////		UserDetails userDetails = new User("buzz", encoder.encode("password"),
////	            		Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
//		List<UserDetails> usersList = new ArrayList<>();
//	    usersList.add(new User(
//	        "buzz", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//	    usersList.add(new User("woody", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//	    User user = null;
//	    for(UserDetails u : usersList) {
//	    	if(u.getUsername().equals(username)) {
//	    		user = new User(u.getUsername(), u.getPassword(), u.getAuthorities()); break;
//	    	}
//	    }
////		User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new MyUserPrincipal(user);
//	}
//
//}
