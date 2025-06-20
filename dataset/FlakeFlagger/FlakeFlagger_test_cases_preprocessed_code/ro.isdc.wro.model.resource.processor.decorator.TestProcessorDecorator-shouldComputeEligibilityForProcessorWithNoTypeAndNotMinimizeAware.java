@Test public void shouldComputeEligibilityForProcessorWithNoTypeAndNotMinimizeAware(){
assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(true,ResourceType.CSS));
assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(false,ResourceType.CSS));
assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(true,ResourceType.JS));
assertTrue(new ProcessorDecorator(noOpProcessor).isEligible(false,ResourceType.JS));
}