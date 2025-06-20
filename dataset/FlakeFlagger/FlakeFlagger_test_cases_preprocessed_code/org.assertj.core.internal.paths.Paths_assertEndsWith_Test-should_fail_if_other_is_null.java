@Test public void should_fail_if_other_is_null(){
fail("expected a NullPointerException here");
assertThat(e).hasMessage("the expected end path should not be null");
}