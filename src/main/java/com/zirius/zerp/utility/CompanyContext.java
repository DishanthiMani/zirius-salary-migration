package com.zirius.zerp.utility;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * Holds companyId in ThreadLocal and also acts as a request filter
 * to automatically set/clear it for every HTTP request.
 */
@Component
public class CompanyContext implements Filter {

    private static final ThreadLocal<Integer> currentCompanyId = new ThreadLocal<>();

    public static void setCompanyId(Integer companyId) {
        currentCompanyId.set(companyId);
    }

    public static Integer getCompanyId() {
        return currentCompanyId.get();
    }

    public static void clear() {
        currentCompanyId.remove();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;

            // Read from header (or parameter)
            String companyIdHeader = httpRequest.getHeader("X-Company-Id");
            if (companyIdHeader == null) {
                companyIdHeader = httpRequest.getParameter("ziriusPlussCompanyId");
            }

            if (companyIdHeader != null) {
                setCompanyId(Integer.valueOf(companyIdHeader));
            }

            // Continue request
            chain.doFilter(request, response);

        } finally {
            clear(); // cleanup after request
        }
    }
}
