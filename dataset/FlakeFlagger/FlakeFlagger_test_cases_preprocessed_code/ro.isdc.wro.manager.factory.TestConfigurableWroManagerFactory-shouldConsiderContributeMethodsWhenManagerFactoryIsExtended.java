@Test public void shouldConsiderContributeMethodsWhenManagerFactoryIsExtended(){
assertFalse(manager.getProcessorsFactory().getPostProcessors().isEmpty());
assertFalse(manager.getProcessorsFactory().getPreProcessors().isEmpty());
}