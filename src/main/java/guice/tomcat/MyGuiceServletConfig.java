package guice.tomcat;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * taken from https://github.com/google/guice/wiki/ServletModule
 */
public class MyGuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/*").with(MyServlet.class);
                bind(MyService.class).to(MyServiceImpl.class);

                install(new JpaPersistModule("myJpaUnit"));
                filter("/*").through(PersistFilter.class);
            }
        });
    }
}

