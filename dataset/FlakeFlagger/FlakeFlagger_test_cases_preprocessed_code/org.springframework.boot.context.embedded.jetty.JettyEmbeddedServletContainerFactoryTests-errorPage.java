@Test public void errorPage() throws Exception {
assertThat(getResponse(getLocalUrl("/hello")),equalTo("Hello World"));
assertThat(getResponse(getLocalUrl("/bang")),equalTo("Hello World"));
}