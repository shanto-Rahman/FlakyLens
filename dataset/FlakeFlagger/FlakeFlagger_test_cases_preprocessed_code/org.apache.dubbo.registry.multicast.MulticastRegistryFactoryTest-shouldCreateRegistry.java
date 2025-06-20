@Test public void shouldCreateRegistry(){
assertThat(registry,not(nullValue()));
assertThat(registry.isAvailable(),is(true));
}