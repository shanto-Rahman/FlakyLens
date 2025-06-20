@Test public void should_fail_if_actual_does_not_satisfy_condition_at_index(){
condition.shouldMatch(false);//RW
lists.assertHas(info,actual,condition,index);//RW
verify(failures).failure(info,shouldHaveAtIndex(actual,condition,index,"Luke"));//RW
}