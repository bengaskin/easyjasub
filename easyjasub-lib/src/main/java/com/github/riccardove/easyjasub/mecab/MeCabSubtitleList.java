package com.github.riccardove.easyjasub.mecab;

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


import java.util.ArrayList;
import java.util.Iterator;

class MeCabSubtitleList implements Iterable<MeCabSubtitleLine> {

	public MeCabSubtitleList() {
		lines = new ArrayList<MeCabSubtitleLine>();
	}

	private final ArrayList<MeCabSubtitleLine> lines;

	public MeCabSubtitleLine add() {
		MeCabSubtitleLine line = new MeCabSubtitleLine();
		lines.add(line);
		return line;
	}

	public MeCabSubtitleLine get(int index) {
		return lines.get(index);
	}

	@Override
	public Iterator<MeCabSubtitleLine> iterator() {
		return lines.iterator();
	}

	public int size() {
		return lines.size();
	}

}