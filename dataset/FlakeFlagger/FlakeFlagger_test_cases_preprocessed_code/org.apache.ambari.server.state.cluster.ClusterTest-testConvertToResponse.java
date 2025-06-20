@Test public void testConvertToResponse() throws AmbariException {
Assert.assertEquals(c1.getClusterId(),r.getClusterId().longValue());
Assert.assertEquals(c1.getClusterName(),r.getClusterName());
Assert.assertEquals(1,r.getHostNames().size());
}