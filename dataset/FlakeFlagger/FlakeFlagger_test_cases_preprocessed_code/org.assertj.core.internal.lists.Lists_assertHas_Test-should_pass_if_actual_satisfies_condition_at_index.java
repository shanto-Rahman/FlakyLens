@Test public void should_pass_if_actual_satisfies_condition_at_index(){
condition.shouldMatch(true);//RW
lists.assertHas(someInfo(),actual,condition,someIndex());//RW
}