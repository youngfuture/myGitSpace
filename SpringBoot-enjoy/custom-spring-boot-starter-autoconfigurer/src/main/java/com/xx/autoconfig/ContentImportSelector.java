package com.xx.autoconfig;


import com.xx.autoconfig.config.CoreContentConfiguration;
import com.xx.autoconfig.config.SimpleContentConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class ContentImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Class<?> annotationType = EnableContentService.class;
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(
                annotationType.getName(), false));
        String policy = attributes.getString("policy");
        if ("core".equals(policy)) {
            return new String[] { CoreContentConfiguration.class.getName() };
        } else {
            return new String[] { SimpleContentConfiguration.class.getName() };
        }
    }
}
