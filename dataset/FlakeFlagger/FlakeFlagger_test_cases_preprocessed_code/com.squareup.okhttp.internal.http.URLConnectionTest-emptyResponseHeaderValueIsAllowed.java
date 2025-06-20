@Test public void emptyResponseHeaderValueIsAllowed() throws Exception {
assertEquals("",connection.getHeaderField("A"));
}