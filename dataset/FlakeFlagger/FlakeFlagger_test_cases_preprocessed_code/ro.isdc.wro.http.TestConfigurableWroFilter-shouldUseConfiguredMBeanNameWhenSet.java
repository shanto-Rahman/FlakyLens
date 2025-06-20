@Test public void shouldUseConfiguredMBeanNameWhenSet() throws Exception {
assertEquals(mbeanName,Context.get().getConfig().getMbeanName());
}