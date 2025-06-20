@Test public void should_have_annotation() throws Exception {
assertThat(filter.hasAnnotation(name,Column.class)).isTrue();
}