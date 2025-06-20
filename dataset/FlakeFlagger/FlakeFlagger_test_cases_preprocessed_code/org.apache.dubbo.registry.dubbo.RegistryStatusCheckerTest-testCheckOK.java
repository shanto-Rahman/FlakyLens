@Test public void testCheckOK(){
assertEquals(Status.Level.OK,new RegistryStatusChecker().check().getLevel());
Assert.assertTrue(message.contains(registryUrl.getAddress() + "(connected)"));
Assert.assertTrue(message.contains(registryUrl2.getAddress() + "(connected)"));
}