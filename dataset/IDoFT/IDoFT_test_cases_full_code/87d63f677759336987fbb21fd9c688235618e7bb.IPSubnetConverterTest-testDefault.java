@Test public void testDefault() throws Exception {
  final String defaultList="127.0.0.1/32,0:0:0:0:0:0:0:1/128";
  final Set<IpSubnet> results=converter.convertFrom(defaultList);
  assertThat(results).hasSize(2).contains(new IpSubnet("127.0.0.1/32")).contains(new IpSubnet("0:0:0:0:0:0:0:1/128"));
  assertThat(converter.convertTo(results)).isEqualTo(defaultList);
}
