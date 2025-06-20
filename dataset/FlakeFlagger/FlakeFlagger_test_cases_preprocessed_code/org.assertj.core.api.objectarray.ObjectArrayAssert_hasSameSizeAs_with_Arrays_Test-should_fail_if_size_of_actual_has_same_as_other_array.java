@Test public void should_fail_if_size_of_actual_has_same_as_other_array(){
assertThat(actual).hasSameSizeAs(other);
assertThat(e).hasMessage(shouldHaveSameSizeAs(actual,actual.length,other.length).create());
}