@Test public void registerListenerWithCustomMulticaster() throws Exception {
assertThat(events,hasItem(isA(ApplicationPreparedEvent.class)));
assertThat(events,hasItem(isA(ContextRefreshedEvent.class)));
}