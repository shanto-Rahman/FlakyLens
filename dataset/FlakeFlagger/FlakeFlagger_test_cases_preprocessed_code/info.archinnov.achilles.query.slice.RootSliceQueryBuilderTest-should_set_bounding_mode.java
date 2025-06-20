@Test public void should_set_bounding_mode() throws Exception {
assertThat(builder.buildClusterQuery().getBounding()).isEqualTo(EXCLUSIVE_BOUNDS);
}