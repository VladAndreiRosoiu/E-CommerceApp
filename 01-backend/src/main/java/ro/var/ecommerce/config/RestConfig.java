package ro.var.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import ro.var.ecommerce.models.Product;
import ro.var.ecommerce.models.ProductCategory;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public RestConfig(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST };
        config
                .getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
        config
                .getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));

        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration configuration){

        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntityType : entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

        Class [] domainTypes = entityClasses.toArray(new Class[0]);
        configuration.exposeIdsFor(domainTypes);

    }
}
