package com.syscomz.springsecurity.security;

import com.syscomz.springsecurity.auth.ApplicationUserService;
import com.syscomz.springsecurity.jwt.JwtConfig;
import com.syscomz.springsecurity.jwt.JwtTokenVerifier;
import com.syscomz.springsecurity.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Enable @PreAuthorize annotation
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService, JwtConfig jwtConfig, SecretKey secretKey) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }


    // JWT Authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //  CSRF (Cross Site Request Forgery) - the action of forging a copy or imitation of a document, signature, banknote, or work of art.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT is stateless
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))// JWT username and password authentication filter, the authenticationManager() method comes from the extension of WebSecurityConfigurerAdapter
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class) // JWT token verifier filter it is used every time when we send request to the server
                .authorizeRequests()    // authorize request
                .antMatchers("/", "/index", "/css/*", "/js/*") // if you find some of these URLs
                .permitAll()  //  permit them all (white list them all)
                .antMatchers("/api/**") // permit API
                .hasRole(ApplicationUserRole.STUDENT.name())
                .anyRequest()
                .authenticated();
    }

    // Form-Based Authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // The validation passed from top to bottom, so it is important the order of the permissions
//        // If we have something that blocks us in the roles above we will not go to the bottom line that is allowing us to access the endpoint
//        // Note (in two words): the order of the Ant Matchers does matter
//
//        http
//                .csrf().disable() //  CSRF (Cross Site Request Forgery) - the action of forging a copy or imitation of a document, signature, banknote, or work of art.
////                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Enable XSRF-TOKEN, in the header of the request must add X-XSRF-TOKEN and the token value from the get value
//                // withHttpOnlyFalse() means that the cookie will be inaccessible for the outside of the world, this means if some javascript tries to access the token it won't
////                .and()
//                .authorizeRequests()    // authorize request
////                .antMatchers("/", "/index", "/css/*", "/js/*", "/api/**") // if you find some of these URLs
//                .antMatchers("/", "/index", "/css/*", "/js/*", "/api/**") // if you find some of these URLs
//                .permitAll()            //  permit them all (white list them all)
//                .antMatchers("/api/**") // give permissions for this endpoint to the roles (STUDENT) below
//                .hasRole(ApplicationUserRole.STUDENT.name()) // gives access to the /api/** endpoint for all students
//                // we can use antMatchers or annotations to manage the authority permissions
////                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())                  // Set authority - for many authorities we must use hasAnyAuthority
////                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())                    // Set authority - for many authorities we must use hasAnyAuthority
////                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())                     // Set authority - for many authorities we must use hasAnyAuthority
////                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())    // Set authority - for many authorities we must use hasAnyAuthority
//                .anyRequest()           // any request
//                .authenticated()        // must be authenticated (client must specify username and password
//                .and()                  // and
////                .httpBasic();         // enable basic authentication: should use http authentication (Basic64 username:password)
//                .formLogin()           // enable form base authentication
//                .loginPage("/login")   // is used to set up custom login page
//                .permitAll()         // permit login page
//                .defaultSuccessUrl("/courses", Boolean.TRUE) // load default page when the authentication is successful
//                .passwordParameter("password") // corespondents to the form password in login page
//                .usernameParameter("username") // corespondents to the form username in login page
//                .and()
//                .rememberMe()       // default to 2 weeks
//                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) // setup validity time of the token
//                .key("somethingverysecured") // this key is used for md5 hashing
//                .rememberMeParameter("remember-me") // corespondents to the form in login page
//                .and()
//                .logout() // customize logout
//                .logoutUrl("/logout")           // logout path
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // if CSRF is enabled this should delete this line
//                .clearAuthentication(Boolean.TRUE)
//                .invalidateHttpSession(Boolean.TRUE)
//                .deleteCookies("remember-me", "JSESSIONID") // specify the cookies that must be deleted
//                .logoutSuccessUrl("/login"); // after successfully logout go to login page
//    }


    // Used for database configuration authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    // Used for database configuration authentication
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder); // set password encoder
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }


//    // UserDetailsService is responsible how we retrieve users from database
//    // InMemoryUserDetailsManager is responsible how we retrieve users from memory
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        // annaSmithUser
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin123"))
//                .authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
////                .roles(ApplicationUserRole.ADMIN.name()) // ROLE_STUDENT internal treatment of STUDENT role
//                .build();
//
//        // lindaUser
//        UserDetails admintrainee = User.builder()
//                .username("admintrainee")
//                .password(passwordEncoder.encode("admintrainee123"))
//                .authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities())
////                .roles(ApplicationUserRole.ADMINTRAINEE.name()) // ROLE_ADMINTRAINEE internal treatment of STUDENT role
//                .build();
//
//        // tomUser
//        UserDetails student = User.builder()
//                .username("bdostumski")
//                .password(passwordEncoder.encode("bdostumski123"))
//                .authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
////                .roles(ApplicationUserRole.STUDENT.name()) // ROLE_STUDENT internal treatment of STUDENT role
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, admintrainee, student); // use in memory database
//    }
}
