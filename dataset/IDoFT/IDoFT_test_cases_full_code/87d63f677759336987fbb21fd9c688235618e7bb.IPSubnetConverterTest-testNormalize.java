@Test public void testNormalize() throws Exception {
  final String defaultList="127.0.0.1/32, ::1/128";
  final String normalized="127.0.0.1/32,0:0:0:0:0:0:0:1/128";
  final Set<IpSubnet> results=converter.convertFrom(defaultList);
  assertThat(converter.convertTo(results)).isEqualTo(normalized);
}
