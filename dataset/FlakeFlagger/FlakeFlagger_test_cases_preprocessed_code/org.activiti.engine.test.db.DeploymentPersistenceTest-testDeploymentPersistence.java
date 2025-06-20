public void testDeploymentPersistence(){
assertEquals(1,deployments.size());
assertEquals("strings",deployment.getName());
assertNotNull(deployment.getDeploymentTime());
assertEquals(expectedResourceNames,new HashSet<String>(resourceNames));
assertTrue(Arrays.equals("hello world".getBytes(),IoUtil.readInputStream(resourceStream,"test")));
assertTrue(Arrays.equals("42".getBytes(),IoUtil.readInputStream(resourceStream,"test")));
}