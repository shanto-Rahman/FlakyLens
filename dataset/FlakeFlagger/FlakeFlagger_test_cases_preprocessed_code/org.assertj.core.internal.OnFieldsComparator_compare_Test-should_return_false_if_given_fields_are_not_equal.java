@Test public void should_return_false_if_given_fields_are_not_equal(){
assertThat(onFieldsComparator.compare(actual,other)).isNotZero();
}