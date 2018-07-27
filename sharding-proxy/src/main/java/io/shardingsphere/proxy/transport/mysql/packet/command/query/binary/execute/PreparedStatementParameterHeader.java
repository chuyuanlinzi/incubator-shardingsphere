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

package io.shardingsphere.proxy.transport.mysql.packet.command.query.binary.execute;

import io.shardingsphere.proxy.transport.mysql.constant.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * Prepared statement parameter header.
 *
 * @author zhangyonglun
 */
@AllArgsConstructor
@Getter
public class PreparedStatementParameterHeader implements Serializable {
    
    private static final long serialVersionUID = -672589695838350689L;
    
    private final ColumnType columnType;
    
    private final int unsignedFlag;
    
}