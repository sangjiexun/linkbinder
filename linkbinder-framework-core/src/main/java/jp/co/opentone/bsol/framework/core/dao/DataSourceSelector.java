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
package jp.co.opentone.bsol.framework.core.dao;

import java.io.Serializable;

import javax.sql.DataSource;

/**
 * 実行コンテキストによって、利用するデータソースを 切り替える.
 * @author opentone
 */
public interface DataSourceSelector extends Serializable {

    /**
     * 実行コンテキストに合わせたデータソースを選択して返す.
     * @return データソース
     */
    DataSource select();
}
