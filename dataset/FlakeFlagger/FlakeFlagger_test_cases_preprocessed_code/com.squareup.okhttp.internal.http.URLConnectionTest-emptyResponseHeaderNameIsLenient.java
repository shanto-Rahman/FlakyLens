@Test public void emptyResponseHeaderNameIsLenient() throws Exception {
assertEquals("A",connection.getHeaderField(""));
}