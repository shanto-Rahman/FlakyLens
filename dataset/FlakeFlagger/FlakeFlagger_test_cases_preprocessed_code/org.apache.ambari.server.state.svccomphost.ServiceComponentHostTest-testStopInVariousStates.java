@Test public void testStopInVariousStates() throws AmbariException, InvalidStateTransitionException {
Assert.assertEquals(startTime,impl.getLastOpStartTime());
Assert.assertEquals(-1,impl.getLastOpLastUpdateTime());
Assert.assertEquals(-1,impl.getLastOpEndTime());
Assert.assertEquals(State.STOPPING,impl.getState());
Assert.assertTrue("Exception not thrown on invalid event",exceptionThrown);
Assert.assertEquals(startTime,impl.getLastOpStartTime());
Assert.assertEquals(-1,impl.getLastOpLastUpdateTime());
Assert.assertEquals(-1,impl.getLastOpEndTime());
Assert.assertEquals(startTime,impl.getLastOpStartTime());
Assert.assertEquals(-1,impl.getLastOpLastUpdateTime());
Assert.assertEquals(-1,impl.getLastOpEndTime());
Assert.assertEquals(State.STOPPING,impl.getState());
}