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

package net.java.amateras.xlsbeans.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import net.java.amateras.xlsbeans.NeedPostProcess;
import net.java.amateras.xlsbeans.Utils;
import net.java.amateras.xlsbeans.xml.AnnotationReader;
import net.java.amateras.xlsbeans.xssfconverter.WSheet;

/**
 *
 * @author opentone
 * @see net.java.amateras.xlsbeans.annotation.SheetName
 */
public class SheetNameProcessor implements FieldProcessor {

	public void doProcess(WSheet wSheet, Object obj, Method setter,
			Annotation cell, AnnotationReader reader,
			List<NeedPostProcess> needPostProcess) throws Exception {

		Utils.invokeSetter(setter, obj, wSheet.getName());
	}

	public void doProcess(WSheet wSheet, Object obj, Field field, Annotation ann,
			AnnotationReader reader, List<NeedPostProcess> needPostProcess)
			throws Exception {

		Utils.setField(field, obj, wSheet.getName());
	}

}
