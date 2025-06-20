@Test public void shouldUseCorrectDefaultModelFactory(){
assertEquals(SmartWroModelFactory.class,configurableModelFactory.getConfiguredStrategy().getClass());
}