@Deployment public void testExpressionOnTimer(){
assertEquals(1,jobs.size());
assertEquals(0L,jobQuery.count());
assertFalse(listenerExecutedStartEvent);//RW
assertTrue(listenerExecutedEndEvent);//RW
}