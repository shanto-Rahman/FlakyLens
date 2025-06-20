@Deployment public void testSingleIntermediateMessageExpressionEvent(){
assertNotNull(activeActivityIds);
assertEquals(1,activeActivityIds.size());
assertTrue(activeActivityIds.contains("messageCatch"));
assertNotNull(execution);
assertNotNull(task);
}