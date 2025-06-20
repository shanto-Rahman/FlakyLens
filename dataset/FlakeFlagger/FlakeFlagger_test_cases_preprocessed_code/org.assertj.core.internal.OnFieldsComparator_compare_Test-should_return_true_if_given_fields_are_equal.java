@Test public void should_return_true_if_given_fields_are_equal(){
assertThat(onFieldsComparator.compare(actual,other)).isZero();
}