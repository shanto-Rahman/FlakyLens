@Test public void testAcceptClient() throws Exception {
thread.start();
while (retries-- > 0 && !localClient.isConnected()) {
  localClient.wait(10);
}//IT
assertTrue(localClient.isConnected());//IT
localClient.close();//IT
assertNotNull(client);
}