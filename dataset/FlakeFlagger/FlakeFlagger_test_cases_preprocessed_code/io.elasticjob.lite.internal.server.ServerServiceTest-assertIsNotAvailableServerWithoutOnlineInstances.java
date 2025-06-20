@Test public void assertIsNotAvailableServerWithoutOnlineInstances(){
assertFalse(serverService.isAvailableServer("127.0.0.1"));
}