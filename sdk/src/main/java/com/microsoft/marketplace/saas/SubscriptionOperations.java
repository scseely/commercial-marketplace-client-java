// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.microsoft.marketplace.saas;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Patch;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.microsoft.marketplace.saas.models.Operation;
import com.microsoft.marketplace.saas.models.OperationList;
import com.microsoft.marketplace.saas.models.UpdateOperation;
import java.util.UUID;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in SubscriptionOperations. */
public final class SubscriptionOperations {
    /** The proxy service used to perform REST calls. */
    private final SubscriptionOperationsService service;

    /** The service client containing this operation class. */
    private final SaaSAPI client;

    /**
     * Initializes an instance of SubscriptionOperations.
     *
     * @param client the instance of the service client containing this operation class.
     */
    SubscriptionOperations(SaaSAPI client) {
        this.service = RestProxy.create(SubscriptionOperationsService.class, client.getHttpPipeline());
        this.client = client;
    }

    /**
     * The interface defining all the services for SaaSAPISubscriptionOperations to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "SaaSAPISubscriptionO")
    private interface SubscriptionOperationsService {
        @Get("/saas/subscriptions/{subscriptionId}/operations")
        @ExpectedResponses({200, 400, 403, 404, 500})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<OperationList>> listOperations(
                @HostParam("$host") String host,
                @PathParam("subscriptionId") UUID subscriptionId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("x-ms-requestid") UUID requestId,
                @HeaderParam("x-ms-correlationid") UUID correlationId);

        @Get("/saas/subscriptions/{subscriptionId}/operations/{operationId}")
        @ExpectedResponses({200, 400, 403, 404, 500})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Operation>> getOperationStatus(
                @HostParam("$host") String host,
                @PathParam("subscriptionId") UUID subscriptionId,
                @PathParam("operationId") UUID operationId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("x-ms-requestid") UUID requestId,
                @HeaderParam("x-ms-correlationid") UUID correlationId);

        @Patch("/saas/subscriptions/{subscriptionId}/operations/{operationId}")
        @ExpectedResponses({200, 400, 403, 404, 409, 500})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> updateOperationStatus(
                @HostParam("$host") String host,
                @PathParam("subscriptionId") UUID subscriptionId,
                @PathParam("operationId") UUID operationId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("x-ms-requestid") UUID requestId,
                @HeaderParam("x-ms-correlationid") UUID correlationId,
                @BodyParam("application/json") UpdateOperation body);
    }

    /**
     * Lists the outstanding operations for the current publisher.
     *
     * @param subscriptionId The subscriptionId parameter.
     * @param requestId A unique string value for tracking the request from the client, preferably a GUID. If this value
     *     isn't provided, one will be generated and provided in the response headers.
     * @param correlationId A unique string value for operation on the client. This parameter correlates all events from
     *     client operation with events on the server side. If this value isn't provided, one will be generated and
     *     provided in the response headers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<OperationList>> listOperationsWithResponseAsync(
            UUID subscriptionId, UUID requestId, UUID correlationId) {
        return service.listOperations(
                this.client.getHost(), subscriptionId, this.client.getApiVersion(), requestId, correlationId);
    }

    /**
     * Lists the outstanding operations for the current publisher.
     *
     * @param subscriptionId The subscriptionId parameter.
     * @param requestId A unique string value for tracking the request from the client, preferably a GUID. If this value
     *     isn't provided, one will be generated and provided in the response headers.
     * @param correlationId A unique string value for operation on the client. This parameter correlates all events from
     *     client operation with events on the server side. If this value isn't provided, one will be generated and
     *     provided in the response headers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<OperationList> listOperationsAsync(UUID subscriptionId, UUID requestId, UUID correlationId) {
        return listOperationsWithResponseAsync(subscriptionId, requestId, correlationId)
                .flatMap(
                        (Response<OperationList> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Enables the publisher to track the status of the specified triggered async operation (such as Subscribe,
     * Unsubscribe, ChangePlan, or ChangeQuantity).
     *
     * @param subscriptionId The subscriptionId parameter.
     * @param operationId The operationId parameter.
     * @param requestId A unique string value for tracking the request from the client, preferably a GUID. If this value
     *     isn't provided, one will be generated and provided in the response headers.
     * @param correlationId A unique string value for operation on the client. This parameter correlates all events from
     *     client operation with events on the server side. If this value isn't provided, one will be generated and
     *     provided in the response headers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Operation>> getOperationStatusWithResponseAsync(
            UUID subscriptionId, UUID operationId, UUID requestId, UUID correlationId) {
        return service.getOperationStatus(
                this.client.getHost(),
                subscriptionId,
                operationId,
                this.client.getApiVersion(),
                requestId,
                correlationId);
    }

    /**
     * Enables the publisher to track the status of the specified triggered async operation (such as Subscribe,
     * Unsubscribe, ChangePlan, or ChangeQuantity).
     *
     * @param subscriptionId The subscriptionId parameter.
     * @param operationId The operationId parameter.
     * @param requestId A unique string value for tracking the request from the client, preferably a GUID. If this value
     *     isn't provided, one will be generated and provided in the response headers.
     * @param correlationId A unique string value for operation on the client. This parameter correlates all events from
     *     client operation with events on the server side. If this value isn't provided, one will be generated and
     *     provided in the response headers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Operation> getOperationStatusAsync(
            UUID subscriptionId, UUID operationId, UUID requestId, UUID correlationId) {
        return getOperationStatusWithResponseAsync(subscriptionId, operationId, requestId, correlationId)
                .flatMap(
                        (Response<Operation> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
    }

    /**
     * Update the status of an operation to indicate success or failure with the provided values.
     *
     * @param subscriptionId The subscriptionId parameter.
     * @param operationId The operationId parameter.
     * @param body The body parameter.
     * @param requestId A unique string value for tracking the request from the client, preferably a GUID. If this value
     *     isn't provided, one will be generated and provided in the response headers.
     * @param correlationId A unique string value for operation on the client. This parameter correlates all events from
     *     client operation with events on the server side. If this value isn't provided, one will be generated and
     *     provided in the response headers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> updateOperationStatusWithResponseAsync(
            UUID subscriptionId, UUID operationId, UpdateOperation body, UUID requestId, UUID correlationId) {
        return service.updateOperationStatus(
                this.client.getHost(),
                subscriptionId,
                operationId,
                this.client.getApiVersion(),
                requestId,
                correlationId,
                body);
    }

    /**
     * Update the status of an operation to indicate success or failure with the provided values.
     *
     * @param subscriptionId The subscriptionId parameter.
     * @param operationId The operationId parameter.
     * @param body The body parameter.
     * @param requestId A unique string value for tracking the request from the client, preferably a GUID. If this value
     *     isn't provided, one will be generated and provided in the response headers.
     * @param correlationId A unique string value for operation on the client. This parameter correlates all events from
     *     client operation with events on the server side. If this value isn't provided, one will be generated and
     *     provided in the response headers.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> updateOperationStatusAsync(
            UUID subscriptionId, UUID operationId, UpdateOperation body, UUID requestId, UUID correlationId) {
        return updateOperationStatusWithResponseAsync(subscriptionId, operationId, body, requestId, correlationId)
                .flatMap((Response<Void> res) -> Mono.empty());
    }
}
