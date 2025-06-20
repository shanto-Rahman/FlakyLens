@Test public void testLoadShared() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertTrue(resultString.toString().contains("server1"));
Assert.assertTrue(resultString.toString().contains("server2"));
}