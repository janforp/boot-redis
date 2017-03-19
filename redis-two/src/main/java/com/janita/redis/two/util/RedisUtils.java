package com.janita.redis.two.util;

import java.util.Map;
import java.util.Set;

/**
 * Created by Janita on 2017-03-18 21:32
 */
public class RedisUtils {
    /**
     * 删除某个key
     * @param template
     * @param key
     */
    public static void deleteKey(RedisUtilsTemplate template,String key){
        template.delete(key);
    }

    /**
     * 删除集合中所有的key
     * @param template
     * @param keys
     */
    public static void deleteKeys(RedisUtilsTemplate template, Set<String> keys){
        template.delete(keys);
    }

    /**
     * 为某个key设置过期时间
     * @param template
     * @param key
     * @param seconds
     */
    public static boolean setExpire(RedisUtilsTemplate template,String key,long seconds){
        return template.expire(key,seconds);
    }

    /**
     * 查询key的剩余时间
     * 以秒为单位,返回给定key的有效时间长，如果是-1则表示永远有效,当 key 不存在时，返回 -2 。
     * @param template
     * @param key
     * @return
     */
    public static long getExpireSeconds(RedisUtilsTemplate template,String key){
        return template.ttl(key);
    }

    /**
     * 取消key的过期时间,使其永久有效
     * @param template
     * @param key
     * @return
     */
    public static boolean persistKey(RedisUtilsTemplate template,String key){
        return template.persist(key);
    }

    /**
     * 判断key是否存在
     * @param template
     * @param key
     * @return
     */
    public static boolean isKeyExists(RedisUtilsTemplate template,String key){
        return template.isKeyExists(key);
    }

    /**
     * 回去key中存储数据的类型
     * @param template
     * @param key
     * @return
     */
    public static String getTypeOfKey(RedisUtilsTemplate template,String key){
        return template.type(key).code();
    }

    /**
     * 获取key的string值
     * @param template
     * @param key
     * @return
     */
    public static String getStringOfKey(RedisUtilsTemplate template ,String key){
        return template.get(key);
    }

    /**
     * 设置key的string值
     * @param template
     * @param key
     * @param value
     */
    public static void setKeyOfString(RedisUtilsTemplate template,String key,String value){
        template.set(key,value);
    }

    /**
     * 获取key的object值
     * @param template
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getObjectOfKey(RedisUtilsTemplate template,String key){
        return template.getObj(key);
    }

    /**
     * 为key设置object值
     * @param template
     * @param key
     * @param value
     * @param <T>
     */
    public static <T> void setKeyOfObject(RedisUtilsTemplate template,String key,T value){
        template.set(key,value);
    }

    /**
     * 把key的旧值替换为new string,返回old string
     * @param template
     * @param key
     * @param value
     * @return
     */
    public static String getSetString(RedisUtilsTemplate template,String key,String value){
        return template.getSetString(key,value);
    }

    /**
     * 把key的旧值替换为new object,返回旧old object
     * @param template
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public static <T> T getSetObject(RedisUtilsTemplate template,String key,T value){
        return template.getSetObject(key,value);
    }

    /**
     * 为多个key设置他们的string value
     * @param template
     * @param pairs
     */
    public static void setManyKeysString(RedisUtilsTemplate template,Map<String,String> pairs){
        template.mSetString(pairs);
    }

    /**
     * 获取多个key的值
     * 返回map
     * @param template
     * @param keys
     * @return
     */
    public static Map<String,String> getManyKeysString(RedisUtilsTemplate template, Set<String> keys){
        return template.mget(keys);
    }

    /**
     * 为多个key设置他们的object value
     * @param template
     * @param pairs
     * @param <T>
     */
    public static <T> void setManyKeysObject(RedisUtilsTemplate template,Map<String,T> pairs){
        template.mSetObject(pairs);
    }

    /**
     * 为多个key获取他们的object value
     * @param template
     * @param keys
     * @param <T>
     * @return
     */
    public static <T> Map<String,T> getManyKeysObject(RedisUtilsTemplate template,Set<String> keys){
        return template.mgetObj(keys);
    }

    /**
     * 为key的string值的后面添加appendStr
     *
     * 若在key存入对象时,对此key调用此方法,则会导致
     * value无法反序列号为对象
     * 此方法只能用于key存入的是string
     *
     * @param template
     * @param key
     * @param appendStr
     */
    public static Long append(RedisUtilsTemplate template,String key,String appendStr){
        return template.appendToStringValue(key,appendStr);
    }

    /****************string start***************/

    /****************hash start***************/



    /****************hash end***************/
}
