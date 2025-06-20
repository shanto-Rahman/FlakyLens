@Test public void testGetAndSetBasicInfo() throws AmbariException {
Assert.assertEquals(State.INSTALLING,sch.getState());
Assert.assertEquals(State.INSTALLED,sch.getDesiredState());
Assert.assertEquals("HDP-1.0.0",sch.getStackVersion().getStackId());
Assert.assertEquals("HDP-1.1.0",sch.getDesiredStackVersion().getStackId());
}