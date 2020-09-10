package tacos.security.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	//private DataSource dataSource;
	private UserDetailsService userdetailsService;

	/***
	 * 
	 * public class JdbcDaoImpl extends JdbcDaoSupport implements UserDetailsService, MessageSourceAware {
	 * public static final String DEF_USERS_BY_USERNAME_QUERY = "select username,password,enabled "
	 * + "from users " + "where username = ?";
	 * public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = "select username,authority "
	 * + "from authorities " + "where username = ?";
	 * public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY = "select g.id, g.group_name, ga.authority "
	 * + "from groups g, group_members gm, group_authorities ga "
	 * + "where gm.username = ? " + "and g.id = ga.group_id "
	 * + "and g.id = gm.group_id";
	 * 
	 */
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from users where username =?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username = ?")
		.passwordEncoder(new BCryptPasswordEncoder());
		*/
		auth.userDetailsService(userdetailsService).passwordEncoder(encoder());
		log.info("jdbc security online");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
			.antMatchers("/design","/orders").hasRole("USER")
			.antMatchers("/","/**").permitAll()
			.and()
			.formLogin().loginPage("/login");
	}

}
