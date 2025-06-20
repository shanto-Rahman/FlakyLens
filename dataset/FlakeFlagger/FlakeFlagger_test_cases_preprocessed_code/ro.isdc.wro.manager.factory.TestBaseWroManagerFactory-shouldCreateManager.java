@Test public void shouldCreateManager() throws Exception {
Assert.assertNotNull(manager);
Assert.assertEquals(NoOpNamingStrategy.class,manager.getNamingStrategy().getClass());
}