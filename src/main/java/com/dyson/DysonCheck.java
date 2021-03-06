/*
 * (c) Copyright 2018 Yiwei Gao. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dyson;

import com.codahale.metrics.health.HealthCheck;
import com.dyson.persistence.PersonDb;

public final class DysonCheck extends HealthCheck {
    private final String version;

    public DysonCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        if (PersonDb.getCount() == 0) {
            return Result.unhealthy("No persons in DB! Version: " + this.version);
        }
        return Result.healthy("OK with version: " + this.version + ". Persons count: " + PersonDb.getCount());
    }
}
