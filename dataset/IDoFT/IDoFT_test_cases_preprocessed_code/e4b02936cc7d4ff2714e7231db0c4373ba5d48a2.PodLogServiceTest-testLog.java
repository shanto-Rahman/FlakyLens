@Test public void testLog() throws Throwable {
assertNotNull(logsMap);
assertEquals(6,logsMap.size());
assertTrue(logsMap.containsKey(temp.name));
assertEquals("test-log-" + i,new String(logsMap.get(temp.name).logs));
}