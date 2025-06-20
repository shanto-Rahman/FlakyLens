@Test public void testGeneric1() throws Exception {
assertThat(service.getGeneric(),equalTo(GENERIC_SERIALIZATION_DEFAULT));
assertThat(service.getGeneric(),equalTo(GENERIC_SERIALIZATION_NATIVE_JAVA));
assertThat(service.getGeneric(),equalTo(GENERIC_SERIALIZATION_BEAN));
}