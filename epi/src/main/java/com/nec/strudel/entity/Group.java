/*******************************************************************************
 *   Copyright 2015 Junichi Tatemura
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
 *******************************************************************************/
package com.nec.strudel.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Group {
	/**
	 * The name of the entity
	 */
	String name() default "";
	/**
	 * The name of the entity group if this
	 * entity is the root.
	 * @return "" if this entity is not
	 * the root entity
	 */
	String group() default "";
	/**
	 * The class of the parent entity if this
	 * entity is not the root.
	 * @return Object.class if this class is the root.
	 */
	Class<?> parent() default Object.class;
}