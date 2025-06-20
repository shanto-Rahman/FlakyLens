@Test public void testRegistry() throws Exception {
assertThat(module.getRegistry(),sameInstance(registry));
}