@Deployment public void testFailingAsyncServiceTimer(){
assertEquals(1,managementService.createJobQuery().count());
fail();
if (e.getParentId() != null) {
}
assertNotNull(execution);
assertEquals("service",runtimeService.getActiveActivityIds(execution.getId()).get(0));
assertEquals(1,managementService.createTimerJobQuery().count());
}