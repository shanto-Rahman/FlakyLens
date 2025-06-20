@Test void shouldUseOriginalStackTracePlugin() throws Exception {
  assertThat(getPlugins(example),contains(asList(instanceOf(Plugin.class),instanceOf(Plugin.class),instanceOf(Plugin.class),instanceOf(MicrometerPlugin.class),instanceOf(LogbookPlugin.class),instanceOf(OpenTracingPlugin.class),instanceOf(OriginalStackTracePlugin.class))));
}
