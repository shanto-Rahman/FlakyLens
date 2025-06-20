@Test public void testServiceComponentUpdateRecursive() throws AmbariException {
fail("Expected failure for invalid state update");
fail("Expected failure for invalid state update");
Assert.assertEquals(State.INSTALLED,s1.getDesiredState());
Assert.assertEquals(State.INSTALLED,sc1.getDesiredState());
Assert.assertEquals(State.INSTALLED,sc2.getDesiredState());
Assert.assertEquals(State.INSTALLED,sc3.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch1.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch2.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch3.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch4.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch5.getDesiredState());
Assert.assertEquals(State.STARTED,sch1.getState());
Assert.assertEquals(State.INIT,sch2.getState());
Assert.assertEquals(State.INSTALLED,sch3.getState());
Assert.assertEquals(State.STOP_FAILED,sch4.getState());
Assert.assertEquals(State.INIT,sch5.getState());
Assert.assertTrue(!stages.isEmpty());
Assert.assertNull(trackAction);
}