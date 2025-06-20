@Test public void should_fail_if_actual_is_not_in_array(){
objects.assertIsNotIn(info,"Yoda",values);//RW
verify(failures).failure(info,shouldNotBeIn("Yoda",values));//RW
}