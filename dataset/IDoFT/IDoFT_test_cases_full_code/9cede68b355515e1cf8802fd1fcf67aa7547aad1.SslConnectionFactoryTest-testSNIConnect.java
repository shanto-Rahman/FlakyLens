@Test public void testSNIConnect() throws Exception {
  String response=getResponse("localhost","localhost","jetty.eclipse.org");
  assertThat(response,Matchers.containsString("host=localhost"));
}
