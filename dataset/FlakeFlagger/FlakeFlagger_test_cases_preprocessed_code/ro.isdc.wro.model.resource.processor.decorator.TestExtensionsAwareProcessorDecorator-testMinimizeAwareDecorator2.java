@Test public void testMinimizeAwareDecorator2(){
Assert.assertFalse(new ProcessorDecorator(processor).isMinimize());
}