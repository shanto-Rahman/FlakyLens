@Test public void testParsingMalformedFirstHeader() throws Exception {
Assert.assertNotNull(headers);
Assert.assertEquals(2,headers.length);
Assert.assertEquals("header1",headers[0].getName());
Assert.assertEquals("stuff",headers[0].getValue());
Assert.assertEquals("header2",headers[1].getName());
Assert.assertEquals("stuff",headers[1].getValue());
}