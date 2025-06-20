@Test public void should_fail_if_actual_does_not_satisfy_condition_at_index(){
condition.shouldMatch(false);//RW
lists.assertIs(info,actual,condition,index);//RW
verify(failures).failure(info,shouldBeAtIndex(actual,condition,index,"Luke"));//RW
}