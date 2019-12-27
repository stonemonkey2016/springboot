package com.light.springboot.configure;

import com.google.common.base.Strings;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @descrption:
 * @author: bubbles
 */
public class UTF8Condition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String encoding = System.getProperty("file.encoding");
        if (!Strings.isNullOrEmpty(encoding)) {
            return "utf-8".equalsIgnoreCase(encoding);
        }
        return false;
    }
}
