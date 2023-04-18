package ma.enset.hospitalapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Annotation Spring qui declare une classe comme source de configuration de spring
@EnableWebSecurity //Utiliser pour activer la configuration de la sécurité web de l'application
@EnableMethodSecurity(prePostEnabled = true)//Utiliser pour activer la securite des methodes,
                                            //Permet d'activer les authorisations
public class SecurityConfig {
    @Autowired//injection des dépendances
    private PasswordEncoder passwordEncoder;


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
    //permet de stocker des utilisateurs dans la mémoire et non la BD
    //utiliser dans les applications de petite taille ou les tests
        return new InMemoryUserDetailsManager(
                //creation de 2 comptes user et un compte admin
                User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
    //SecurityFilterChain : ensemble de filtre qui sert à proteger les ressources de l'app contre les attacks

        //pour ecraser la page du login par defaut avec une autre personnalisée
        httpSecurity
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/",true)//redirection vers / apres login
                .permitAll();

        //enregistrer le dernier compte authentifié
        httpSecurity.rememberMe();

        //pour donner l'acces au bootstrap sans authentification
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll();

        //pour autoriser les urls avec /user/ aux users seulement et les urls avec /admin/ aux admins seulement
        //httpSecurity.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER");
        //httpSecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");

        //toutes les requettes necessitent une authentification
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();

        //redirection vers la page /notAuthorized si l'utilisateur n'a pas le droit à cette action
        httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");

        return httpSecurity.build();
    }
}