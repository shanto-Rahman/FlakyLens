@Test public void testReverseProxy() throws Exception {
Assert.assertEquals(2,results.size());
Assert.assertTrue(results.contains("server1"));
Assert.assertTrue(results.contains("server2"));
}