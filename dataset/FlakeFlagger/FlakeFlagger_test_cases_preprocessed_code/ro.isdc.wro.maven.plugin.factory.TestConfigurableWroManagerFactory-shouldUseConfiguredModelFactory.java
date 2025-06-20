@Test public void shouldUseConfiguredModelFactory(){
assertEquals(XmlModelFactory.class,configurableModelFactory.getConfiguredStrategy().getClass());
}