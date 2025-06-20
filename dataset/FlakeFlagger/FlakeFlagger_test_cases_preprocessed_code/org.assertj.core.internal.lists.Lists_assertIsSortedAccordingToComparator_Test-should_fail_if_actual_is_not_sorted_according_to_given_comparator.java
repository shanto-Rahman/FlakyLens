@Test public void should_fail_if_actual_is_not_sorted_according_to_given_comparator(){
lists.assertIsSortedAccordingToComparator(info,actual,stringDescendingOrderComparator);//RW
verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(3,actual,stringDescendingOrderComparator));//RW
}