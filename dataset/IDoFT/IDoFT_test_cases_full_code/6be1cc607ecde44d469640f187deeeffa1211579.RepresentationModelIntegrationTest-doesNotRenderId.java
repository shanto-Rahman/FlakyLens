@Test void doesNotRenderId() throws Exception {
  RepresentationModel<?> model=new RepresentationModel<>();
  model.add(Link.of("localhost"));
  assertThat(write(model)).isEqualTo(REFERENCE);
}
