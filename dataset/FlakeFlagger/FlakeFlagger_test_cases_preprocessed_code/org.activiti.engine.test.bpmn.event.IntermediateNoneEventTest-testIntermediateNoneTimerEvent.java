@Deployment public void testIntermediateNoneTimerEvent() throws Exception {
assertFalse(listenerExecuted);//RW
assertTrue(listenerExecuted);//RW
}