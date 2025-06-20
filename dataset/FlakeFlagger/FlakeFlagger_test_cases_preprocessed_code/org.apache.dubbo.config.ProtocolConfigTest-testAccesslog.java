@Test public void testAccesslog() throws Exception {
assertThat(protocol.getAccesslog(),equalTo("access.log"));
}