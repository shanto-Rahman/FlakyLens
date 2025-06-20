@Test public void should_fail_if_actual_has_same_type_as_other(){
objects.assertDoesNotHaveSameClassAs(info,actual,new Person("Luke"));//RW
verify(failures).failure(info,shouldNotHaveSameClass(actual,new Person("Luke")));//RW
}