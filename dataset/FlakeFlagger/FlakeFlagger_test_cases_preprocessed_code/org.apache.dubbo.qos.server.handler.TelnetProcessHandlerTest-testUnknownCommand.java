@Test public void testUnknownCommand() throws Exception {
assertThat(captor.getAllValues(),contains("unknown :no such command","\r\ndubbo>"));
}