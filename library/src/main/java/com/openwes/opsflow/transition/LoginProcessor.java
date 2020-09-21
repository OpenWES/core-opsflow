package com.openwes.opsflow.transition;

import com.openwes.opsflow.message.LoginMessage;
import com.openwes.statemachine.ActorProps;
import com.openwes.statemachine.Processor;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class LoginProcessor extends Processor<LoginMessage> {

    @Override
    public boolean onProcess(ActorProps props, LoginMessage data) {
        return true;
    }

}
