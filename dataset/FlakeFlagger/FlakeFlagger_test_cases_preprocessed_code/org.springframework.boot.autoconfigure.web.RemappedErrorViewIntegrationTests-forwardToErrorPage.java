@Test public void forwardToErrorPage() throws Exception {
assertTrue("Wrong content: " + content,content.contains("error"));
assertTrue("Wrong content: " + content,content.contains("500"));
}