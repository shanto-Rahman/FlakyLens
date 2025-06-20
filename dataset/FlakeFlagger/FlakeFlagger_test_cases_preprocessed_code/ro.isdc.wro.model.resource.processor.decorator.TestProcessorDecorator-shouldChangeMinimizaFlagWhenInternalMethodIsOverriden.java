@Test public void shouldChangeMinimizaFlagWhenInternalMethodIsOverriden(){
assertFalse(new ProcessorDecorator(processor).isMinimize());
}