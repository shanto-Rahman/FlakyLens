@Test public void should_fail_if_actual_is_instance_of_type(){
objects.assertIsNotInstanceOf(info,actual,Person.class);//RW
fail();
verify(failures).failure(info,shouldNotBeInstance(actual,Person.class));//RW
}