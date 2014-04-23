package com.github.riccardove.easyjasub.lucene;

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


import org.apache.lucene.analysis.ja.util.ToStringUtil;

public final class LuceneUtil {

	private LuceneUtil() {

	}

	/**
	 * Romanize katakana with modified hepburn
	 */
	public static String KatakanaToRomaji(String text) {
		return ToStringUtil.getRomanization(text);
	}

	public static String TranslatePartOfSpeech(String partOfSpeech) {
		String translation = ToStringUtil.getPOSTranslation(partOfSpeech);
		return translation != null ? translation : partOfSpeech;
	}

	public static String TranslateInflectedForm(String inflectedForm) {
		String translation = ToStringUtil
				.getInflectedFormTranslation(inflectedForm);
		return translation != null ? translation : inflectedForm;
	}

	public static String TranslateInflectionType(String inflectionType) {
		String translation = ToStringUtil
				.getInflectionTypeTranslation(inflectionType);
		return translation != null ? translation : inflectionType;
	}

}
