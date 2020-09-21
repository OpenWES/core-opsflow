package com.openwes.opsflow;

import com.openwes.opsflow.action.LoginAction;
import com.openwes.statemachine.Action;
import com.openwes.statemachine.Actor;
import com.openwes.statemachine.ActorLoader;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class BaseWorkingSessionLoader implements ActorLoader<Action> {

    @Override
    public Actor load(Action action) {
        if(action instanceof LoginAction){
            return new NoneCacheActor();
        }
        return null;
    }

}
