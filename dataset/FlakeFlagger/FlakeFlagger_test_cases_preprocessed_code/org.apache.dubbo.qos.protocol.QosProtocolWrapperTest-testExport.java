@Test public void testExport() throws Exception {
assertThat(server.isStarted(),is(true));
assertThat(server.getPort(),is(12345));
assertThat(server.isAcceptForeignIp(),is(false));
}