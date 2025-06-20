@Test public void testTelnet() throws Exception {
assertThat(protocol.getTelnet(),equalTo("mocktelnethandler"));
}