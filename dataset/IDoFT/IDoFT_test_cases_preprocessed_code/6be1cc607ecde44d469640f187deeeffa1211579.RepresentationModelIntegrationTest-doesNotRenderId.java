@Test void doesNotRenderId() throws Exception {
assertThat(write(model)).isEqualTo(REFERENCE);
}