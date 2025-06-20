@Test public void skipsIfRepositoryExists() throws Exception {
assertThat(context.getBeansOfType(InMemoryTraceRepository.class).size(),equalTo(0));
assertThat(context.getBeansOfType(TraceRepository.class).size(),equalTo(1));
}