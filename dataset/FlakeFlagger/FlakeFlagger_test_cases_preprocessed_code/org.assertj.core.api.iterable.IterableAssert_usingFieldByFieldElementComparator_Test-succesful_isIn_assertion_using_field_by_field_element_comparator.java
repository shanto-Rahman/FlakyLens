@Test public void succesful_isIn_assertion_using_field_by_field_element_comparator(){
assertThat(list1).usingFieldByFieldElementComparator().isIn(singletonList(list2));
}