@Test public void testErrorWithEscape() throws Exception {
assertTrue("Wrong content: " + content,content.contains("&lt;script&gt;"));
assertTrue("Wrong content: " + content,content.contains("Hello World"));
assertTrue("Wrong content: " + content,content.contains("999"));
}