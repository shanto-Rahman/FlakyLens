@Test public void should_load_property() throws Exception {
assertThat(facade.loadProperty(idMeta)).isSameAs(row);
}