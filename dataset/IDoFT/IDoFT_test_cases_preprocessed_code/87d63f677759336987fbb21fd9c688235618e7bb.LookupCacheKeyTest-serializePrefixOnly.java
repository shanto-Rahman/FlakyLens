@Test public void serializePrefixOnly(){
assertThat(node.isObject()).isTrue();
assertThat(node.fieldNames()).containsExactly("prefix","key");
assertThat(node.path("prefix").isTextual()).isTrue();
assertThat(node.path("prefix").asText()).isEqualTo("prefix");
assertThat(node.path("key").isNull()).isTrue();
}