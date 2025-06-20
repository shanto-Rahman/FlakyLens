@Test public void testRegistry() throws Exception {
assertThat(application.getRegistry(),sameInstance(registry));
assertThat(application.getRegistries(),contains(registry));
assertThat(application.getRegistries(),hasSize(1));
}