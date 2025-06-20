@Test public void testLiveStateUpdatesForReconfigure() throws Exception {
Assert.assertEquals(3,desiredEntity.getHostComponentDesiredConfigMappingEntities().size());
Assert.assertEquals(0,entities.size());
Assert.assertEquals(3,impl.getConfigVersions().size());
Assert.assertEquals(3,entities.size());
Assert.assertEquals(newConfigs.size(),impl.getConfigVersions().size());
Assert.assertEquals(3,entities.size());
LOG.debug("Found live config " + e.getConfigType() + ":"+ e.getVersionTag());//RW
Assert.assertTrue(e.getComponentName().equals("DATANODE") && e.getClusterId() == primaryKey.getClusterId() && e.getHostName().equals("h1") && e.getServiceName().equals("HDFS"));
if (e.getConfigType().equals("type1")) {
Assert.assertEquals("v1",e.getVersionTag());
if (e.getConfigType().equals("type2")) {
Assert.assertEquals("v3",e.getVersionTag());
if (e.getConfigType().equals("type4")) {
Assert.assertEquals("v5",e.getVersionTag());
fail("Found invalid type");
}
}
}
}