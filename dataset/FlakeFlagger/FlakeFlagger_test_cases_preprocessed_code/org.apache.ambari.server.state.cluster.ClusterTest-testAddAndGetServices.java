@Test public void testAddAndGetServices() throws AmbariException {
fail("Expected error on adding dup service");
Assert.assertNotNull(s);
Assert.assertEquals("HDFS",s.getName());
Assert.assertEquals(c1.getClusterId(),s.getClusterId());
fail("Expected error for unknown service");
Assert.assertEquals(2,services.size());
Assert.assertTrue(services.containsKey("HDFS"));
Assert.assertTrue(services.containsKey("MAPREDUCE"));
}