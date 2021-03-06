package com.github.riccardove.easyjasub;

/*
 * #%L
 * easyjasub
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


import java.io.File;

import org.junit.Test;

public class SubtitleListTranslatedSubFileReaderTest extends EasyJaSubTestCase {

	@Test
	public void test() throws Exception {
		File fileJa = getSampleFile("sample1.jp.ass");
		File file = getSampleFile("sample1.en.srt");

		SubtitleList s = new SubtitleList();

		new SubtitleListJapaneseSubFileReader().
			readJapaneseSubtitles(s, fileJa, SubtitleFileType.ASS, new Observer(), null);

		new SubtitleListTranslatedSubFileReader(1000, 400).
			readTranslationSubtitles(s, file, SubtitleFileType.SRT, new Observer(), null, true);
	}

	private class Observer extends EasyJaSubObserverBase {
		
	}
}
