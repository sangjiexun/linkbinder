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

package net.java.amateras.xlsbeans.xml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author opentone
 */
public class ClassInfo {

	private String className;
	private Map<String, AnnotationInfo> annotationInfos = new HashMap<String, AnnotationInfo>();
	private Map<String, MethodInfo> methodInfos = new HashMap<String, MethodInfo>();
	private Map<String, FieldInfo> fieldInfos = new HashMap<String, FieldInfo>();

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	public void addAnnotationInfo(AnnotationInfo info){
		this.annotationInfos.put(info.getAnnotationClass(), info);
	}

	public AnnotationInfo getAnnotationInfo(String annotationClass){
		return this.annotationInfos.get(annotationClass);
	}

	public AnnotationInfo[] getAnnotationInfos(){
		return annotationInfos.values().toArray(new AnnotationInfo[0]);
	}

	public void addMethodInfo(MethodInfo info){
		this.methodInfos.put(info.getMethodName(), info);
	}

	public MethodInfo getMethodInfo(String methodName){
		return this.methodInfos.get(methodName);
	}

	public void addFieldInfo(FieldInfo info){
		this.fieldInfos.put(info.getFieldName(), info);
	}

	public FieldInfo getFieldInfo(String fieldName){
		return this.fieldInfos.get(fieldName);
	}

}