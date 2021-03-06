package com.github.riccardove.easyjasub.kurikosu;

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


import com.github.riccardove.easyjasub.EasyJaSubTestCase;

public class KurikosuTest extends EasyJaSubTestCase {

	public void test() throws Exception {
		assertKatakanaToHiragana("シ", "し");
	}

	private void assertKatakanaToHiragana(String katakana, String hiragana)
			throws Exception {
		assertEquals(hiragana, Kurikosu.convertKatakanaToHiragana(katakana));
	}
}
