
package org.springframework.cache.interceptor;

import java.lang.reflect.Method;

public class MethodAwareCacheKeyGenerator extends DefaultKeyGenerator {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        Object hash = super.generate(target, method, params);
        Integer hashCode = hash.hashCode();
        hashCode = 31 * hashCode + method.hashCode();
        return hashCode;
    }

}
