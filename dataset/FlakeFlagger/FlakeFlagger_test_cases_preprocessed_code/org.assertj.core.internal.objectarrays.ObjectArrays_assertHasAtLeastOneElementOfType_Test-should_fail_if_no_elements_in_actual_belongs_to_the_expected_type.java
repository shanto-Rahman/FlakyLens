@Test public void should_fail_if_no_elements_in_actual_belongs_to_the_expected_type(){
assertThat(e).hasMessage(shouldHaveAtLeastOneElementOfType(array,Float.class).create());
}