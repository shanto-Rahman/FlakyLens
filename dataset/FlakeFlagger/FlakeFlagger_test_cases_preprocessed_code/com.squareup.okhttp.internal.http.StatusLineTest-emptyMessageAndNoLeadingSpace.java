/** 
 * This is not defined in the protocol but some servers won't add the leading empty space when the message is empty. http://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html#sec6.1
 */
@Test public void emptyMessageAndNoLeadingSpace() throws IOException {
assertEquals("",statusLine.message());
assertEquals(version,statusLine.httpMinorVersion());
assertEquals(code,statusLine.code());
}