package guice.tomcat;

import java.util.Date;
import java.util.List;

public interface MyService {
    void save(Date ts);
    List<MyEntity> findAll();
}
