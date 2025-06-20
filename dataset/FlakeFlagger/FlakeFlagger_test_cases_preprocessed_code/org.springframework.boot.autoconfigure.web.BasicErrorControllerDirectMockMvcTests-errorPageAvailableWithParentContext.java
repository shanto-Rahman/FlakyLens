@Test public void errorPageAvailableWithParentContext() throws Exception {
assertTrue("Wrong content: " + content,content.contains("status=999"));
}