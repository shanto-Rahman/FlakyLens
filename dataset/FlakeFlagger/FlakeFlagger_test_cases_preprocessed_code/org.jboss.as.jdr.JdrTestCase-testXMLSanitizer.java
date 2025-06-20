@Test public void testXMLSanitizer() throws Exception {
assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?><test><password/></test>",new String(buf));
}