@Test public void wrappedHandlers() throws Exception {
assertThat(getResponse(getLocalUrl("/hello")),equalTo("Hello World"));
}