@Test public void can_capture_exception_and_then_assert_following_AAA_or_BDD_style(){
assertThat(boom).isInstanceOf(Exception.class).hasMessageContaining("boom");
}