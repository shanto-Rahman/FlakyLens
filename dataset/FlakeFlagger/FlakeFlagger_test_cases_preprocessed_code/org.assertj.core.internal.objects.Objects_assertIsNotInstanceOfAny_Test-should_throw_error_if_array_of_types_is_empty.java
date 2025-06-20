@Test public void should_throw_error_if_array_of_types_is_empty(){
objects.assertIsNotInstanceOfAny(someInfo(),actual,new Class<?>[0]);//RW
}