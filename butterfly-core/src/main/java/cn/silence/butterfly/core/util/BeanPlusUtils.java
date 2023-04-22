package cn.silence.butterfly.core.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/04/21 23:37:10
 */
public class BeanPlusUtils {

    private BeanPlusUtils() {
    }

    /**
     * 将的bean转为map, key:fieldName, value:fieldValue  <br/> <br/>
     * 如果bean的属性中还有bean，则key为以前一个beanName.fieldName
     *
     * @param bean bean
     * @return map
     */
    public static Map<String, Object> bean2Map(Object bean) {
        return doBean2Map(null, bean);
    }

    /**
     * 将list中的bean转为map, key:fieldName, value:fieldValue  <br/> </br/>
     * 如果bean的属性中还有bean，则key为以前一个beanName.fieldName
     *
     * @param beans beans
     * @return maps
     */
    public static List<Map<String, Object>> beans2Maps(Collection<?> beans) {
        return beans.stream().map(BeanPlusUtils::bean2Map).collect(Collectors.toList());
    }

    /**
     * 获取bean的属性描述器
     *
     * @param clazz bean类型
     * @return PropertyDescriptor
     */
    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) {
        try {
            return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            throw new IllegalArgumentException("获取BeanInfo异常!", e);
        }
    }

    /**
     * 将bean转为map,递归转换bean中非常用基本类型
     *
     * @param prefix map中key字段的前缀，即map中key为 prefix + "." + fieldName
     * @param bean   bean
     * @return map
     */
    private static Map<String, Object> doBean2Map(String prefix, Object bean) {
        if (bean == null) {
            return null;
        }
        Class<?> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<>(32);
        // 遍历属性描述器
        for (PropertyDescriptor descriptor : getPropertyDescriptors(type)) {
            String propertyName = descriptor.getName();
            if ("class".equals(propertyName)) {
                continue;
            }
            Object result = ReflectionUtils.invokeMethod(descriptor.getReadMethod(), bean);
            if (result == null) {
                continue;
            }
            // 如果非基本类型
            if (!isSimpleValue(result)) {
                if (ObjectUtils.isCollection(result)) {
                    returnMap.put(parsePropertyName(prefix, propertyName), beans2Maps((Collection) result));
                    continue;
                }
                if (ObjectUtils.isMap(result)) {
                    returnMap.put(parsePropertyName(prefix, propertyName), result);
                    continue;
                }
                // 递归转换属性Bean
                returnMap.putAll(doBean2Map(propertyName, result));
                continue;
            }
            returnMap.put(parsePropertyName(prefix, propertyName), result);
        }
        return returnMap;
    }

    private static String parsePropertyName(String prefix, String propertyName) {
        return prefix != null ? prefix + "." + propertyName : propertyName;
    }

    /**
     * 判断对象是否为简单基本类型
     *
     * @param res object
     * @return true or false
     */
    public static boolean isSimpleValue(Object res) {
        return ObjectUtils.isWrapperOrPrimitive(res) || ObjectUtils.isEnum(res) || ObjectUtils.isDate(res);
    }
}
