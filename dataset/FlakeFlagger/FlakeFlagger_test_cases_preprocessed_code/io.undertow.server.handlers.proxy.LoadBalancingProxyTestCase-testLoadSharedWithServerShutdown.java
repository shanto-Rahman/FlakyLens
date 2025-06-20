@Test public void testLoadSharedWithServerShutdown() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
server1.stop();//RW
server1.start();//RW
server2.stop();//RW
server2.start();//RW
Assert.assertTrue(resultString.toString().contains("server1"));
Assert.assertTrue(resultString.toString().contains("server2"));
}