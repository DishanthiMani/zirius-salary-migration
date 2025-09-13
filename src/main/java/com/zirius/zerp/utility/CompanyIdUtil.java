package com.zirius.zerp.utility;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class CompanyIdUtil {

    public static void applyCompanyId(EntityManager entityManager) {
        Integer companyId = CompanyContext.getCompanyId();
        if (companyId == null) return;

        Session session = entityManager.unwrap(Session.class);

        session.doWork(connection -> {
            try (var stmt = connection.createStatement()) {
                stmt.execute("SET app.current_company_id = " + companyId);
            }
        });
    }
}
