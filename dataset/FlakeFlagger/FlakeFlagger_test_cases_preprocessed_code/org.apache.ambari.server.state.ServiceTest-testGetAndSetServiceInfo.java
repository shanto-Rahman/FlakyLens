@Test public void testGetAndSetServiceInfo() throws AmbariException {
Assert.assertNotNull(service);
Assert.assertEquals("HDP-1.1.0",service.getDesiredStackVersion().getStackId());
Assert.assertEquals(State.INSTALLING,service.getDesiredState());
}