package in.co.srdt.unifsupport.controller;

import in.co.srdt.unifsupport.config.AccessToken;
import in.co.srdt.unifsupport.utils.ApplicationGateway;
import in.co.srdt.unifsupport.utils.UnifTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
@EnableOAuth2Sso
public class HomeController extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UnifTheme unifTheme;

    @Autowired
    private ApplicationGateway appGateway;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");
    }

    @RequestMapping(value = {"/","/home"})
    public String loadSupport(Authentication authentication, Model model){

        System.out.println("Current Time : "+System.currentTimeMillis());

        final String themeColor = unifTheme.getAppTheme();
        final String theme = "/css/w3-theme-" + unifTheme.getAppTheme() + ".css";
        final String hoverColor = "w3-border-bottom w3-bar-item w3-button w3-hover-" + unifTheme.getAppTheme() + " icon-change";
        final String hoverColorFN = "w3-hover-" + unifTheme.getAppTheme();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());

        model.addAttribute("theme", theme);
        model.addAttribute("hoverColor", hoverColor);
        model.addAttribute("hoverColorFN", hoverColorFN);
        model.addAttribute("themeColor", themeColor);
        return "home";
    }
}
