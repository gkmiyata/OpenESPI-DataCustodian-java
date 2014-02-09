/*
 * Copyright 2013, 2014 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.datacustodian.service.impl;

import org.energyos.espi.common.domain.BatchList;
import org.energyos.espi.common.domain.Subscription;
import org.energyos.espi.common.domain.UsagePoint;
import org.energyos.espi.common.service.UsagePointService;
import org.energyos.espi.datacustodian.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UsagePointService usagePointService;

    public BatchList updatedResources(Subscription subscription) {
        List<UsagePoint> usagePoints = usagePointService.findAllUpdatedFor(subscription);

        BatchList batchList = new BatchList();

        for(UsagePoint usagePoint: usagePoints) {
            batchList.getResources().add(usagePoint.getSelfHref());
        }

        return batchList;
    }

    public void setUsagePointService(UsagePointService usagePointService) {
        this.usagePointService = usagePointService;
    }
}
