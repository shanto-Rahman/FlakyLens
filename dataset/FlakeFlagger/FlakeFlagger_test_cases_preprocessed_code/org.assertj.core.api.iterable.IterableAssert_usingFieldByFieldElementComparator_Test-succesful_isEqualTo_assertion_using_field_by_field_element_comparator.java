@Test public void succesful_isEqualTo_assertion_using_field_by_field_element_comparator(){
assertThat(list1).usingFieldByFieldElementComparator().isEqualTo(list2);
}