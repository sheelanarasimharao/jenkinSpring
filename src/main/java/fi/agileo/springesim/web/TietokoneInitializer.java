package fi.agileo.springesim.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * Spring-sovelluksen alustaminen
 
 Springissä alustusluokka toteuttaa AbstractAnnotationConfigDispatcherServletInitializer hakemistossa src/main/java 
 Yrittää korvata kaikki web.xml:n konfiguraatiot!
  Servlet 3.0 Container aloittamisen aikana tämä ladataan ja alustetaan ja servlet-ympäristö kutsuu sitä.
 */
public class TietokoneInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Spring Servlet Java-pohjaisen Konfiguraatioluokan lataaminen
		return new Class[] { SpringServletConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
