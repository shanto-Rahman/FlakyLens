@Test void getUsingCustomMediaType() throws Exception {
assertThat(results).isEqualTo(read(new ClassPathResource("webmvc-frodo.json",getClass())));
}