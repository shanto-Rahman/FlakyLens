@Test public void itBindsStoredAsJsonBeanCorrectly() throws Exception {
assertThat(beanMap.get("binaryField")).isEqualTo(bytes);
assertThat(beanMap.get("binaryFieldWithDefault")).isEqualTo(bytes);
assertThat(beanMap.keySet().size()).isEqualTo(18);
assertThat(beanMap.get("prefix.binaryField")).isEqualTo(bytes);
assertThat(beanMap.get("prefix.binaryFieldWithDefault")).isEqualTo(bytes);
assertThat(beanMap.keySet().size()).isEqualTo(18);
}