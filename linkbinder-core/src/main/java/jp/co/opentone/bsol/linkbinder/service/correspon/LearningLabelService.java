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
package jp.co.opentone.bsol.linkbinder.service.correspon;

import jp.co.opentone.bsol.framework.core.service.IService;
import jp.co.opentone.bsol.framework.core.service.ServiceAbortException;
import jp.co.opentone.bsol.linkbinder.dto.Correspon;
import jp.co.opentone.bsol.linkbinder.dto.CorresponLearningLabel;
import jp.co.opentone.bsol.linkbinder.dto.LearningLabel;

import java.util.List;

/**
 * このサービスでは学習用ラベルに関する処理を提供する.
 * @author opentone
 */
public interface LearningLabelService extends IService {

    /**
     * 現在のプロジェクトに登録済みのすべての学習用ラベルを返す.
     * @return 検索結果
     * @throws ServiceAbortException 検索に失敗
     */
    List<LearningLabel> findAll() throws ServiceAbortException;

    /**
     * 利用されている学習用ラベルを返す.
     * @return 検索結果
     */
    List<LearningLabel> findExsistLabel();

    /**
     *
     * @param corresponId
     * @return
     */
    List<CorresponLearningLabel> findByCorresponId(Long corresponId);

    /**
     * 指定された文書に設定されたラベルをすべて削除する.
     * @param correspon 文書
     * @throws ServiceAbortException 削除に失敗
     */
    void clearAllLearningLabels(Correspon correspon) throws ServiceAbortException;

    /**
     * 学習用文書のラベルを保存する.
     * @param correspon 学習用文書
     * @throws ServiceAbortException 保存に失敗
     */
    void saveLearningLabels(Correspon correspon) throws ServiceAbortException;
}
