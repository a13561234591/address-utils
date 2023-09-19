package com.payegis.config;



import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2017/7/19.
 */
public class LocalCache {



    public static final Map<String, String> locationCache = new ConcurrentHashMap<>();

    public static final ServiceProperties serviceProperties = new ServiceProperties();





    private LocalCache() {

    }
}
