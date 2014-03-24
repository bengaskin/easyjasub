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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.xml.sax.SAXException;

import com.github.riccardove.easyjasub.commons.CommonsLangStringUtils;
import com.github.riccardove.easyjasub.inputtextsub.InputTextSubException;

class EasyJaSubConsole implements EasyJaSubObserver {

	private final PrintWriter outputStream;
	private final PrintWriter errorStream;
	private final int verbose;

	public EasyJaSubConsole(PrintWriter outputStream, PrintWriter errorStream,
			int verbose) {
		this.outputStream = outputStream;
		this.errorStream = errorStream;
		this.verbose = verbose;
	}

	private void println(String text) {
		outputStream.println(text);
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseStart(File file) {
		println("onInputNihongoJTalkHtmlFileParseStart " + toString(file));
		flushOutput();
	}

	private void lowVerboseMessage(String message) {
		verboseMessage(0, message);
	}

	private void mediumVerboseMessage(String message) {
		verboseMessage(1, message);
	}

	private void verboseMessage(int level, String message) {
		if (verbose >= level) {
			println(message);
			flushOutput();
		}
	}

	private void flushOutput() {
		outputStream.flush();
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseEnd(File file,
			Set<String> posset) {
		lowVerboseMessage("onInputNihongoJTalkHtmlFileParseEnd "
				+ toString(file) + " "
				+ CommonsLangStringUtils.join(posset, ","));
	}

	@Override
	public void onReadJapaneseSubtitlesStart(File file) {
		lowVerboseMessage("onReadJapaneseSubtitlesStart " + toString(file));
	}

	@Override
	public void onReadJapaneseSubtitlesEnd(File file) {
		lowVerboseMessage("onReadJapaneseSubtitlesEnd " + toString(file));
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseHiraganaDivEnd() {
		mediumVerboseMessage("onInputNihongoJTalkHtmlFileParseHiraganaDivEnd");
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseTextareaEnd() {
		mediumVerboseMessage("onInputNihongoJTalkHtmlFileParseTextareaEnd");
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseTextareaStart() {
		mediumVerboseMessage("onInputNihongoJTalkHtmlFileParseTextareaStart");
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseHiraganaDivStart() {
		mediumVerboseMessage("onInputNihongoJTalkHtmlFileParseHiraganaDivStart");
	}

	@Override
	public void onReadTranslatedSubtitlesStart(File file) {
		lowVerboseMessage("onReadTranslatedSubtitlesStart " + toString(file));
	}

	@Override
	public void onReadTranslatedSubtitlesEnd(File file) {
		lowVerboseMessage("onReadTranslatedSubtitlesEnd " + toString(file));
	}

	@Override
	public void onWriteHtmlStart(File directory, File cssFile) {
		lowVerboseMessage("onWriteHtmlStart " + toString(directory) + " "
				+ toString(cssFile));
	}

	@Override
	public void onWriteHtmlEnd(File directory) {
		lowVerboseMessage("onWriteHtmlEnd " + toString(directory));
	}

	@Override
	public void onWriteImagesStart(String wkhtml, File htmlFolder,
			File bdnFolder, int width) {
		lowVerboseMessage("onWriteImagesStart " + toString(bdnFolder) + " "
				+ wkhtml + " " + width);
	}

	@Override
	public void onWriteImagesEnd(String wkhtml, File htmlFolder, File bdnFolder) {
		lowVerboseMessage("onWriteImagesEnd " + toString(bdnFolder));
	}

	@Override
	public void onWriteBdnXmlFileStart(File file) {
		lowVerboseMessage("onWriteBdnXmlFileStart " + toString(file));
	}

	@Override
	public void onWriteBdnXmlFileEnd(File file) {
		lowVerboseMessage("onWriteBdnXmlFileEnd " + toString(file));
	}

	@Override
	public void onWriteIdxFileStart(File file, File bdnFile) {
		lowVerboseMessage("Run BDSup2Sub with arguments -m 100 -x 10 -p keep -T 24p -v -o "
				+ toString(file)
				+ " "
				+ toString(bdnFile)
				+ " to convert generated subtitles");
	}

	@Override
	public void onWriteIdxFileEnd(File file) {
		lowVerboseMessage("onWriteIdxFileEnd " + toString(file));
	}

	@Override
	public void onWriteOutputJapaneseTextFileStart(File file) {
		lowVerboseMessage("onWriteOutputJapaneseTextFileStart "
				+ toString(file));
	}

	@Override
	public void onWriteOutputJapaneseTextFileEnd(File file) {
		lowVerboseMessage("onWriteOutputJapaneseTextFileEnd " + toString(file));
	}

	@Override
	public void onWriteCssStart(File file) {
		lowVerboseMessage("onWriteCssStart " + toString(file));
	}

	@Override
	public void onWriteCssEnd(File file) {
		lowVerboseMessage("onWriteCssEnd " + toString(file));
	}

	@Override
	public void onWriteImage(File pngFile, File file) {
		mediumVerboseMessage("writing image " + toString(pngFile) + " "
				+ toString(file));
	}

	@Override
	public void onReadJapaneseSubtitlesIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error reading japanese subtitles file "
				+ toString(file) + ": " + ex.getLocalizedMessage());
	}

	@Override
	public void onReadJapaneseSubtitlesParseError(File file,
			InputTextSubException ex) throws EasyJaSubException {
		throw new EasyJaSubException("Error parsing japanese subtitles file "
				+ toString(file) + " content: " + ex.getLocalizedMessage());
	}

	@Override
	public void onInputNihongoJTalkHtmlFileIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error reading nihongo.j-talk file "
				+ toString(file) + ": " + ex.getLocalizedMessage());
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseError(File file, SAXException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error parsing nihongo.j-talk file "
				+ toString(file) + "content: " + ex.getLocalizedMessage());
	}

	@Override
	public void onReadTranslatedSubtitlesIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error reading translated subtitles file "
				+ toString(file) + ": " + ex.getLocalizedMessage());
	}

	@Override
	public void onReadTranslatedSubtitlesParseError(File file,
			InputTextSubException ex) throws EasyJaSubException {
		throw new EasyJaSubException("Error parsing translated subtitles file "
				+ toString(file) + " content: " + ex.getLocalizedMessage());
	}

	@Override
	public void onWriteCssIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error writing css file " + toString(file)
				+ " : " + ex.getLocalizedMessage());
	}

	@Override
	public void onWriteHtmlError(File htmlFolder, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error writing html file on folder "
				+ toString(htmlFolder) + " : " + ex.getLocalizedMessage());
	}

	@Override
	public void onWriteImagesWkhtmlError(File bdnFolder, Exception ex)
			throws EasyJaSubException {
		throw new EasyJaSubException(
				"Error invoking wkhtmltoimage to write files on folder "
						+ toString(bdnFolder) + " : "
						+ ex.getLocalizedMessage());
	}

	@Override
	public void onWriteImagesIOError(File bdnFolder, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error writing image files on folder "
				+ toString(bdnFolder) + " : " + ex.getLocalizedMessage());
	}

	@Override
	public void onWriteBdnXmlFileIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error writing BDMXML file "
				+ toString(file) + " : " + ex.getLocalizedMessage());
	}

	@Override
	public void onWriteOutputJapaneseTextFileIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error writing japanese text file "
				+ toString(file) + " : " + ex.getLocalizedMessage());
	}

	@Override
	public void onTranslatedSubDuplicated(String content, int mSeconds,
			int startTime) {
		lowVerboseMessage("Duplicated translation caption " + content
				+ " starting at " + mSeconds + " at " + startTime);
	}

	@Override
	public void onInputNihongoJTalkHtmlLine(String line) {
		mediumVerboseMessage("Line: " + toString(line));
	}

	@Override
	public void onWriteOutputJapaneseTextFileSkipped(File file) {
		lowVerboseMessage("onWriteOutputJapaneseTextFileSkipped "
				+ toString(file));
	}

	@Override
	public void onInputNihongoJTalkHtmlFileParseSkipped(File file) {
		lowVerboseMessage("onInputNihongoJTalkHtmlFileParseSkipped "
				+ toString(file));
	}

	@Override
	public void onReadTranslatedSubtitlesSkipped(File file) {
		lowVerboseMessage("onReadTranslatedSubtitlesSkipped " + toString(file));
	}

	@Override
	public void onWriteCssSkipped(File file) {
		lowVerboseMessage("onWriteCssSkipped " + toString(file));
	}

	@Override
	public void onWriteHtmlFile(File file) {
		mediumVerboseMessage("onWriteHtmlFile " + toString(file));
	}

	@Override
	public void onWriteHtmlFileSkipped(File file) {
		lowVerboseMessage("onWriteHtmlFileSkipped " + toString(file));
	}

	@Override
	public void onWriteBdnXmlFileSkipped(File file) {
		lowVerboseMessage("onWriteBdnXmlFileSkipped " + toString(file));
	}

	@Override
	public void onWriteImageSkipped(File pngFile, File file) {
		lowVerboseMessage("onWriteImageSkipped " + toString(pngFile) + " "
				+ toString(file));
	}

	@Override
	public void onWriteIdxFileSkipped(File file, File bdnFile) {
		lowVerboseMessage("onWriteIdxFileSkipped " + toString(file) + " "
				+ toString(bdnFile));
	}

	@Override
	public void onReadJapaneseSubtitlesSkipped(File file) {
		lowVerboseMessage("onReadJapaneseSubtitlesSkipped " + toString(file));
	}

	private static String toString(File file) {
		return file != null ? file.getAbsolutePath() : "<null>";
	}

	private static String toString(String text) {
		return text != null ? text : "<null>";
	}

	@Override
	public void onInputNihongoJTalkHtmlLineParseSkipped(List<Integer> nLines,
			List<Integer> subLines) {
		lowVerboseMessage("onInputNihongoJTalkHtmlLineParseSkipped "
				+ CommonsLangStringUtils.join(nLines, ",") + " -- "
				+ CommonsLangStringUtils.join(subLines, ","));
	}

	@Override
	public void onEncodingWarning(String systemEncoding, String charsetstr) {
		lowVerboseMessage("onEncodingWarning " + systemEncoding);
	}

	@Override
	public void onMeCabRunStart(String file) {
		lowVerboseMessage("onMeCabRunStart " + toString(file));
	}

	@Override
	public void onMeCabRunSkipped(String file) {
		lowVerboseMessage("onMeCabRunSkipped " + toString(file));
	}

	@Override
	public void onMeCabRunEnd(String file) {
		lowVerboseMessage("onMeCabRunEnd " + toString(file));
	}

	@Override
	public void onMeCabInputLine() {
		mediumVerboseMessage("onMeCabInputLine");
	}

	@Override
	public void onMeCabExecuted(File meCabOutputFile, List<String> meCabOutput) {
		mediumVerboseMessage("onMeCabExecuted " + meCabOutput.size() + " "
				+ toString(meCabOutputFile));
	}

	@Override
	public void onMeCabParsed(int size) {
		mediumVerboseMessage("onMeCabParsed " + size);
	}

	@Override
	public void onMeCabParseInvalidLine(int count, String textLine) {
		lowVerboseMessage("onMeCabParseInvalidLine " + count + " "
				+ toString(textLine));
	}

	@Override
	public void onMeCabFileRed(File meCabOutputFile, List<String> meCabOutput) {
		mediumVerboseMessage("onMeCabFileRed " + meCabOutput.size() + " "
				+ toString(meCabOutputFile));
	}

	@Override
	public void onMeCabUnknownGrammar(Set<String> elements,
			List<String> pronunciationErrors) {
		if (elements.size() > 0) {
			lowVerboseMessage("onMeCabUnknownGrammar "
					+ elements.size()
					+ SystemProperty.getLineSeparator()
					+ CommonsLangStringUtils.join(elements,
							SystemProperty.getLineSeparator()));
		}
		if (pronunciationErrors.size() > 0) {
			lowVerboseMessage("pronunciationErrors "
					+ pronunciationErrors.size()
					+ SystemProperty.getLineSeparator()
					+ CommonsLangStringUtils.join(pronunciationErrors,
							SystemProperty.getLineSeparator()));
		}
	}

	@Override
	public void onWriteXmlFileStart(File file) {
		lowVerboseMessage("onWriteXmlFileStart " + toString(file));
	}

	@Override
	public void onWriteXmlFileEnd(File file) {
		lowVerboseMessage("onWriteXmlFileEnd " + toString(file));
	}

	@Override
	public void onWriteXmlFileIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error writing XML file " + toString(file)
				+ ": " + ex.getLocalizedMessage());
	}

	@Override
	public void onWriteXmlFileSkipped(File file) {
		lowVerboseMessage("onWriteXmlFileSkipped " + toString(file));
	}

	@Override
	public void onReadXmlFileStart(File file) {
		lowVerboseMessage("onReadXmlFileStart " + toString(file));
	}

	@Override
	public void onReadXmlFileEnd(File file) {
		lowVerboseMessage("onReadXmlFileEnd " + toString(file));
	}

	@Override
	public void onReadXmlFileIOError(File file, IOException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error reading input XML file "
				+ toString(file) + ": " + ex.getLocalizedMessage());
	}

	@Override
	public void onReadXmlFileError(File file, SAXException ex)
			throws EasyJaSubException {
		throw new EasyJaSubException("Error parsing input XML file "
				+ toString(file) + ": " + ex.getLocalizedMessage());
	}
}
