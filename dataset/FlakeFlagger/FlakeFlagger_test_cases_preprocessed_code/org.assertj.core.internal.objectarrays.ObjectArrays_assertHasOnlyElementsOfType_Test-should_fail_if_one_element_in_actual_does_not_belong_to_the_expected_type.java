@Test public void should_fail_if_one_element_in_actual_does_not_belong_to_the_expected_type(){
assertThat(e).hasMessage(shouldHaveOnlyElementsOfType(array,Long.class,Integer.class).create());
}