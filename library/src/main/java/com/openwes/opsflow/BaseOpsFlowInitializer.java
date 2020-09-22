package com.openwes.opsflow;

import com.openwes.core.interfaces.Initializer;
import com.openwes.opsflow.action.ActionName;
import com.openwes.opsflow.transition.ScanBadgeProcessor;
import com.openwes.statemachine.StateFlow;
import com.openwes.statemachine.StateFlowManager;
import com.openwes.statemachine.Transition;
import com.typesafe.config.Config;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class BaseOpsFlowInitializer implements Initializer {

    @Override
    public String configKey() {
        return "opsflow";
    }

    @Override
    public void onStart(Config config) throws Exception {
        StateFlowManager.instance()
                //Workflow of NoneCacheActor
                .register(StateFlow.create(NoneCacheActor.class.getName())
                        .addTransition(Transition.fromAny()
                                .setAction(ActionName.LOGIN)
                                .setTo("LOGIN")
                                .setProcessor(ScanBadgeProcessor.class)
                                .setDestroyOnComplete(true)))
                //Workflow of BaseWorkingSession
                .register(StateFlow.create(BaseWorkingSession.class.getName())
                        .addTransition(Transition.from("LOGIN")
                                .setTo("SCAN_EQUIPMENT")
                                .setAction(ActionName.SCAN_EQUIPMENT))
                        .addTransition(Transition.from("SCAN_EQUIPMENT")
                                .setTo("SCAN_CONTAINER")
                                .setAction(ActionName.SCAN_CONTAINER))
                        .addTransition(Transition.from("SCAN_EQUIPMENT")
                                .setTo("SCAN_CONTAINER")
                                .setAction(ActionName.SLOTTING_CONTAINER)));
    }

    @Override
    public void onShutdow(Config config) throws Exception {
        StateFlowManager.instance().shutdown();
    }

}
