@Deployment public void testConcurrentIntermediateMessageEvent(){
assertNotNull(activeActivityIds);
assertEquals(2,activeActivityIds.size());
assertTrue(activeActivityIds.contains("messageCatch1"));
assertTrue(activeActivityIds.contains("messageCatch2"));
assertNotNull(executions);
assertEquals(2,executions.size());
assertNull(task);
assertNotNull(task);
}