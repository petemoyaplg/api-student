package com.plg.apistudent.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
// @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public SecurityConfig(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception
  // {
  // }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
        .antMatchers("api/**").hasRole(Role.STUDENT.name())
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    UserDetails annasmith = User
        .builder()
        .username("annasmith")
        .password(this.passwordEncoder.encode("annasmith12345"))
        .roles(Role.STUDENT.name())
        .build();
    UserDetails linda = User
        .builder()
        .username("linda")
        .password(this.passwordEncoder.encode("linda12345"))
        .roles(Role.ADMIN.name())
        .build();
    UserDetails tom = User
        .builder()
        .username("tom")
        .password(this.passwordEncoder.encode("tom12345"))
        .roles(Role.ADMINTRANEE.name())
        .build();

    return new InMemoryUserDetailsManager(annasmith, linda,tom);
  }

  // @Bean
  // @Override
  // protected AuthenticationManager authenticationManager() throws Exception {
  // return super.authenticationManager();
  // }
}
