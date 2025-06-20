@Test public void should_fail_if_actual_size_is_not_equal_to_other_size(){
assertThat(e).hasMessage(shouldHaveSameSizeAs(actual,actual.size(),other.length).create(null,info.representation()));
}