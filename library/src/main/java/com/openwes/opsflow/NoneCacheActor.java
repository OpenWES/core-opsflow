package com.openwes.opsflow;

import com.openwes.statemachine.Actor;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class NoneCacheActor extends Actor {

    public NoneCacheActor(String id, String currentState) {
        super(id, currentState);
    }

    @Override
    public boolean isCached() {
        return false;
    }

}
