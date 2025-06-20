@Deployment public void testFieldInjection(){
assertEquals("HELLO WORLD",runtimeService.getVariable(execution.getId(),"var"));
assertEquals("HELLO SETTER",runtimeService.getVariable(execution.getId(),"setterVar"));
}