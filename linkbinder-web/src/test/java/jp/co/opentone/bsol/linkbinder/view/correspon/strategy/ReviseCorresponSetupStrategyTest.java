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
package jp.co.opentone.bsol.linkbinder.view.correspon.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.co.opentone.bsol.linkbinder.attachment.AttachmentInfo;
import jp.co.opentone.bsol.linkbinder.attachment.CopiedAttachmentInfo;
import jp.co.opentone.bsol.linkbinder.dto.AddressCorresponGroup;
import jp.co.opentone.bsol.linkbinder.dto.AddressUser;
import jp.co.opentone.bsol.linkbinder.dto.Attachment;
import jp.co.opentone.bsol.linkbinder.dto.Correspon;
import jp.co.opentone.bsol.linkbinder.dto.CorresponGroup;
import jp.co.opentone.bsol.linkbinder.dto.CorresponType;
import jp.co.opentone.bsol.linkbinder.dto.UpdateMode;
import jp.co.opentone.bsol.linkbinder.dto.User;
import jp.co.opentone.bsol.linkbinder.dto.code.AddressType;
import jp.co.opentone.bsol.linkbinder.dto.code.AddressUserType;
import jp.co.opentone.bsol.linkbinder.dto.code.CorresponStatus;
import jp.co.opentone.bsol.linkbinder.dto.code.ReplyRequired;
import jp.co.opentone.bsol.linkbinder.dto.code.WorkflowStatus;
import jp.co.opentone.bsol.linkbinder.view.correspon.util.CorresponEditMode;


/**
 * {@link ReviseCorresponSetupStrategy}のテストケース.
 * @author opentone
 */
public class ReviseCorresponSetupStrategyTest extends AbstractCorresponSetupStrategyTestCase {

    private Correspon correspon;

    public ReviseCorresponSetupStrategyTest() {
        super(CorresponEditMode.REVISE);
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        correspon = setupCorrespon();
        MockCorresponService.RET_FIND = correspon;
        page.setId(correspon.getId());
    }

    @Override
    @After
    public void teardown() {
        MockCorresponService.RET_FIND = null;
        page.getAttachments().clear();

        super.teardown();
    }
    private Correspon setupCorrespon() {
        Correspon c = new Correspon();

        c.setId(10L);
        c.setProjectId(currentProject.getProjectId());
        c.setCorresponNo("YOC:IT-00001-001");
        c.setParentCorresponId(20L);
        c.setParentCorresponNo("YOC:IT-00001");
        c.setPreviousRevCorresponId(30L);
        c.setPreviousRevCorresponNo("YOC:IT-00000");

        CorresponGroup from = new CorresponGroup();
        from.setId(100L);
        from.setName("YOC:IT");
        c.setFromCorresponGroup(from);

        c.setCorresponStatus(CorresponStatus.CANCELED);
        c.setWorkflowStatus(WorkflowStatus.ISSUED);

        setUpAddress(c);

        CorresponType corresponType = new CorresponType();
        corresponType.setId(1L);
        corresponType.setProjectCorresponTypeId(11L);
        corresponType.setName("Query");
        c.setCorresponType(corresponType);

        c.setSubject("This is test.");
        c.setBody("<p>This is first line.</p><p>This is second line.</p>");

        c.setReplyRequired(ReplyRequired.YES);
        c.setDeadlineForReply(new GregorianCalendar(2009, 7, 14).getTime());

        setUpAttachment(c);
        setUpCustomField(c);

        return c;
    }

    private void setUpAddress(Correspon c) {
        AddressCorresponGroup ag;
        CorresponGroup g;
        List<AddressUser> users;
        AddressUser au;
        User u;

        List<AddressCorresponGroup> addresses = new ArrayList<AddressCorresponGroup>();
        ag = new AddressCorresponGroup();
        ag.setId(1L);
        ag.setMode(UpdateMode.NONE);
        ag.setAddressType(AddressType.TO);
        g = new CorresponGroup();
        g.setId(11L);
        g.setName("Group1");
        ag.setCorresponGroup(g);

        users = new ArrayList<AddressUser>();
        au = new AddressUser();
        au.setId(111L);
        au.setAddressUserType(AddressUserType.ATTENTION);
        au.setAddressCorresponGroupId(ag.getId());
        u = new User();
        u.setEmpNo("00001");
        u.setNameE("User1");
        au.setUser(u);
        users.add(au);

        ag.setUsers(users);
        addresses.add(ag);

        ag = new AddressCorresponGroup();
        ag.setId(2L);
        ag.setMode(UpdateMode.NONE);
        ag.setAddressType(AddressType.CC);
        g = new CorresponGroup();
        g.setId(22L);
        g.setName("Group2");
        ag.setCorresponGroup(g);

        users = new ArrayList<AddressUser>();
        au = new AddressUser();
        au.setId(222L);
        au.setAddressUserType(AddressUserType.NORMAL_USER);
        au.setAddressCorresponGroupId(ag.getId());
        u = new User();
        u.setEmpNo("00002");
        u.setNameE("User2");
        au.setUser(u);
        ag.setReplyCount(1L);  // 返信済を表す
        users.add(au);

        ag.setUsers(users);
        addresses.add(ag);


        c.setAddressCorresponGroups(addresses);
    }

    private void setUpAttachment(Correspon c) {
        c.setFile1Id(1L);
        c.setFile1FileId("11111");
        c.setFile1FileName("file1");

        c.setFile2Id(2L);
        c.setFile2FileId("22222");
        c.setFile2FileName("file2");

        c.setFile3Id(3L);
        c.setFile3FileId("33333");
        c.setFile3FileName("file3");

        c.setFile4Id(4L);
        c.setFile4FileId("44444");
        c.setFile4FileName("file4");

        c.setFile5Id(5L);
        c.setFile5FileId("55555");
        c.setFile5FileName("file5");
    }

    private void setUpCustomField(Correspon c) {
        c.setCustomField1Id(10L);
        c.setCustomField1Label("label1");
        c.setCustomField1Value("value1");
        c.setCustomField2Id(20L);
        c.setCustomField2Label("label2");
        c.setCustomField2Value("value2");
        c.setCustomField3Id(30L);
        c.setCustomField3Label("label3");
        c.setCustomField3Value("value3");
        c.setCustomField4Id(40L);
        c.setCustomField4Label("label4");
        c.setCustomField4Value("value4");
        c.setCustomField5Id(50L);
        c.setCustomField5Label("label5");
        c.setCustomField5Value("value5");
        c.setCustomField6Id(60L);
        c.setCustomField6Label("label6");
        c.setCustomField6Value("value6");
        c.setCustomField7Id(70L);
        c.setCustomField7Label("label7");
        c.setCustomField7Value("value7");
        c.setCustomField8Id(80L);
        c.setCustomField8Label("label8");
        c.setCustomField8Value("value8");
        c.setCustomField9Id(90L);
        c.setCustomField9Label("label9");
        c.setCustomField9Value("value9");
        c.setCustomField10Id(100L);
        c.setCustomField10Label("label10");
        c.setCustomField10Value("value10");
    }

    /**
     * {@link ReviseCorresponSetupStrategy#setup()}の検証.
     * page#idに指定したコレポン文書の改訂文書が生成できていることを検証する.
     * @throws Exception
     */
    @Test
    public void testSetup() throws Exception {


        //  ユーザーのデフォルト活動単位が設定されている場合、
        //  fromはこれになる
        CorresponGroup from = new CorresponGroup();
        from.setId(1000L);
        from.setName("defaultGroup");
        currentProjectUser.setDefaultCorresponGroup(from);

        strategy.setup();

        Correspon actual = page.getCorrespon();
        assertNotNull(actual);

        assertEquals(null, actual.getId());
        assertEquals(null, actual.getCorresponNo());

        //  返信文書の改訂もあり得るため、返信情報は引き継がなければならない
        assertEquals(correspon.getParentCorresponId(), actual.getParentCorresponId());
        assertEquals(correspon.getParentCorresponNo(), actual.getParentCorresponNo());

        //  改訂元コレポン文書情報として、ID・コレポン文書番号がセットされている
        assertEquals(correspon.getId(), actual.getPreviousRevCorresponId());
        assertEquals(correspon.getCorresponNo(), actual.getPreviousRevCorresponNo());

        // ユーザーのデフォルト活動単位
        assertEquals(from, actual.getFromCorresponGroup());

        //  改訂元の文書種別はCanceledなので引き継がない
        assertEquals(CorresponStatus.OPEN, actual.getCorresponStatus());

        assertEquals(correspon.getCorresponType(), actual.getCorresponType());

        assertEquals(correspon.getAddressCorresponGroups(), actual.getAddressCorresponGroups());
        assertEquals(correspon.getAddressCorresponGroups().size(), actual.getAddressCorresponGroups().size());
        //  編集モードは全てNEW
        for (AddressCorresponGroup ag : actual.getAddressCorresponGroups()) {
            assertEquals(UpdateMode.NEW, ag.getMode());
            if (ag.getUsers() != null) {
                for (AddressUser au : ag.getUsers()) {
                    assertTrue(au.getPersonInCharges() == null || au.getPersonInCharges().isEmpty());
                    assertTrue(ag.getReplyCount() == null || ag.getReplyCount() == 0L);
                }
            }
        }

        assertEquals(correspon.getSubject(), actual.getSubject());
        assertEquals(correspon.getBody(), actual.getBody());
        assertEquals(correspon.getReplyRequired(), actual.getReplyRequired());
        assertEquals(correspon.getDeadlineForReply(), actual.getDeadlineForReply());

        //  attachments
        assertEquals(correspon.getAttachments().size(), actual.getAttachments().size());

        //  custom fields
        assertEquals(correspon.getCustomField1Value(), actual.getCustomField1Value());
        assertEquals(correspon.getCustomField2Value(), actual.getCustomField2Value());
        assertEquals(correspon.getCustomField3Value(), actual.getCustomField3Value());
        assertEquals(correspon.getCustomField4Value(), actual.getCustomField4Value());
        assertEquals(correspon.getCustomField5Value(), actual.getCustomField5Value());
        assertEquals(correspon.getCustomField6Value(), actual.getCustomField6Value());
        assertEquals(correspon.getCustomField7Value(), actual.getCustomField7Value());
        assertEquals(correspon.getCustomField8Value(), actual.getCustomField8Value());
        assertEquals(correspon.getCustomField9Value(), actual.getCustomField9Value());
        assertEquals(correspon.getCustomField10Value(), actual.getCustomField10Value());

        //  新規登録なので承認状態はDraft、発行日も空
        assertEquals(WorkflowStatus.DRAFT, actual.getWorkflowStatus());
        assertEquals(null, actual.getIssuedAt());

        assertEquals(correspon.getAttachments().size(), page.getAttachments().size());
        for (int i = 0; i < page.getAttachments().size(); i++) {
            Attachment a = correspon.getAttachments().get(i);
            AttachmentInfo info = page.getAttachmentAt(i);

            assertTrue(CopiedAttachmentInfo.class.isAssignableFrom(info.getClass()));
            assertEquals(a.getId(), info.getFileId());
            assertEquals(a.getFileName(), info.getFileName());
        }

        //  新規登録になるのでidはnull
        assertNull(page.getId());
    }

    /**
     * {@link ReviseCorresponSetupStrategy#setup()}の検証.
     * page#idに指定したコレポン文書の改訂文書が生成できていることを検証する.
     * @throws Exception
     */
    @Test
    public void testSetupDefaultCorresponGroupNotSet() throws Exception {
        //  ユーザーのデフォルト活動単位が設定されていない場合、
        //  fromはユーザーの活動単位の先頭になる
        currentProjectUser.setDefaultCorresponGroup(null);
        CorresponGroup from = corresponGroupUsers.get(0).getCorresponGroup();

        strategy.setup();

        Correspon actual = page.getCorrespon();
        assertNotNull(actual);

        assertEquals(null, actual.getId());
        assertEquals(null, actual.getCorresponNo());

        //  返信文書の改訂もあり得るため、返信情報は引き継がなければならない
        assertEquals(correspon.getParentCorresponId(), actual.getParentCorresponId());
        assertEquals(correspon.getParentCorresponNo(), actual.getParentCorresponNo());

        //  改訂元コレポン文書情報として、ID・コレポン文書番号がセットされている
        assertEquals(correspon.getId(), actual.getPreviousRevCorresponId());
        assertEquals(correspon.getCorresponNo(), actual.getPreviousRevCorresponNo());

        // ユーザーが所属する活動単位のうち先頭のもの
        assertEquals(from.getId(), actual.getFromCorresponGroup().getId());

        //  改訂元の文書種別はCanceledなので引き継がない
        assertEquals(CorresponStatus.OPEN, actual.getCorresponStatus());

        assertEquals(correspon.getCorresponType(), actual.getCorresponType());

        assertEquals(correspon.getAddressCorresponGroups(), actual.getAddressCorresponGroups());
        assertEquals(correspon.getAddressCorresponGroups().size(), actual.getAddressCorresponGroups().size());
        //  編集モードは全てNEW
        for (AddressCorresponGroup ag : actual.getAddressCorresponGroups()) {
            assertEquals(UpdateMode.NEW, ag.getMode());
        }

        assertEquals(correspon.getSubject(), actual.getSubject());
        assertEquals(correspon.getBody(), actual.getBody());
        assertEquals(correspon.getReplyRequired(), actual.getReplyRequired());
        assertEquals(correspon.getDeadlineForReply(), actual.getDeadlineForReply());
        //  attachments
        assertEquals(correspon.getAttachments().size(), actual.getAttachments().size());

        //  custom fields
        assertEquals(correspon.getCustomField1Value(), actual.getCustomField1Value());
        assertEquals(correspon.getCustomField2Value(), actual.getCustomField2Value());
        assertEquals(correspon.getCustomField3Value(), actual.getCustomField3Value());
        assertEquals(correspon.getCustomField4Value(), actual.getCustomField4Value());
        assertEquals(correspon.getCustomField5Value(), actual.getCustomField5Value());
        assertEquals(correspon.getCustomField6Value(), actual.getCustomField6Value());
        assertEquals(correspon.getCustomField7Value(), actual.getCustomField7Value());
        assertEquals(correspon.getCustomField8Value(), actual.getCustomField8Value());
        assertEquals(correspon.getCustomField9Value(), actual.getCustomField9Value());
        assertEquals(correspon.getCustomField10Value(), actual.getCustomField10Value());

        //  新規登録なので承認状態はDraft、発行日は空
        assertEquals(WorkflowStatus.DRAFT, actual.getWorkflowStatus());
        assertEquals(null, actual.getIssuedAt());

        assertEquals(correspon.getAttachments().size(), page.getAttachments().size());
        for (int i = 0; i < page.getAttachments().size(); i++) {
            Attachment a = correspon.getAttachments().get(i);
            AttachmentInfo info = page.getAttachmentAt(i);

            assertTrue(CopiedAttachmentInfo.class.isAssignableFrom(info.getClass()));
            assertEquals(a.getId(), info.getFileId());
            assertEquals(a.getFileName(), info.getFileName());
        }

        //  新規登録になるのでidはnull
        assertNull(page.getId());
    }
}
