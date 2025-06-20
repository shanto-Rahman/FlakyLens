@Test public void errorPageAvailableWithMvcIncluded() throws Exception {
assertTrue("Wrong content: " + content,content.contains("status=999"));
}