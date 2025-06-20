@Test public void specificContextRoot() throws Exception {
assertThat(getResponse(getLocalUrl("/say/hello")),equalTo("Hello World"));
}