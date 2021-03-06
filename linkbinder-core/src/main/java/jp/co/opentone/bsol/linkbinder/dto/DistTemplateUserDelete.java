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
package jp.co.opentone.bsol.linkbinder.dto;

/**
 * Distributionテンプレートユーザー削除時のDtoInterface.
 *
 * @author opentone
 *
 */
public interface DistTemplateUserDelete extends DistTemplateCommon {

    /**
     * 更新キーにするdistTemplateGroupIdの値を設定する.
     * @param distTemplateGroupId
     *            Distributionテンプレート活動単位ID
     */
    void setDistTemplateGroupId(Long distTemplateGroupId);

    /**
     * 登録するdistTemplateGroupIdの値を取得する.
     * @return Distributionテンプレート活動単位ID
     */
    Long getDistTemplateGroupId();
}
