@Test public void should_fail_if_actual_is_not_instance_of_type(){
objects.assertIsInstanceOf(info,actual,String.class);//RW
verify(failures).failure(info,shouldBeInstance(actual,String.class));//RW
}