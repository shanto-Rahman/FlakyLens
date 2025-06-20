@Test @Sql(scripts="/controller/test-release.sql",executionPhase=ExecutionPhase.BEFORE_TEST_METHOD) @Sql(scripts="/controller/cleanup.sql",executionPhase=ExecutionPhase.AFTER_TEST_METHOD) public void testReleaseBuild(){
Assert.assertEquals("someAppId",app.getAppId());
Assert.assertEquals("default",cluster.getName());
Assert.assertEquals("application",namespace.getNamespaceName());
Assert.assertEquals(3,items.length);
Assert.assertEquals(HttpStatus.OK,response.getStatusCode());
Assert.assertEquals("someReleaseName",release.getName());
Assert.assertEquals("someComment",release.getComment());
Assert.assertEquals("someAppId",release.getAppId());
Assert.assertEquals("default",release.getClusterName());
Assert.assertEquals("application",release.getNamespaceName());
Assert.assertEquals(GSON.toJson(configurations),release.getConfigurations());
}