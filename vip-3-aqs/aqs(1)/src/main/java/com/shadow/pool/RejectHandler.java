package com.shadow.pool;

/**
 * @Author 钢牌讲师--子路
 **/
public interface RejectHandler {
    void handler(CustomQueue queue, CustomTask task) throws InterruptedException;
}
