package registro.registroacademico.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase para el registro de recursos
 * @author AndresJ90
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application{
   
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addResourcesClasses(resources);
        return resources;
    }
    
    private void addResourcesClasses(Set<Class<?>> resources){
        resources.add(CoordinadorResource.class);
    }
}
