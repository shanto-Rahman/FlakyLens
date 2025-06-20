@Test void shouldUseBackupRequestPlugin() throws Exception {
assertThat(getPlugins(baz),contains(asList(instanceOf(Plugin.class),instanceOf(Plugin.class),instanceOf(Plugin.class),instanceOf(MicrometerPlugin.class),instanceOf(FailsafePlugin.class),instanceOf(FailsafePlugin.class))));
}