@Test public void testRefer() throws Exception {
assertThat(server.isStarted(),is(true));
assertThat(server.getPort(),is(12345));
assertThat(server.isAcceptForeignIp(),is(false));
}