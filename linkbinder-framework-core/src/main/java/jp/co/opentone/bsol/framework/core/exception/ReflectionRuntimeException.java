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
package jp.co.opentone.bsol.framework.core.exception;

import jp.co.opentone.bsol.framework.core.message.Message;

/**
 * Java Reflection APIで発生した例外をラップするクラス.
 * @author opentone
 */
public class ReflectionRuntimeException extends RuntimeException {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 933836674058517921L;

    /**
     * ユーザーに通知する生成済のメッセージ.
     */
    private Message createdMessage;

    /**
     * メッセージを持たない例外を生成する.
     */
    public ReflectionRuntimeException() {
        super();
    }

    /**
     * メッセージを持たない例外を生成する.
     * @param cause
     *            原因となった例外
     */
    public ReflectionRuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * メッセージが設定された例外を生成する.
     * @param message
     *            メッセージ
     */
    public ReflectionRuntimeException(String message) {
        super(message);
    }

    /**
     * メッセージと原因となった例外が設定された例外を生成する.
     * @param message
     *            メッセージ
     * @param cause
     *            原因となった例外
     */
    public ReflectionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 原因となった例外が設定された例外を生成する.
     * @param createdMesage ユーザーに通知する生成済のメッセージ
     * @param cause
     *            原因となった例外
     */
    public ReflectionRuntimeException(Message createdMesage, Throwable cause) {
        super(cause);
        this.createdMessage = createdMesage;
    }

    /**
     * @return 生成済メッセージ
     */
    public Message getCreatedMessage() {
        return createdMessage;
    }
}
