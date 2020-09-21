package com.openwes.opsflow.api;

import com.openwes.core.utils.Validate;
import com.openwes.opsflow.NoneCacheActor;
import com.openwes.opsflow.action.LoginAction;
import com.openwes.opsflow.message.LoginMessage;
import com.openwes.statemachine.ActionEndHandler;
import com.openwes.statemachine.ActorProps;
import com.openwes.statemachine.Failure;
import com.openwes.statemachine.StateFlowManager;
import com.openwes.web.HttpHandler;
import com.openwes.web.ResponseMessage;
import io.netty.handler.codec.http.HttpResponseStatus;

/**
 *
 * @author xuanloc0511@gmail.com
 */
public class LoginHandler extends HttpHandler {

    @Override
    public void handle() throws Exception {
        LoginMessage loginMessage = bodyAsObject(LoginMessage.class);
        String actorId = loginMessage.getBarcode();
        if (Validate.isEmpty(loginMessage.getBarcode())) {
            actorId = loginMessage.getUsername();
        }
        StateFlowManager.workflow(NoneCacheActor.class.getName())
                .execute(new LoginAction(actorId, loginMessage)
                        .setEndHandler(new ActionEndHandler() {
                            @Override
                            public void onCompleted(String actorId, ActorProps props, Object input) {
                                response(ResponseMessage.success(HttpResponseStatus.OK.code(), "OK"));
                            }

                            @Override
                            public void onFailure(String actorId, ActorProps props, Failure input) {
                                response(ResponseMessage.error(input.getCode(), input.getReason()));
                            }

                            @Override
                            public void onError(Throwable t) {
                                response(ResponseMessage.error(HttpResponseStatus.INTERNAL_SERVER_ERROR.code(), t.getMessage()));
                            }
                        }));
    }

}
