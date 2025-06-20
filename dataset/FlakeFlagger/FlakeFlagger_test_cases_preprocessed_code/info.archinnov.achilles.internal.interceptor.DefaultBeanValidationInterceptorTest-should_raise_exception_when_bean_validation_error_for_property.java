@SuppressWarnings({"unchecked"}) @Test public void should_raise_exception_when_bean_validation_error_for_property() throws Exception {
assertThat(ex.getMessage()).isEqualTo("Bean validation error : \n\tproperty 'property' of class 'java.lang.String' violation\n");
assertThat(exceptionRaised).isTrue();
}