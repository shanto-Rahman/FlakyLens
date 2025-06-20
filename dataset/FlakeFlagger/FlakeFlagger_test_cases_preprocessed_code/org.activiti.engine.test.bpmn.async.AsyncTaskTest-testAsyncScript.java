@Deployment public void testAsyncScript(){
assertEquals(1,managementService.createJobQuery().count());
if (e.getParentId() != null) {
}
assertNull(runtimeService.getVariable(eid,"invoked"));
assertEquals(0,managementService.createJobQuery().count());
assertEquals("true",runtimeService.getVariable(eid,"invoked"));
}