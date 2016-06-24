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

package net.java.amateras.xlsbeans.xssfconverter.impl.xssf;

import net.java.amateras.xlsbeans.xssfconverter.WCell;
import net.java.amateras.xlsbeans.xssfconverter.WCellFormat;

/**
 * blank cell implementation.
 * (HSSF/XSSF return null, if Excel cell doesn't exist.)
 *
 * @author opentone
 *
 */
public class XssfBlankWCellImpl implements WCell {

	private int column = 0;
	private int row = 0;

	public XssfBlankWCellImpl(int column, int row) {
		this.column = column;
		this.row = row;
	}


	public WCellFormat getCellFormat() {
		return new XssfWCellFormatImpl(null);
	}

	public int getColumn() {
		return column;
	}

	public String getContents() {
		return "";
	}

	public int getRow() {
		return row;
	}

}
