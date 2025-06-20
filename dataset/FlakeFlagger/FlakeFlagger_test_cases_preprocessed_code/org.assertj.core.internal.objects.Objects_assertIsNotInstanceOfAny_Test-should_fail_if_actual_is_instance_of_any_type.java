@Test public void should_fail_if_actual_is_instance_of_any_type(){
objects.assertIsNotInstanceOfAny(info,actual,types);//RW
fail();
verify(failures).failure(info,shouldNotBeInstanceOfAny(actual,types));//RW
}