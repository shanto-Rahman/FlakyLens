@Test public void should_pass_if_actual_has_one_element_of_the_expected_type(){
assertThat(list).hasOnlyElementsOfType(Number.class).hasOnlyElementsOfType(Integer.class);
}