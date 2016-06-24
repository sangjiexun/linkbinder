/*
 * Copyright 2016 OPEN TONE Inc.
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
package jp.co.opentone.bsol.framework.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jp.co.opentone.bsol.framework.core.aop.MethodTraceInterceptor;

/**
 * {@link MethodTraceInterceptor}によるトレースログ出力の
 * 対象外となる要素を表すアノテーション.
 * @author opentone
 */
@Documented
@Target({
    ElementType.TYPE,
    ElementType.FIELD,
    ElementType.CONSTRUCTOR,
    ElementType.METHOD,
    ElementType.PARAMETER
    })
@Retention(RetentionPolicy.RUNTIME)
public @interface SuppressTrace {
    String alternative() default "*****";
}
