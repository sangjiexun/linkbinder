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
package jp.co.opentone.bsol.linkbinder.view.admin;

import static jp.co.opentone.bsol.linkbinder.message.ApplicationMessageCode.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jp.co.opentone.bsol.framework.core.exception.InvalidOperationRuntimeException;
import jp.co.opentone.bsol.framework.core.message.Messages;
import jp.co.opentone.bsol.framework.core.service.ServiceAbortException;
import jp.co.opentone.bsol.framework.extension.jsf.FacesContextMock;
import jp.co.opentone.bsol.framework.test.AbstractTestCase;
import jp.co.opentone.bsol.linkbinder.dto.SearchSiteResult;
import jp.co.opentone.bsol.linkbinder.dto.Site;
import jp.co.opentone.bsol.linkbinder.dto.User;
import jp.co.opentone.bsol.linkbinder.dto.condition.SearchSiteCondition;
import jp.co.opentone.bsol.linkbinder.message.ApplicationMessageCode;
import jp.co.opentone.bsol.linkbinder.service.admin.impl.SiteServiceImpl;
import jp.co.opentone.bsol.linkbinder.view.AbstractPage;
import mockit.Mock;
import mockit.MockUp;

/**
 * {@link SiteConfirmationPage}のテストケース.
 * @author opentone
 */
public class SiteConfirmationPageTest extends AbstractTestCase {

    /**
     * テスト対象クラス
     */
    @Resource
    private SiteConfirmationPage page;

    /**
     * ユーザー情報
     */
    private User user;

    /**
     * テストの前準備.
     */
    @BeforeClass
    public static void testSetUp() {
        FacesContextMock.initialize();
        new MockAbstractPage();
        new MockSiteService();
    }

    /**
     * 後始末.
     */
    @AfterClass
    public static void testTeardown() {
        new MockAbstractPage().tearDown();
        new MockSiteService().tearDown();
        FacesContextMock.tearDown();
    }

    @Before
    public void setUp() {
        user = new User();
        user.setEmpNo("ZZA01");
        user.setNameE("Taro Yamada");
    }

    @After
    public void tearDown() {
        MockAbstractPage.RET_PROJID = null;
        MockAbstractPage.IS_SYSTEM_ADMIN = false;
        MockAbstractPage.IS_PROJECT_ADMIN = false;
        MockAbstractPage.IS_ANY_GROUP_ADMIN = false;
        MockSiteService.RET_SEARCH = null;
        MockSiteService.CRT_DELETE = null;
        MockSiteService.RET_SAVE = null;
        MockSiteService.CRT_VALIDATE = null;
        MockSiteService.RET_FIND = null;
        page.setCode(null);
        page.setName(null);
        page.setSite(null);
    }

    /**
     * 初期化アクションを検証する. SystemAdminの場合
     * @throws Exception
     */
    @Test
    public void testInitializeSystemAdmin() throws Exception {
        // テストに必要なデータを作成
        MockAbstractPage.RET_PROJID = "9-9999-9";
        MockAbstractPage.IS_SYSTEM_ADMIN = true;
        page.setSite(new Site());
        page.initialize();
        assertTrue(page.getInitialDisplaySuccess());

    }

    /**
     * 初期化アクションを検証する. ProjectAdminの場合
     * @throws Exception
     */
    @Test
    public void testInitializeProjectAdmin() throws Exception {
        // テストに必要なデータを作成
        MockAbstractPage.RET_PROJID = "9-9999-9";
        MockAbstractPage.IS_PROJECT_ADMIN = true;
        page.setSite(new Site());
        page.initialize();
        assertTrue(page.getInitialDisplaySuccess());

    }


    /**
     * 初期化アクションを検証する. 権限がない場合
     * @throws Exception
     */
    @Test
    public void testInvalidPermissionInitialize() throws Exception {
        // 権限がない
        MockAbstractPage.RET_PROJID = "9-9999-9";
        MockAbstractPage.IS_SYSTEM_ADMIN = false;
        MockAbstractPage.IS_PROJECT_ADMIN = false;
        // 期待されるメッセージをセット
        FacesContextMock.EXPECTED_CLIENT_ID = null;
        FacesContextMock.EXPECTED_MESSAGE =
                new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, FacesMessage.SEVERITY_ERROR.toString(),
                                 createExpectedMessageString(
                                     Messages.getMessageAsString(CANNOT_PERFORM_BECAUSE_ACCESS_LEVEL_INSUFFICIENT),
                                     "Initialize"));
        try {
            page.initialize();
            fail("例外が発生していない");
        } catch (InvalidOperationRuntimeException e) {
            ServiceAbortException actual = (ServiceAbortException)e.getCause();
            assertEquals(ApplicationMessageCode.CANNOT_PERFORM_BECAUSE_ACCESS_LEVEL_INSUFFICIENT, actual.getMessageCode());
        }
    }

    /**
     * 初期化アクションを検証する. プロジェクト未選択の場合.
     * @throws Exception
     */
    @Test
    public void testProjectNotSelectedInitialize() throws Exception {
        // 権限はあるがプロジェクトが選択されていない
        MockAbstractPage.RET_PROJID = null;
        MockAbstractPage.IS_SYSTEM_ADMIN = false;
        MockAbstractPage.IS_PROJECT_ADMIN = true;
        // 期待されるメッセージをセット
        FacesContextMock.EXPECTED_CLIENT_ID = null;
        FacesContextMock.EXPECTED_MESSAGE =
                new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, FacesMessage.SEVERITY_ERROR.toString(),
                                 createExpectedMessageString(
                                     Messages.getMessageAsString(CANNOT_PERFORM_BECAUSE_ACCESS_LEVEL_INSUFFICIENT),
                                     "Initialize"));
        try {
            page.initialize();
            fail("例外が発生していない");
        } catch (InvalidOperationRuntimeException e) {
            ServiceAbortException actual = (ServiceAbortException)e.getCause();
            assertEquals(ApplicationMessageCode.CANNOT_PERFORM_BECAUSE_ACCESS_LEVEL_INSUFFICIENT, actual.getMessageCode());
        }
    }

    /**
     * 保存アクションを検証する.
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        // テストに必要なデータを作成する
        Site site = new Site();
        site.setId(1L);
        site.setSiteCd("YOC");
        site.setName("Yocohama");
        site.setProjectId("PJ1");
        site.setProjectNameE("Test Project1");
        site.setCreatedBy(user);
        site.setUpdatedBy(user);
        site.setVersionNo(1L);
        site.setDeleteNo(0L);

        MockAbstractPage.IS_SYSTEM_ADMIN = true;
        MockSiteService.RET_SAVE = 1L;

        page.save();

        assertEquals(String.valueOf(1L), String.valueOf(page.getId()));
    }

    public static class MockSiteService extends MockUp<SiteServiceImpl> {
        static SearchSiteResult RET_SEARCH;
        static byte[] RET_EXCEL;
        static Site CRT_DELETE;
        static Site RET_FIND;
        static Site CRT_VALIDATE;
        static Long RET_SAVE;

        @Mock
        public SearchSiteResult search(SearchSiteCondition condition) throws ServiceAbortException {
            return RET_SEARCH;
        }

        @Mock
        public byte[] generateExcel(List<Site> Sites) throws ServiceAbortException {
            return RET_EXCEL;
        }

        @Mock
        public void delete(Site site) throws ServiceAbortException {
            CRT_DELETE = site;
        }

        @Mock
        public Site find(Long id) throws ServiceAbortException {
            return RET_FIND;
        }

        @Mock
        public void validate(Site site) throws ServiceAbortException {
            CRT_VALIDATE = site;
        }

        @Mock
        public Long save(Site site) throws ServiceAbortException {
            return RET_SAVE;
        }

    }

    public static class MockAbstractPage extends MockUp<AbstractPage> {
        static String RET_PROJID;
        static boolean IS_SYSTEM_ADMIN;
        static boolean IS_PROJECT_ADMIN;
        static boolean IS_ANY_GROUP_ADMIN;

        @Mock
        public String getCurrentProjectId() {
            return RET_PROJID;
        }

        @Mock
        public boolean isSystemAdmin() {
            return IS_SYSTEM_ADMIN;
        }

        @Mock
        public boolean isProjectAdmin(String projectId) {
            return IS_PROJECT_ADMIN;
        }

        @Mock
        public boolean isAnyGroupAdmin(String projectId) {
            return IS_ANY_GROUP_ADMIN;
        }
    }
}
