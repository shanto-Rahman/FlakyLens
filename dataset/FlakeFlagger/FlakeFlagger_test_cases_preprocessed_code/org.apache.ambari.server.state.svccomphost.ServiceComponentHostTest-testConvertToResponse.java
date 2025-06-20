@Test public void testConvertToResponse() throws AmbariException {
Assert.assertEquals("HDFS",r.getServiceName());
Assert.assertEquals("DATANODE",r.getComponentName());
Assert.assertEquals("h1",r.getHostname());
Assert.assertEquals("C1",r.getClusterName());
Assert.assertEquals(State.INSTALLED.toString(),r.getDesiredState());
Assert.assertEquals(State.INSTALLING.toString(),r.getLiveState());
Assert.assertEquals("HDP-1.0.0",r.getStackVersion());
Assert.assertFalse(sb.toString().isEmpty());
}