package com.owliance.owlink.service;

import com.owliance.owlink.framework.common.OwlinkContext;
import com.owliance.owlink.framework.service.BaseService;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Classe de base pour tester un service.
 *
 * @param <T> l'implémentation du service à tester.
 */
@ContextConfiguration("classpath*:/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTestJUnit<T extends BaseService> {

    @Mock
    private HttpServletRequest request;

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    private DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean;

    /**
     * Permet de faire l'initialisation globale de la classe de test.
     * Pas d'utilisation de @BeforeClass car demande d'être static (solution existe en JUnit5 mais pas en JUnit4).
     *
     * Cette fonction ne peut remplacer le setUp de la classe de test (@Before à faire dans la classe qui va hériter de cette classe).
     *
     * @param service le service à initialiser
     * @throws Exception
     */
    public void setUp(T service) throws Exception {
        MockitoAnnotations.initMocks(this);
        service.setRequest(request);
        service.setMessageSource(messageSource);
        service.setMapper((Mapper) dozerBeanMapperFactoryBean.getObject());
        OwlinkContext owlinkcontext = new OwlinkContext(request);
        when(request.getAttribute(anyString())).thenReturn(owlinkcontext);
    }

    public void setUpWithoutMapper(T service) throws Exception {
        MockitoAnnotations.initMocks(this);
        service.setRequest(request);
        service.setMessageSource(messageSource);
        OwlinkContext owlinkcontext = new OwlinkContext(request);
        when(request.getAttribute(anyString())).thenReturn(owlinkcontext);
    }
}
