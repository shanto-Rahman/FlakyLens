@Test public void should_fail_if_actual_contains_value_at_index(){
lists.assertDoesNotContain(info,actual,"Yoda",index);//RW
verify(failures).failure(info,shouldNotContainAtIndex(actual,"Yoda",index));//RW
}