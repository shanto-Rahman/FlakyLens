@Test public void testConvertToResponse() throws AmbariException {
Assert.assertNotNull(sc);
Assert.assertEquals(sc.getClusterName(),r.getClusterName());
Assert.assertEquals(sc.getClusterId(),r.getClusterId().longValue());
Assert.assertEquals(sc.getName(),r.getComponentName());
Assert.assertEquals(sc.getServiceName(),r.getServiceName());
Assert.assertEquals(sc.getDesiredStackVersion().getStackId(),r.getDesiredStackVersion());
Assert.assertEquals(sc.getDesiredState().toString(),r.getDesiredState());
Assert.assertFalse(sb.toString().isEmpty());
}