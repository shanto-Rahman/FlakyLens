@Test public void testCreateServiceComponentMultiple() throws AmbariException {
Assert.assertEquals(1,c1.getService("HDFS").getServiceComponents().size());
Assert.assertEquals(2,c1.getService("MAPREDUCE").getServiceComponents().size());
Assert.assertNotNull(c1.getService("HDFS").getServiceComponent("NAMENODE"));
Assert.assertNotNull(c1.getService("MAPREDUCE").getServiceComponent("JOBTRACKER"));
Assert.assertNotNull(c1.getService("MAPREDUCE").getServiceComponent("TASKTRACKER"));
}