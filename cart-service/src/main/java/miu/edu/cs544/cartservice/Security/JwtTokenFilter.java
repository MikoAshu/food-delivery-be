package miu.edu.cs544.cartservice.Security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// We should use OncePerRequestFilter since we are doing a database call, there is no point in doing this more than once
public class JwtTokenFilter extends OncePerRequestFilter {

  private JwtTokenProvider jwtTokenProvider;

  public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    String token = jwtTokenProvider.resolveToken(httpServletRequest);
    try {
      if (token != null ) {
        jwtTokenProvider.validateToken(token);
      }else throw new Exception();
    } catch (Exception ex) {
      SecurityContextHolder.clearContext();
      httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
      return;
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

}
