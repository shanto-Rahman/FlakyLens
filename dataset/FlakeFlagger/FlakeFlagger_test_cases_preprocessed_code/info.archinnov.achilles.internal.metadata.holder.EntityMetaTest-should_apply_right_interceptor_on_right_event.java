@Test public void should_apply_right_interceptor_on_right_event() throws Exception {
Assertions.assertThat(bean.getAge()).isEqualTo(30L);
Assertions.assertThat(bean.getAge()).isEqualTo(35L);
}