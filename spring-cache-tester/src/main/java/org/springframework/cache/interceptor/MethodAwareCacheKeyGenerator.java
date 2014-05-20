
package org.springframework.cache.interceptor;

import java.lang.reflect.Method;

public class MethodAwareCacheKeyGenerator extends SimpleKeyGenerator {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        int hashCode = 31;
        // target instance
        hashCode = hashCode * 31 + target.hashCode();
        // method name
        hashCode = hashCode * 31 + method.getName().hashCode();

        for (Object param : params) {
            // param value
            hashCode = 31 * hashCode + (param == null ? 31 : param.hashCode());
            // param type
            hashCode = 31 * hashCode
                    + (param == null ? 31 : param.getClass().hashCode());
        }
        return Integer.valueOf(hashCode);
    }

}
