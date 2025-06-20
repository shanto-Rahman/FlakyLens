@Test public void shouldCreateOverridenManagerFactory(){
assertEquals(ConfigurableWroManagerFactory.class,victim.getFactory().getClass());
}