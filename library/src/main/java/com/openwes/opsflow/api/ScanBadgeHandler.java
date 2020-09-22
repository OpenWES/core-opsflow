package com.openwes.opsflow.api;

import com.openwes.opsflow.NoneCacheActor;
import com.openwes.opsflow.action.LoginAction;
import com.openwes.opsflow.message.ScanBadgeMessage;
import com.openwes.statemachine.ActionEndHandler;
import com.openwes.statemachine.ActorProps;
import com.openwes.statemachine.Failure;
import com.openwes.statemachine.StateFlowManager;
import com.openwes.web.HttpHandler;
import com.openwes.web.ResponseMessage;
import com.openwes.web.annotation.Api;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.http.HttpMethod;

/**
 *
 * @author xuanloc0511@gmail.com
 */
@Api(method = HttpMethod.POST, path = "/v1/scan/badge")
public class ScanBadgeHandler extends HttpHandler {

    @Override
    public void handle() throws Exception {
        ScanBadgeMessage message = bodyAsObject(ScanBadgeMessage.class);
        StateFlowManager.workflow(NoneCacheActor.class.getName())
                .execute(new LoginAction(message.getData(), message)
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
