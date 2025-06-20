@Test public void should_fail_if_actual_is_not_instance_of_any_type(){
objects.assertIsInstanceOfAny(info,actual,types);//RW
fail();
verify(failures).failure(info,shouldBeInstanceOfAny(actual,types));//RW
}