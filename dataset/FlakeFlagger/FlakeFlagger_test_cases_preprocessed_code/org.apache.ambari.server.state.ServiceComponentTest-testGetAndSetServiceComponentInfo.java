@Test public void testGetAndSetServiceComponentInfo() throws AmbariException {
Assert.assertNotNull(sc);
Assert.assertEquals(State.INSTALLED,sc.getDesiredState());
Assert.assertEquals("HDP-1.0.0",sc.getDesiredStackVersion().getStackId());
Assert.assertNotNull(sc1);
Assert.assertEquals(State.INSTALLED,sc1.getDesiredState());
Assert.assertEquals("HDP-1.0.0",sc1.getDesiredStackVersion().getStackId());
}