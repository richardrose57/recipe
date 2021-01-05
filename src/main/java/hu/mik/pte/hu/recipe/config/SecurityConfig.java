package hu.mik.pte.hu.recipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/images/**","/favicon.ico**").permitAll()
                //.antMatchers("/greeting").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", false)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();

        //@formatter:on
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new InMemoryUserDetailsManager(User.builder()
                .passwordEncoder(s -> this.passwordEncoder().encode(s))
                .username("user")
                .password("userPass")
                .roles("USER")
                .build(),
                User.builder()
                        .passwordEncoder(s -> this.passwordEncoder().encode(s))
                        .username("admin")
                        .password("adminPass")
                        .roles("USER","ADMIN")
                        .build() );
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
