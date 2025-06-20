public void testDeploymentCacheLimit(){
assertEquals(0,processDefinitionCache.size());
if (i < processDefinitionCacheLimit) {
assertEquals(i,processDefinitionCache.size());
assertEquals(processDefinitionCacheLimit,processDefinitionCache.size());
}
}