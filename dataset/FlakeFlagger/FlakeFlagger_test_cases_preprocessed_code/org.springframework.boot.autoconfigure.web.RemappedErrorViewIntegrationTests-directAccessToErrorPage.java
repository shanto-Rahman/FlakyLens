@Test public void directAccessToErrorPage() throws Exception {
assertTrue("Wrong content: " + content,content.contains("error"));
assertTrue("Wrong content: " + content,content.contains("999"));
}