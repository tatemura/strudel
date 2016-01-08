/*******************************************************************************
 * Copyright 2015 Junichi Tatemura
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
 *******************************************************************************/
package com.nec.strudel.tkvs.store;

import java.util.Properties;

import com.nec.strudel.target.FactoryClass;
import com.nec.strudel.target.Target;
import com.nec.strudel.target.TargetLifecycle;
import com.nec.strudel.tkvs.TransactionalDB;

@FactoryClass(TkvDBCreator.class)
public interface TransactionalStore {

	Target<TransactionalDB> create(String dbName, Properties props);

	TargetLifecycle lifecycle(String dbName, Properties props);

}
