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

import static org.junit.Assert.*;

import org.junit.Test;

public class ReadStatusTest {

    @Test
    public void testValues() {

        assertEquals(0, ReadStatus.NEW.getValue().intValue());
        assertEquals("未読", ReadStatus.NEW.getLabel());
        assertEquals(1, ReadStatus.READ.getValue().intValue());
        assertEquals("既読", ReadStatus.READ.getLabel());
    }
}
