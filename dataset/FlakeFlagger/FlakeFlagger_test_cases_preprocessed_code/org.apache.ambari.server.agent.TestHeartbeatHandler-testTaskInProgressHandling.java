@Test public void testTaskInProgressHandling() throws AmbariException, InvalidStateTransitionException {
assertEquals("Host state should still be installing",State.INSTALLING,componentState1);
}