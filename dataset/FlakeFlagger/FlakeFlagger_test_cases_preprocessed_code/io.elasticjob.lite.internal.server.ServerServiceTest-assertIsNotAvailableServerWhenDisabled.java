@Test public void assertIsNotAvailableServerWhenDisabled(){
assertFalse(serverService.isAvailableServer("127.0.0.1"));
}