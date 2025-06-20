@Test public void should_derive_getter_for_boolean_primitive() throws Exception {
assertThat(getterNames).hasSize(2);
assertThat(getterNames[0]).isEqualTo("isOld");
assertThat(getterNames[1]).isEqualTo("getOld");
}