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
package jp.co.opentone.bsol.linkbinder.dao;


import jp.co.opentone.bsol.framework.core.dao.GenericDao;
import jp.co.opentone.bsol.linkbinder.dto.CorresponHierarchy;

/**
 * correspon_hierarchy を操作するDao.
 *
 * @author opentone
 *
 */
public interface CorresponHierarchyDao extends GenericDao<CorresponHierarchy> {

    /**
     * 親コレポン文書ID、返信元宛先ユーザーIDでコレポン文書階層を検索し
     * ヒット数を取得する.
     * @param parentCorresponId 親コレポン文書ID
     * @param replyAddressUserId 返信元宛先ユーザーID
     * @return ヒット数
     */
    int countByParentCorresponIdReplyAddressUserId(
        Long parentCorresponId, Long replyAddressUserId);
}
