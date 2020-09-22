package com.openwes.opsflow.transition;

import com.openwes.opsflow.message.ScanBadgeMessage;
import com.openwes.statemachine.ActorProps;
import com.openwes.statemachine.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class ScanBadgeProcessor extends Processor<ScanBadgeMessage> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScanBadgeProcessor.class);

    @Override
    public boolean onProcess(ActorProps props, ScanBadgeMessage data) {
        LOGGER.info("LoginMessage {} ", data);
        return true;
    }

}
