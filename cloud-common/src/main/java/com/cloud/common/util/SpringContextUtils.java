package com.cloud.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static BeanDefinitionRegistry beanDefinitionRegistry;

    public SpringContextUtils() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = applicationContext;
        beanDefinitionRegistry = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void registerBean(String beanId, String className) throws Exception {
        if (beanDefinitionRegistry == null) {
            throw new Exception("beanDefinitionRegistry is null");
        } else {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(className);
            BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            beanDefinitionRegistry.registerBeanDefinition(beanId, beanDefinition);
        }
    }

    public static void unregisterBean(String beanId) throws Exception {
        if (beanDefinitionRegistry == null) {
            throw new Exception("beanDefinitionRegistry is null");
        } else {
            beanDefinitionRegistry.removeBeanDefinition(beanId);
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext() != null ? getApplicationContext().getBean(name) : null;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext() != null ? getApplicationContext().getBean(clazz) : null;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext() != null ? getApplicationContext().getBean(name, clazz) : null;
    }
}
