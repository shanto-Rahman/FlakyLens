@Test public void addInputStreamShouldThrowActivitiExceptionWhenIOExceptionIsThrown() throws Exception {
assertThat(thrown).isInstanceOf(ActivitiException.class).hasMessageContaining("Couldn't auto deploy resource");
}