@Test public void should_check_consistency_annotation() throws Exception {
assertThat(parser.hasConsistencyAnnotation(field)).isTrue();
}