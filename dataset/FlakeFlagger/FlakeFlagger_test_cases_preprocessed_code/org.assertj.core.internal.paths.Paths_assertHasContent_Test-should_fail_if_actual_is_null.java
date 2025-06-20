@Test public void should_fail_if_actual_is_null(){
paths.assertHasContent(someInfo(),null,expected,charset);//RW
}