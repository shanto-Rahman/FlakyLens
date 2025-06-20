@Test public void configuresInMemoryTraceRepository() throws Exception {
assertNotNull(context.getBean(InMemoryTraceRepository.class));
}