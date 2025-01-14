/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.reference;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openmrs.reference.page.HomePage;

import static org.junit.Assert.assertTrue;

@Ignore
public class LoginTest extends ReferenceApplicationTestBase {
    private HomePage homePage;

    @Test
    @Category(org.openmrs.reference.groups.BuildTests.class)
    public void verifyModulesAvailableOnHomePage() throws Exception {
        homePage = new HomePage(page);
        assertPage(homePage);
        assertTrue(homePage.isFindAPatientAppPresent());
        assertTrue(homePage.isActiveVisitsAppPresent());
        assertTrue(homePage.isAppointmentSchedulingAppPresent());
        assertTrue(homePage.isCaptureVitalsAppPresent());
        assertTrue(homePage.isRegisterPatientCustomizedForRefAppPresent());
        assertTrue(homePage.isDataManagementAppPresent());
        assertTrue(homePage.isConfigureMetadataAppPresent());
        assertTrue(homePage.isSystemAdministrationAppPresent());
    }

    @Test
    public void verifyClerkModulesAvailableOnHomePage() throws Exception {
        goToLoginPage().loginAsClerk();
        homePage = new HomePage(page);
        assertPage(homePage);
        assertTrue(homePage.isActiveVisitsAppPresent());
        assertTrue(homePage.isAppointmentSchedulingAppPresent());
        assertTrue(homePage.isRegisterPatientCustomizedForRefAppPresent());
    }

    @Test
    public void verifyDoctorModulesAvailableOnHomePage() throws Exception {
        goToLoginPage().loginAsDoctor();
        homePage = new HomePage(page);
        assertPage(homePage);
        assertTrue(homePage.isFindAPatientAppPresent());
        assertTrue(homePage.isActiveVisitsAppPresent());
        assertTrue(homePage.isAppointmentSchedulingAppPresent());
    }

    @Test
    public void verifyNurseModulesAvailableOnHomePage() throws Exception {
        goToLoginPage().loginAsNurse();
        homePage = new HomePage(page);
        assertPage(homePage);
        assertTrue(homePage.isFindAPatientAppPresent());
        assertTrue(homePage.isActiveVisitsAppPresent());
        assertTrue(homePage.isAppointmentSchedulingAppPresent());
        assertTrue(homePage.isCaptureVitalsAppPresent());
    }

    @Test
    public void verifySysadminModulesAvailableOnHomePage() throws Exception {
        goToLoginPage().loginAsSysadmin();
        homePage = new HomePage(page);
        assertPage(homePage);
        assertTrue(homePage.isAppointmentSchedulingAppPresent());
        assertTrue(homePage.isSystemAdministrationAppPresent());
    }

}
