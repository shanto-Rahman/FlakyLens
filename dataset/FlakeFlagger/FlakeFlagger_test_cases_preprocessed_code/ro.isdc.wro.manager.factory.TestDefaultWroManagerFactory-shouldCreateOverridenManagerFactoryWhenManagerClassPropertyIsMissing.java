@Test public void shouldCreateOverridenManagerFactoryWhenManagerClassPropertyIsMissing(){
assertEquals(ConfigurableWroManagerFactory.class,victim.getFactory().getClass());
}