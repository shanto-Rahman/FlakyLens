@Test public void createFromConfigClass() throws Exception {
assertNotNull(server);
assertEquals(9000,server.getPort().intValue());
verify(containerFactory).setPort(9000);//RW
}