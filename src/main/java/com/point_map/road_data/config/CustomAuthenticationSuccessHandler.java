package com.point_map.road_data.config;

import com.point_map.road_data.models.User;
import com.point_map.road_data.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    SimpleUrlAuthenticationSuccessHandler workerSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/worker");
    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/admin");
    SimpleUrlAuthenticationSuccessHandler bossSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/boss");
    SimpleUrlAuthenticationSuccessHandler brigadierSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/brigadier");
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException{
//        super.onAuthenticationSuccess(request, response, authentication);

//        User user = (User) authentication.getPrincipal();
//        System.out.println(user.getUsername());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            String authorityName = grantedAuthority.getAuthority();
            switch (authorityName){
                case "ADMIN":
                    this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                    return;
                case "WORKER":
                    this.workerSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                    return;
                case "BOSS":
                    this.bossSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                    return;
                case "BRIGADIER":
                    this.brigadierSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                    return;

            }

        }
    }
}
