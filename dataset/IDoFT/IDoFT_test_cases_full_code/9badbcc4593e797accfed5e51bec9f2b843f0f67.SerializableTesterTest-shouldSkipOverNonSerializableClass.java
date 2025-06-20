@Test public void shouldSkipOverNonSerializableClass(){
  final Class<?> nonSerializableClassClass=SerializableTest_NonSerializableClass.class;
  CommonCode.shouldPassTesterValidation(serializableTester,nonSerializableClassClass);
  final List<LoggingEvent> eventsForLogger=spyAppender.getEventsForLogger(testerClass);
  assertThat(eventsForLogger.size(),is(1));
  assertThat(eventsForLogger.get(0).getMessage().toString(),is("Class [" + nonSerializableClassClass + "] is not serializable, skipping validation"));
}
