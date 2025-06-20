@Test public void should_return_null_elements_for_null_property_value(){
assertThat(ages).containsExactly(null,null);
assertThat(ages).containsExactly(800,26,null,null);
}