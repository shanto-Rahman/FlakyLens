@Deployment public void testLocalization() throws Exception {
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(1,processes.size());
assertNull(processes.get(0).getName());
assertNull(processes.get(0).getDescription());
assertEquals(1,processes.size());
assertNull(processes.get(0).getName());
assertNull(processes.get(0).getDescription());
assertEquals(1,processes.size());
assertEquals("Historic Process Name 'en-GB'",processes.get(0).getName());
assertEquals("Historic Process Description 'en-GB'",processes.get(0).getDescription());
assertEquals(1,processes.size());
assertNull(processes.get(0).getName());
assertNull(processes.get(0).getDescription());
assertEquals(1,processes.size());
assertEquals("Historic Process Name 'en-GB'",processes.get(0).getName());
assertEquals("Historic Process Description 'en-GB'",processes.get(0).getDescription());
assertNull(process.getName());
assertNull(process.getDescription());
assertEquals("Historic Process Name 'en-GB'",process.getName());
assertEquals("Historic Process Description 'en-GB'",process.getDescription());
assertEquals("Historic Process Name 'en'",process.getName());
assertEquals("Historic Process Description 'en'",process.getDescription());
assertEquals("Historic Process Name 'en'",process.getName());
assertEquals("Historic Process Description 'en'",process.getDescription());
}
}