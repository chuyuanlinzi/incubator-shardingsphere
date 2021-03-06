/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.transaction;

import io.shardingsphere.core.constant.DatabaseType;
import io.shardingsphere.transaction.core.TransactionType;
import io.shardingsphere.transaction.core.fixture.ShardingTransactionManagerFixture;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public final class ShardingTransactionManagerEngineTest {
    
    @Test
    public void assertGetEngine() {
        assertThat(ShardingTransactionManagerEngine.getTransactionManager(TransactionType.XA), instanceOf(ShardingTransactionManagerFixture.class));
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void assertRegisterTransactionResource() {
        Runnable caller = mock(Runnable.class);
        ShardingTransactionManagerFixture shardingTransactionManager = (ShardingTransactionManagerFixture) ShardingTransactionManagerEngine.getTransactionManager(TransactionType.XA);
        shardingTransactionManager.setCaller(caller);
        ShardingTransactionManagerEngine.init(DatabaseType.H2, mock(Map.class));
        verify(caller).run();
    }
}
