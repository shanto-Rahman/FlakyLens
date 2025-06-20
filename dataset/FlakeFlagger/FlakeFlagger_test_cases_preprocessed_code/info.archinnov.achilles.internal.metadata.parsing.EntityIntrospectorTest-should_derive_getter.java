@Test public void should_derive_getter() throws Exception {
assertThat(getterNames).hasSize(1);
assertThat(getterNames[0]).isEqualTo("getOld");
}