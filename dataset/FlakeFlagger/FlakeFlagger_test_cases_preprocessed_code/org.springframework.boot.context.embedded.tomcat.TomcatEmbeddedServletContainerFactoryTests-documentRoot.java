@Test public void documentRoot() throws Exception {
assertThat(getResponse(getLocalUrl("/test.txt")),equalTo("test"));
}