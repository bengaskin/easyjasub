package com.github.riccardove.easyjasub;

/*
 * #%L
 * easyjasub-lib
 * %%
 * Copyright (C) 2014 Riccardo Vestrini
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.List;

public class SubtitleLine {


	public List<SubtitleTranslatedLine> getTranslation() {
		return translation;
	}

	public void setTranslation(List<SubtitleTranslatedLine> text) {
		translation = text;
	}
	
	private int index;

	private List<SubtitleTranslatedLine> translation;
	private List<SubtitleItem> items;
	private String japanese;

	public String getJapanese() {
		return japanese;
	}

	private int startTime;
	private int endTime;
	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setStartTime(int mSeconds) {
		startTime = mSeconds;
	}

	public void setEndTime(int mSeconds) {
		endTime = mSeconds;
	}

	public List<SubtitleItem> getItems() {
		return items;
	}

	public void setItems(List<SubtitleItem> items) {
		this.items = items;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private String japaneseSubKey;

	/**
	 * Key string containing only japanese chars in the caption, used for comparisons
	 */
	public String getJapaneseSubKey() {
		return japaneseSubKey;
	}
	
	private String subText;
	
	public void setSubText(String subText) {
		this.subText = subText;
		japaneseSubKey = JapaneseChar.getJapaneseKey(subText);
		if (japaneseSubKey != null) {
			japanese = subText;
		}
	}

	/**
	 * Text of the caption, for captions without any japanese char that do not need translation
	 */
	public String getSubText() {
		return subText;
	}

	private SubtitleLine next;

	public SubtitleLine getNext() {
		return next;
	}

	public void setNext(SubtitleLine next) {
		this.next = next;
	}

	private SubtitleLine previous;

	public SubtitleLine getPrevious() {
		return previous;
	}

	public void setPrevious(SubtitleLine previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (items != null) {
			for (SubtitleItem item : items) {
				result.append(" ");
				result.append(item.toString());
			}
		}
		return result.toString();
	}
}
