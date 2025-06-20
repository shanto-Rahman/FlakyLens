@Test public void shouldLoadValidManagerClassConfiguredInProperties(){
assertEquals(NoProcessorsWroManagerFactory.class,victim.getFactory().getClass());
}