@Test public void testSetThreadName() throws Exception {
assertThat(url.getParameter(Constants.THREAD_NAME_KEY),equalTo("custom-thread-localhost:1234"));
}