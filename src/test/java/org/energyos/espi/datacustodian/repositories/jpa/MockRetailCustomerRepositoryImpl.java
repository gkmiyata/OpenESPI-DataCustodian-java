/*
 * Copyright 2013 EnergyOS ESPI
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

package org.energyos.espi.datacustodian.repositories.jpa;

import org.energyos.espi.datacustodian.models.RetailCustomer;
import org.energyos.espi.datacustodian.repositories.RetailCustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MockRetailCustomerRepositoryImpl implements RetailCustomerRepository {

    protected EntityManager em;

    @Override
    public List<RetailCustomer> findAll() {
        ArrayList<RetailCustomer> customers = new ArrayList<RetailCustomer>();

        RetailCustomer alanTuring = new RetailCustomer();
        alanTuring.setFirstName("Alan");
        alanTuring.setLastName("Turing");

        customers.add(alanTuring);

        return customers;
    }

    @Override
    public boolean persist(RetailCustomer customer) {
        return true;
    }
}
