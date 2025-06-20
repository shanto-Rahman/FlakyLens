@Test public void assertFilterContentWithSensitiveIp(){
assertThat(SensitiveInfoUtils.filterSensitiveIps(actual),is(expected));
}