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

import java.util.Date;
import java.util.EnumSet;

import jp.co.opentone.bsol.framework.core.dao.Entity;
import jp.co.opentone.bsol.framework.core.util.CloneUtil;
import jp.co.opentone.bsol.linkbinder.dto.code.CorresponTypeAdmittee;


/**
 * テーブル [project_correspon_type] の1レコードを表すDto.
 *
 * @author opentone
 *
 */
public class ProjectCorresponType extends AbstractDto implements Entity {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 2110010062898990195L;

    /**
     * Id.
     * <p>
     * [project_correspon_type.id]
     * </p>
     */
    private Long id;

    /**
     * Project.
     * <p>
     * [project_correspon_type.project_id]
     * </p>
     */
    private String projectId;

    /**
     * Correspon type.
     * <p>
     * [project_correspon_type.correspon_type_id]
     * </p>
     */
    private Long corresponTypeId;

    /**
     * この CorresponType を利用可能なユーザー種別.
     * <p>
     * [v_project_correspon_type.correspon_access_control_flags]
     * </p>
     */
    private EnumSet<CorresponTypeAdmittee> corresponAccessControlFlags;

    /**
     * Created by.
     * <p>
     * </p>
     */
    private User createdBy;

    /**
     * Created at.
     * <p>
     * [project_correspon_type.created_at]
     * </p>
     */
    private Date createdAt;

    /**
     * Updated by.
     * <p>
     * </p>
     */
    private User updatedBy;

    /**
     * Updated at.
     * <p>
     * [project_correspon_type.updated_at]
     * </p>
     */
    private Date updatedAt;

    /**
     * Delete no.
     * <p>
     * [project_correspon_type.delete_no]
     * </p>
     */
    private Long deleteNo;

    /**
     * 空のインスタンスを生成する.
     */
    public ProjectCorresponType() {
    }

    /**
     * id の値を返す.
     * <p>
     * [project_correspon_type.id]
     * </p>
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * id の値を設定する.
     * <p>
     * [project_correspon_type.id]
     * </p>
     * @param id
     *            id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * projectId の値を返す.
     * <p>
     * [project_correspon_type.project_id]
     * </p>
     * @return projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * projectId の値を設定する.
     * <p>
     * [project_correspon_type.project_id]
     * </p>
     * @param projectId projectId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * corresponTypeId の値を返す.
     * <p>
     * [project_correspon_type.correspon_type_id]
     * </p>
     * @return corresponTypeId
     */
    public Long getCorresponTypeId() {
        return corresponTypeId;
    }

    /**
     * corresponTypeId の値を設定する.
     * <p>
     * [project_correspon_type.correspon_type_id]
     * </p>
     * @param corresponTypeId corresponTypeId
     */
    public void setCorresponTypeId(Long corresponTypeId) {
        this.corresponTypeId = corresponTypeId;
    }

    /**
     * 作成者を返す.
     * <p>
     * </p>
     * @return createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * 作成者を設定する.
     * <p>
     * </p>
     * @param createdBy 作成者
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * createdAt の値を返す.
     * <p>
     * [project_correspon_type.created_at]
     * </p>
     * @return createdAt
     */
    public Date getCreatedAt() {
        return CloneUtil.cloneDate(createdAt);
    }

    /**
     * createdAt の値を設定する.
     * <p>
     * [project_correspon_type.created_at]
     * </p>
     * @param createdAt createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = CloneUtil.cloneDate(createdAt);
    }

    /**
     * 更新者を返す.
     * <p>
     * </p>
     * @return updatedBy
     */
    public User getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 更新者を設定する.
     * <p>
     * </p>
     * @param updatedBy 更新者
     */
    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * updatedAt の値を返す.
     * <p>
     * [project_correspon_type.updated_at]
     * </p>
     * @return updatedAt
     */
    public Date getUpdatedAt() {
        return CloneUtil.cloneDate(updatedAt);
    }

    /**
     * updatedAt の値を設定する.
     * <p>
     * [project_correspon_type.updated_at]
     * </p>
     * @param updatedAt updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = CloneUtil.cloneDate(updatedAt);
    }

    /**
     * deleteNo の値を返す.
     * <p>
     * [project_correspon_type.delete_no]
     * </p>
     * @return deleteNo
     */
    public Long getDeleteNo() {
        return deleteNo;
    }

    /**
     * deleteNo の値を設定する.
     * <p>
     * [project_correspon_type.delete_no]
     * </p>
     * @param deleteNo deleteNo
     */
    public void setDeleteNo(Long deleteNo) {
        this.deleteNo = deleteNo;
    }

    /**
     * この CorresponType を利用可能なユーザー種別を取得する.
     * @return 利用可能なユーザー種別 (CorresponTypeAdmittee) 列挙子の値を OR した 0 から
     *  255 の整数
     */
    public Integer getCorresponAccessControlFlags() {
        if (corresponAccessControlFlags == null) {
            return 0;
        }
        return CorresponTypeAdmittee.getIntValueFromEnumSet(
                    corresponAccessControlFlags);
    }

    /**
     * この CorresponType を利用可能なユーザー種別を設定する.
     * @param value 利用可能なユーザー種別 (CorresponTypeAdmittee) 列挙子の値を OR した
     *  0 から 255 の整数
     */
    public void setCorresponAccessControlFlags(Integer value) {
        if (value == null) {
            this.corresponAccessControlFlags = null;
        } else {
            this.corresponAccessControlFlags =
                CorresponTypeAdmittee.getEnumSetFromDbValue(value);
        }
    }
}
