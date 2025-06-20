@Test public void basicSsl() throws Exception {
assertThat(getResponse(getLocalUrl("https","/test.txt"),requestFactory),equalTo("test"));
}