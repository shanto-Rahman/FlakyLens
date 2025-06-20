@Test public void testUpdateHostRole() throws Exception {
assertEquals(1,commandEntities.size());
assertNotNull(command);
assertEquals(largeString,command.getStdout());
}