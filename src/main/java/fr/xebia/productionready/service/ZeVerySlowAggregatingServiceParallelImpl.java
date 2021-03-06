/*
 * Copyright 2008-2010 Xebia and the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.xebia.productionready.service;

import fr.xebia.productionready.backend.anotherveryslowservice.AnotherVerySlowService;
import fr.xebia.productionready.backend.zeveryslowservice.ZeVerySlowService;

import java.util.concurrent.ExecutorService;

public class ZeVerySlowAggregatingServiceParallelImpl implements ZeVerySlowAggregatingService {

    private AnotherVerySlowService anotherVerySlowService;
    private ZeVerySlowService zeVerySlowService;

    @Override
    public String doWork(final long id) {

        String result = zeVerySlowService.find(id);
        result += "\t";
        result += anotherVerySlowService.find(id);

        return result;
    }

    public void setAnotherVerySlowService(AnotherVerySlowService anotherVerySlowService) {
        this.anotherVerySlowService = anotherVerySlowService;
    }

    public void setZeVerySlowService(ZeVerySlowService zeVerySlowService) {
        this.zeVerySlowService = zeVerySlowService;
    }

    public void setAnotherVerySlowServiceExecutor(ExecutorService anotherVerySlowServiceExecutor) {
        // TODO
    }

    public void setZeVerySlowServiceExecutor(ExecutorService zeVerySlowServiceExecutor) {
        // TODO
    }
}
