package com.youai.river.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Qingjiang Li on 2017/8/29.
 */
public class BaseUtils {

    private static Map<String, List<String>> propertyNameMap = new ConcurrentHashMap();
    private static Map<String, Map<String, String>> propertyNameCaseMap = new ConcurrentHashMap();
    private static BeanUtilsBean beanUtilsBean;

    public BaseUtils() {
    }

    public static BeanUtilsBean getBeanUtilsInstance() {
        if(beanUtilsBean == null) {
            beanUtilsBean = new BeanUtilsBean2();
            beanUtilsBean.getConvertUtils().register(false, false, 0);
        }

        return beanUtilsBean;
    }

    public static final List<String> getPropertyNames(Object obj) {
        if(obj instanceof Map) {
            ArrayList var9 = new ArrayList();
            var9.addAll(((Map)obj).keySet());
            return var9;
        } else {
            String className = obj.getClass().getName();
            List propNames = (List)propertyNameMap.get(className);
            if(propNames != null) {
                return propNames;
            } else {
                ArrayList var10 = new ArrayList();
                PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
                PropertyDescriptor[] arr$ = pds;
                int len$ = pds.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    PropertyDescriptor pd = arr$[i$];
                    String propName = pd.getName();
                    if(!StringUtils.equalsIgnoreCase(propName, "class")) {
                        var10.add(propName);
                    }
                }

                propertyNameMap.put(className, var10);
                return var10;
            }
        }
    }

    public static Map<String, String> getPropertyNamesCaseMap(Object obj) {
        HashMap propNameMap1;
        if(obj instanceof Map) {
            List className1 = getPropertyNames(obj);
            propNameMap1 = new HashMap();
            Iterator propNames1 = className1.iterator();

            while(propNames1.hasNext()) {
                String i$1 = (String)propNames1.next();
                propNameMap1.put(i$1.toLowerCase(), i$1);
            }

            return propNameMap1;
        } else {
            String className = obj.getClass().getName();
            Map propNameMap = (Map)propertyNameCaseMap.get(className);
            if(propNameMap != null) {
                return propNameMap;
            } else {
                propNameMap1 = new HashMap();
                List propNames = getPropertyNames(obj);
                Iterator i$ = propNames.iterator();

                while(i$.hasNext()) {
                    String propName = (String)i$.next();
                    propNameMap1.put(propName.toLowerCase(), propName);
                }

                propertyNameCaseMap.put(className, propNameMap1);
                return propNameMap1;
            }
        }
    }

    public static void setProperty(Object obj, String propName, Object propValue) {
        try {
            getBeanUtilsInstance().getPropertyUtils().setProperty(obj, propName, propValue);
        } catch (Exception var4) {
            throw new RuntimeException("setProperty exception with propName " + propName + " and propValue" + propValue, var4);
        }
    }

    public static void setCaseProperty(Object obj, String propName, Object propValue) {
        try {
            String e = StringUtils.defaultString((String)getPropertyNamesCaseMap(obj).get(propName.toLowerCase()), propName);
            getBeanUtilsInstance().setProperty(obj, e, propValue);
        } catch (Exception var4) {
            throw new RuntimeException("setCaseProperty exception with propName " + propName + " and propValue" + propValue, var4);
        }
    }

    public static Object getProperty(Object obj, String propName) {
        try {
            return getBeanUtilsInstance().getPropertyUtils().getProperty(obj, propName);
        } catch (Exception var3) {
            throw new RuntimeException("getProperty exception with propName " + propName, var3);
        }
    }

}
