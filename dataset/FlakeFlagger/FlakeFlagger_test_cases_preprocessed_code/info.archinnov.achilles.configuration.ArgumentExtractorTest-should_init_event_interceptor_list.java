@Test public void should_init_event_interceptor_list() throws Exception {
assertThat(interceptorsResult).containsExactly(interceptor1,interceptor2);
}