@Test public void startServletAndFilter() throws Exception {
assertThat(getResponse(getLocalUrl("/hello")),equalTo("[Hello World]"));
}