public void testCustomDeploymentCacheUsed(){
assertNull(customCache.getCachedProcessDefinition());
assertNotNull(customCache.getCachedProcessDefinition());
}