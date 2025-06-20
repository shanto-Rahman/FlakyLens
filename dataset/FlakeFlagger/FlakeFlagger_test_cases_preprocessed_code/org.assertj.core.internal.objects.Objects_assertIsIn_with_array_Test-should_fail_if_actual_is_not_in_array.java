@Test public void should_fail_if_actual_is_not_in_array(){
objects.assertIsIn(info,"Luke",values);//RW
verify(failures).failure(info,shouldBeIn("Luke",values));//RW
}