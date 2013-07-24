package com.jjw.messagingsystem.security.googleappengine;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.security.util.MessagingSystemRole;

/**
 * With the help of the SpringSource blog, specifically @author Luke Fisher
 * 
 * @author jjwyse
 */
public class GoogleAppEngineAuthenticationFilter extends GenericFilterBean implements MessagingSystemConstantsIF
{
    private AuthenticationDetailsSource ads = new WebAuthenticationDetailsSource();
    private AuthenticationManager authenticationManager;
    private AuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    /**
     * Filters HTTP requests depending on whether the user has authenticated and/or registered with us yet
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null)
        {
            // User isn't authenticated. Check if there is a Google Accounts user
            User googleUser = UserServiceFactory.getUserService().getCurrentUser();

            if (googleUser != null)
            {
                // User has returned after authenticating through GAE. Need to authenticate to Spring Security.
                PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(googleUser, null);
                token.setDetails(ads.buildDetails(request));

                try
                {
                    authentication = authenticationManager.authenticate(token);

                    // Setup the security context
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    // Send new users to the registration page.
                    if (authentication.getAuthorities().contains(MessagingSystemRole.NEW_USER))
                    {
                        ((HttpServletResponse) response).sendRedirect("/" + VIEW_REGISTER);
                        return;
                    }
                }
                catch (AuthenticationException e)
                {
                    // Authentication information was rejected by the authentication manager
                    failureHandler.onAuthenticationFailure((HttpServletRequest) request,
                            (HttpServletResponse) response, e);
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }

    /**
     * Set our authentication manager for our messaging system
     * 
     * @param authenticationManager
     */
    public void setAuthenticationManager(AuthenticationManager authenticationManager)
    {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Set our failure handler for our messaging system
     * 
     * @param failureHandler
     */
    public void setFailureHandler(AuthenticationFailureHandler failureHandler)
    {
        this.failureHandler = failureHandler;
    }
}