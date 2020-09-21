package com.openwes.opsflow;

import com.openwes.statemachine.Actor;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class NoneCacheActor extends Actor {

    @Override
    public boolean isCached() {
        return false;
    }

}
