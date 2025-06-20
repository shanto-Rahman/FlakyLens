@Test public void should_return_null_when_bean_validation_disabled() throws Exception {
assertThat(extractor.initValidator(params)).isNull();
}