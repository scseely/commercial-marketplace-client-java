// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.microsoft.marketplace.saas.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The SubscriptionPlans model. */
@Fluent
public final class SubscriptionPlans {
    /*
     * The plans property.
     */
    @JsonProperty(value = "plans")
    private List<Plan> plans;

    /**
     * Get the plans property: The plans property.
     *
     * @return the plans value.
     */
    public List<Plan> getPlans() {
        return this.plans;
    }

    /**
     * Set the plans property: The plans property.
     *
     * @param plans the plans value to set.
     * @return the SubscriptionPlans object itself.
     */
    public SubscriptionPlans setPlans(List<Plan> plans) {
        this.plans = plans;
        return this;
    }
}
