/*
* Java Base64 - A pure Java library for reading and writing Base64
*               encoded streams.
* 
* Copyright (C) 2007-2009 Carlo Pelliccia (www.sauronsoftware.it)
* 
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License version
* 2.1, as published by the Free Software Foundation.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License version 2.1 along with this program.
* If not, see <http://www.gnu.org/licenses/>.
*/

package it.sauronsoftware.base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
* <p>
* Base64 encoding and decoding utility methods, both for binary and textual
* informations.
* </p>
* 
* @author Carlo Pelliccia
* @since 1.1
* @version 1.3
*/
public class Base64 {

	/**
 	* <p>
 	* Encodes a string.
 	* </p>
 	* <p>
 	* Before the string is encoded in Base64, it is converted in a binary
 	* sequence using the system default charset.
 	* </p>
 	* 
 	* @param str
 	*            The source string.
 	* @return The encoded string.
 	* @throws RuntimeException
 	*             If an unexpected error occurs.
 	*/
	public static String encode(String str) throws RuntimeException {
		byte[] bytes = str.getBytes();
		byte[] encoded = encode(bytes);
			try {
				return new String(encoded, "ASCII");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("ASCII is not supported!", e);
			}
	}

	/**
	 * <p>
	 * Encodes a string.
	 * </p>
	 * <p>
	 * Before the string is encoded in Base64, it is converted in a binary
	 * sequence using the supplied charset.
	 * </p>
	 * 
	 * @param str
	 *            The source string
	 * @param charset
	 *            The charset name.
	 * @return The encoded string.
	 * @throws RuntimeException
	 *             If an unexpected error occurs.
	 * @since 1.2
	 */
	public static String encode(String str, String charset)
			throws RuntimeException {
		byte[] bytes;
		try {
			bytes = str.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Unsupported charset: " + charset, e);
		}
		byte[] encoded = encode(bytes);
		try {
			return new String(encoded, "ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
	}

	/**
	 * <p>
	 * Decodes the supplied string.
	 * </p>
	 * <p>
	 * The supplied string is decoded into a binary sequence, and then the
	 * sequence is encoded with the system default charset and returned.
	 * </p>
	 * 
	 * @param str
	 *            The encoded string.
	 * @return The decoded string.
	 * @throws RuntimeException
	 *             If an unexpected error occurs.
	 */
	public static String decode(String str) throws RuntimeException {
		byte[] bytes;
		try {
			bytes = str.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
		byte[] decoded = decode(bytes);
		return new String(decoded);
	}

	/**
130             * <p>
131             * Decodes the supplied string.
132             * </p>
133             * <p>
134             * The supplied string is decoded into a binary sequence, and then the
135             * sequence is encoded with the supplied charset and returned.
136             * </p>
137             * 
138             * @param str
139             *            The encoded string.
140             * @param charset
141             *            The charset name.
142             * @return The decoded string.
143             * @throws RuntimeException
144             *             If an unexpected error occurs.
145             * @since 1.2
146             */
	public static String decode(String str, String charset)
			throws RuntimeException {
		byte[] bytes;
		try {
			bytes = str.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
		byte[] decoded = decode(bytes);
		try {
			return new String(decoded, charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Unsupported charset: " + charset, e);
		}
	}

/**
164             * <p>
165             * Encodes a binary sequence.
166             * </p>
167             * <p>
168             * If data are large, i.e. if you are working with large binary files,
169             * consider to use a {@link Base64OutputStream} instead of loading too much
170             * data in memory.
171             * </p>
172             * 
173             * @param bytes
174             *            The source sequence.
175             * @return The encoded sequence.
176             * @throws RuntimeException
177             *             If an unexpected error occurs.
178             * @since 1.2
179             */
	public static byte[] encode(byte[] bytes) throws RuntimeException {
		return encode(bytes, 0);
	}

/**
185             * <p>
186             * Encodes a binary sequence, wrapping every encoded line every
187             * <em>wrapAt</em> characters. A <em>wrapAt</em> value less than 1 disables
188             * wrapping.
189             * </p>
190             * <p>
191             * If data are large, i.e. if you are working with large binary files,
192             * consider to use a {@link Base64OutputStream} instead of loading too much
193             * data in memory.
194             * </p>
195             * 
196             * @param bytes
197             *            The source sequence.
198             * @param wrapAt
199             *            The max line length for encoded data. If less than 1 no wrap
200             *            is applied.
201             * @return The encoded sequence.
202             * @throws RuntimeException
203             *             If an unexpected error occurs.
204             * @since 1.2
205             */
	public static byte[] encode(byte[] bytes, int wrapAt)
			throws RuntimeException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			encode(inputStream, outputStream, wrapAt);
		} catch (IOException e) {
			throw new RuntimeException("Unexpected I/O error", e);
		} finally {
			try {
				inputStream.close();
			} catch (Throwable t) {
				;
			}
			try {
				outputStream.close();
			} catch (Throwable t) {
				;
			}
		}
		return outputStream.toByteArray();
	}

	/**
230             * <p>
231             * Decodes a binary sequence.
232             * </p>
233             * <p>
234             * If data are large, i.e. if you are working with large binary files,
235             * consider to use a {@link Base64InputStream} instead of loading too much
236             * data in memory.
237             * </p>
238             * 
239             * @param bytes
240             *            The encoded sequence.
241             * @return The decoded sequence.
242             * @throws RuntimeException
243             *             If an unexpected error occurs.
244             * @since 1.2
245             */
	public static byte[] decode(byte[] bytes) throws RuntimeException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			decode(inputStream, outputStream);
		} catch (IOException e) {
			throw new RuntimeException("Unexpected I/O error", e);
		} finally {
			try {
				inputStream.close();
			} catch (Throwable t) {
				;
			}
			try {
				outputStream.close();
			} catch (Throwable t) {
				;
			}	
		}
		return outputStream.toByteArray();
	}

	/**
269             * <p>
270             * Encodes data from the given input stream and writes them in the given
271             * output stream.
272             * </p>
273             * <p>
274             * The supplied input stream is read until its end is reached, but it's not
275             * closed by this method.
276             * </p>
277             * <p>
278             * The supplied output stream is nor flushed neither closed by this method.
279             * </p>
280             * 
281             * @param inputStream
282             *            The input stream.
283             * @param outputStream
284             *            The output stream.
285             * @throws IOException
286             *             If an I/O error occurs.
287             */
	public static void encode(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		encode(inputStream, outputStream, 0);
	}

	/**
294             * <p>
295             * Encodes data from the given input stream and writes them in the given
296             * output stream, wrapping every encoded line every <em>wrapAt</em>
297             * characters. A <em>wrapAt</em> value less than 1 disables wrapping.
298             * </p>
299             * <p>
300             * The supplied input stream is read until its end is reached, but it's not
301             * closed by this method.
302             * </p>
303             * <p>
304             * The supplied output stream is nor flushed neither closed by this method.
305             * </p>
306             * 
307             * @param inputStream
308             *            The input stream from which clear data are read.
309             * @param outputStream
310             *            The output stream in which encoded data are written.
311             * @param wrapAt
312             *            The max line length for encoded data. If less than 1 no wrap
313             *            is applied.
314             * @throws IOException
315             *             If an I/O error occurs.
316             */
	public static void encode(InputStream inputStream,
			OutputStream outputStream, int wrapAt) throws IOException {
		Base64OutputStream aux = new Base64OutputStream(outputStream, wrapAt);
		copy(inputStream, aux);
		aux.commit();
	}

	/**
325             * <p>
326             * Decodes data from the given input stream and writes them in the given
327             * output stream.
328             * </p>
329             * <p>
330             * The supplied input stream is read until its end is reached, but it's not
331             * closed by this method.
332             * </p>
333             * <p>
334             * The supplied output stream is nor flushed neither closed by this method.
335             * </p>
336             * 
337             * @param inputStream
338             *            The input stream from which encoded data are read.
339             * @param outputStream
340             *            The output stream in which decoded data are written.
341             * @throws IOException
342             *             If an I/O error occurs.
343             */
	public static void decode(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		copy(new Base64InputStream(inputStream), outputStream);
	}

	/**
350             * <p>
351             * Encodes data from the given source file contents and writes them in the
352             * given target file, wrapping every encoded line every <em>wrapAt</em>
353             * characters. A <em>wrapAt</em> value less than 1 disables wrapping.
354             * </p>
355             * 
356             * @param source
357             *            The source file, from which decoded data are read.
358             * @param target
359             *            The target file, in which encoded data are written.
360             * @param wrapAt
361             *            The max line length for encoded data. If less than 1 no wrap
362             *            is applied.
363             * @throws IOException
364             *             If an I/O error occurs.
365             * @since 1.3
366             */
	public static void encode(File source, File target, int wrapAt)
			throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(source);
			outputStream = new FileOutputStream(target);
			Base64.encode(inputStream, outputStream, wrapAt);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Throwable t) {
					;
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Throwable t) {
					;
				}
			}
		}
	}

	/**
394             * <p>
395             * Encodes data from the given source file contents and writes them in the
396             * given target file.
397             * </p>
398             * 
399             * @param source
400             *            The source file, from which decoded data are read.
401             * @param target
402             *            The target file, in which encoded data are written.
403             * @throws IOException
404             *             If an I/O error occurs.
405             * @since 1.3
406             */
	public static void encode(File source, File target) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(source);
			outputStream = new FileOutputStream(target);
			Base64.encode(inputStream, outputStream);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Throwable t) {
					;
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Throwable t) {
					;
				}
			}
		}
	}

	/**
433             * <p>
434             * Decodes data from the given source file contents and writes them in the
435             * given target file.
436             * </p>
437             * 
438             * @param source
439             *            The source file, from which encoded data are read.
440             * @param target
441             *            The target file, in which decoded data are written.
442             * @throws IOException
443             *             If an I/O error occurs.
444             * @since 1.3
445             */
	public static void decode(File source, File target) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(source);
			outputStream = new FileOutputStream(target);
			decode(inputStream, outputStream);
			} finally {
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (Throwable t) {
						;
					}
				}
			}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (Throwable t) {
				;
			}
		}
	}

		/**
472             * Copies data from a stream to another.
473             * 
474             * @param inputStream
475             *            The input stream.
476             * @param outputStream
477             *            The output stream.
478             * @throws IOException
479             *             If a unexpected I/O error occurs.
480             */
	private static void copy(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// 1KB buffer
		byte[] b = new byte[1024]; int len;
		while ((len = inputStream.read(b)) != -1) {
			outputStream.write(b, 0, len);
		}
	}
}