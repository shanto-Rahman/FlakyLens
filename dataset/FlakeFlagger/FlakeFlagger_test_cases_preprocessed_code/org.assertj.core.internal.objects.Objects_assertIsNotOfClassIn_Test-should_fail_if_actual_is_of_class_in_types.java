@Test public void should_fail_if_actual_is_of_class_in_types(){
objects.assertIsNotOfAnyClassIn(info,actual,types);//RW
verify(failures).failure(info,shouldNotBeOfClassIn(actual,types));//RW
}