@Test public void should_fail_if_actual_is_null(){
files.assertHasContent(someInfo(),null,expected,charset);//RW
}