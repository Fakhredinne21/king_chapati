package fakhredinne.king_chapati.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor

public class JwtAuthentificationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(
          @NonNull HttpServletRequest request,
          @NonNull HttpServletResponse response,
          @NonNull  FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader=request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if(authHeader==null||!authHeader.startsWith("Bearer ")){ // jwt token = bearer token
            filterChain.doFilter(request,response);
            return;     //stop execution
        }
        jwt=authHeader.substring(7); //token extraction from authorization header
        userEmail=  jwtService.extractUsername(jwt);//extract userEmail using jwt service
    }
}
