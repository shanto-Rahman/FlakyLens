@Test public void should_fail_if_actual_is_null(){
assertThat(actual).hasSameSizeAs(new String[]{"1"});
}