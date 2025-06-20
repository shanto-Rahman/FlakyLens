@Test public void should_throw_exception_when_date_is_null(){
assertThat(new Date()).hasSameTimeAs((String)null);
}