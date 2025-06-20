@Test public void serializePrefixOnly(){
  final LookupCacheKey cacheKey=LookupCacheKey.createFromJSON("prefix",null);
  final JsonNode node=objectMapper.convertValue(cacheKey,JsonNode.class);
  assertThat(node.isObject()).isTrue();
  assertThat(node.fieldNames()).containsExactlyInAnyOrder("prefix","key");
  assertThat(node.path("prefix").isTextual()).isTrue();
  assertThat(node.path("prefix").asText()).isEqualTo("prefix");
  assertThat(node.path("key").isNull()).isTrue();
}
