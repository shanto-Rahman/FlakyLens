@Deployment public void testAutoStoreVariables(){
assertNull(runtimeService.getVariable(id,"sum"));
assertEquals(42,((Number)runtimeService.getVariable(id,"sum")).intValue());
}