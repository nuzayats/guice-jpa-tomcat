package guice.tomcat;

import java.util.List;

public interface MyService {
    void save(MyEntity e);
    List<MyEntity> findAll();
}
