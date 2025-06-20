@Test public void testHttpVersionParsing() throws Exception {
Assert.assertEquals("HTTP protocol name","HTTP",version.getProtocol());
Assert.assertEquals("HTTP major version number",1,version.getMajor());
Assert.assertEquals("HTTP minor version number",1,version.getMinor());
Assert.assertEquals("HTTP version number",s,version.toString());
Assert.assertEquals("HTTP protocol name","HTTP",version.getProtocol());
Assert.assertEquals("HTTP major version number",123,version.getMajor());
Assert.assertEquals("HTTP minor version number",4567,version.getMinor());
Assert.assertEquals("HTTP version number",s,version.toString());
}