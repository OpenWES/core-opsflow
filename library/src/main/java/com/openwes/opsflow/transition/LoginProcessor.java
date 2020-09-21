package com.openwes.opsflow.transition;

import com.openwes.opsflow.message.LoginMessage;
import com.openwes.statemachine.ActorProps;
import com.openwes.statemachine.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class LoginProcessor extends Processor<LoginMessage> {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginProcessor.class);

    @Override
    public boolean onProcess(ActorProps props, LoginMessage data) {
        LOGGER.info("LoginMessage {} ", data);
        return true;
    }

}
