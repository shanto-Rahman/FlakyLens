@Test public void shouldUseNullMBeanWhenNotSet() throws Exception {
assertNull(Context.get().getConfig().getMbeanName());
}