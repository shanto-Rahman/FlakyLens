@Test public void should_fail_when_actual_is_null(){
assertThat((Date)null).hasSameTimeAs(new Date());
}