@Test public void testHttpVersionParsingUsingCursor() throws Exception {
Assert.assertEquals("HTTP protocol name","HTTP",version.getProtocol());
Assert.assertEquals("HTTP major version number",1,version.getMajor());
Assert.assertEquals("HTTP minor version number",1,version.getMinor());
Assert.assertEquals("HTTP version number","HTTP/1.1",version.toString());
Assert.assertEquals(s.length(),cursor.getPos());
Assert.assertTrue(cursor.atEnd());
Assert.assertEquals("HTTP protocol name","HTTP",version.getProtocol());
Assert.assertEquals("HTTP major version number",1,version.getMajor());
Assert.assertEquals("HTTP minor version number",123,version.getMinor());
Assert.assertEquals("HTTP version number","HTTP/1.123",version.toString());
Assert.assertEquals(' ',buffer.charAt(cursor.getPos()));
Assert.assertEquals(s.length() - 4,cursor.getPos());
Assert.assertFalse(cursor.atEnd());
}