package edu.cursor.u21.handler;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vk on 3/22/17.
 */
@Component
public class LogoutSuccessHandlerForLoginPage implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication)
                                throws IOException, ServletException {
            if (authentication != null && authentication.getDetails() != null)
                httpServletRequest.getSession().invalidate();

            String url = httpServletRequest.getContextPath()+"/views";
            httpServletResponse.setStatus(HttpStatus.OK.value());
            httpServletResponse.sendRedirect(url);
    }
}
