@Test public void should_recover_from_exception_and_reinit_consistency_level() throws Exception {
assertThat(exceptionCaught).isTrue();
assertThat(newBean).isNotNull();
assertThat(newBean.getName()).isEqualTo("name");
}