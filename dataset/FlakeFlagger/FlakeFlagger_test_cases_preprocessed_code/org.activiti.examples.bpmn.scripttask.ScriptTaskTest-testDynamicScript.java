@Deployment public void testDynamicScript(){
assertEquals(42,((Number)runtimeService.getVariable(processInstance.getId(),"test")).intValue());
assertEquals(22,((Number)runtimeService.getVariable(processInstance.getId(),"test2")).intValue());
}