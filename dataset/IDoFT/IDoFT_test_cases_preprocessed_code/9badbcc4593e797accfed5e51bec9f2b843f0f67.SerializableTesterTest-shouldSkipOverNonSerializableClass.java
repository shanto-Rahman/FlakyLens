@Test public void shouldSkipOverNonSerializableClass(){
assertThat(eventsForLogger.size(),is(1));
assertThat(eventsForLogger.get(0).getMessage().toString(),is("Class [" + nonSerializableClassClass + "] is not serializable, skipping validation"));
}