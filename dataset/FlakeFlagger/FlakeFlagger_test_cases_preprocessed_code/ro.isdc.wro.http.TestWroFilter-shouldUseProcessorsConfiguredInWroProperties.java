@Test public void shouldUseProcessorsConfiguredInWroProperties() throws Exception {
assertEquals(1,factory.create().getProcessorsFactory().getPreProcessors().size());
}