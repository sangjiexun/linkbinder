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
package jp.co.opentone.bsol.linkbinder.dto.code;

import jp.co.opentone.bsol.framework.core.dto.Code;
import jp.co.opentone.bsol.framework.core.elasticsearch.ElasticsearchSearchOption;

/**
 * 全文検索演算子.
 *
 * @author opentone
 *
 */
public enum FullTextSearchOperator implements Code {

    /**
     * AND検索.
     */
    AND(1, "すべてを含む"),
    /**
     * OR検索.
     */
    OR(2, "いずれかを含む");

    /**
     * このコードの値.
     */
    private Integer value;
    /**
     * このコードの名前を表すラベル.
     */
    private String label;

    /**
     * 値とラベルを指定してインスタンス化する.
     * @param value
     *            値
     * @param label
     *            ラベル
     */
    private FullTextSearchOperator(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    /*
     * (non-Javadoc)
     * @see jp.co.opentone.bsol.framework.extension.ibatis.EnumValue#getValue()
     */
    public Integer getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     * @see jp.co.opentone.bsol.linkbinder.dto.code.Code#getLabel()
     */
    public String getLabel() {
        return label;
    }

    public ElasticsearchSearchOption.Operator toElasticsearchOperator() {
        return AND == this
                ? ElasticsearchSearchOption.Operator.AND
                : ElasticsearchSearchOption.Operator.OR;
    }
}
