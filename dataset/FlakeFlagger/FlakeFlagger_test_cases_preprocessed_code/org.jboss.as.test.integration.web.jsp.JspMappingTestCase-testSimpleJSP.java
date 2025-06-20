@Test public void testSimpleJSP() throws Exception {
log.trace("Simple JSP");//RW
assertThat(content,containsString("1 + 1 = 2"));
}