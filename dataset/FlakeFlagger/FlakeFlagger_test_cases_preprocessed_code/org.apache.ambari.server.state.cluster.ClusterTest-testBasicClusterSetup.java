@Test public void testBasicClusterSetup() throws AmbariException {
fail("Exception expected for invalid cluster");
Assert.assertNotNull(c2);
Assert.assertEquals(clusterName,c2.getClusterName());
Assert.assertEquals("foo2",c2.getClusterName());
Assert.assertNotNull(c2.getDesiredStackVersion());
Assert.assertEquals("",c2.getDesiredStackVersion().getStackId());
Assert.assertEquals("HDP-1.0",c2.getDesiredStackVersion().getStackId());
}