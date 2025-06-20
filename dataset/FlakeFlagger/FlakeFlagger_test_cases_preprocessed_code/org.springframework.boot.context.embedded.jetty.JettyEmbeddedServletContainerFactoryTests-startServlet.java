@Test public void startServlet() throws Exception {
assertThat(getResponse(getLocalUrl("/hello")),equalTo("Hello World"));
}