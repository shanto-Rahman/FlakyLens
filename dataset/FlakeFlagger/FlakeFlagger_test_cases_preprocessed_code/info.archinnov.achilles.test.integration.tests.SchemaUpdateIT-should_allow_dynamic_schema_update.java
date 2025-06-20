@Test public void should_allow_dynamic_schema_update() throws Exception {
assertThat(pm.find(EntityWithNewSimpleField.class,id)).isNotNull();
}