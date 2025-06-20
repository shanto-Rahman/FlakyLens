@Test public void should_fail_if_given_parent_is_null(){
fail("expected a NullPointerException here");
assertThat(e).hasMessage("expected parent path should not be null");
}