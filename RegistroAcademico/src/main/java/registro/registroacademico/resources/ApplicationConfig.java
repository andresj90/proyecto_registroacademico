/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registro.registroacademico.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
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
