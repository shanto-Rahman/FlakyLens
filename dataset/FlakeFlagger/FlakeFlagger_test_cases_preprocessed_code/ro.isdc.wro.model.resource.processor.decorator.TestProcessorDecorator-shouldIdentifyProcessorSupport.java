@Test public void shouldIdentifyProcessorSupport(){
when(supportAwareProcessor.isSupported()).thenReturn(true);//IT
assertEquals(true,decorator.isSupported());
when(supportAwareProcessor.isSupported()).thenReturn(false);//IT
assertEquals(false,decorator.isSupported());
}