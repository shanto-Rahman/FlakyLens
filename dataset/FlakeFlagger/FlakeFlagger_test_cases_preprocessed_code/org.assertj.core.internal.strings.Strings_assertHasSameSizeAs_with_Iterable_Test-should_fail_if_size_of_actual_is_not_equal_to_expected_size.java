@Test public void should_fail_if_size_of_actual_is_not_equal_to_expected_size(){
strings.assertHasSameSizeAs(info,actual,other);//RW
assertThat(e).hasMessage(shouldHaveSameSizeAs(actual,actual.length(),other.size()).create(null,info.representation()));//RW
}