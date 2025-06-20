@Test public void testErrorForBrowserClient() throws Exception {
assertTrue("Wrong content: " + content,content.contains("<html>"));
assertTrue("Wrong content: " + content,content.contains("999"));
}