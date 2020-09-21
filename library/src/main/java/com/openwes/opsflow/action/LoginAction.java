package com.openwes.opsflow.action;

import com.openwes.statemachine.Action;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class LoginAction extends Action {

    public LoginAction(String actorId) {
        super(actorId, ActionName.LOGIN);
    }

}
