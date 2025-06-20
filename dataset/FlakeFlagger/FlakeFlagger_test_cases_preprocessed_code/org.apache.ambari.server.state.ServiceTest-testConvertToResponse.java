@Test public void testConvertToResponse() throws AmbariException {
Assert.assertNotNull(service);
Assert.assertEquals(s.getName(),r.getServiceName());
Assert.assertEquals(s.getCluster().getClusterName(),r.getClusterName());
Assert.assertEquals(s.getDesiredStackVersion().getStackId(),r.getDesiredStackVersion());
Assert.assertEquals(s.getDesiredState().toString(),r.getDesiredState());
Assert.assertEquals(s.getName(),r.getServiceName());
Assert.assertEquals(s.getCluster().getClusterName(),r.getClusterName());
Assert.assertEquals(s.getDesiredStackVersion().getStackId(),r.getDesiredStackVersion());
Assert.assertEquals(s.getDesiredState().toString(),r.getDesiredState());
Assert.assertFalse(sb.toString().isEmpty());
}