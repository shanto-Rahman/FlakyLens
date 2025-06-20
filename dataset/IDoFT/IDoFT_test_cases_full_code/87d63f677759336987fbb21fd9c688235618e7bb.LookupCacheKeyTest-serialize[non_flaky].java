@Test public void serialize(){
  final LookupCacheKey cacheKey=LookupCacheKey.createFromJSON("prefix","key");
  final JsonNode node=objectMapper.convertValue(cacheKey,JsonNode.class);
  assertThat(node.isObject()).isTrue();
  assertThat(node.fieldNames()).containsExactlyInAnyOrder("prefix","key");
  assertThat(node.path("prefix").isTextual()).isTrue();
  assertThat(node.path("prefix").asText()).isEqualTo("prefix");
  assertThat(node.path("key").isTextual()).isTrue();
  assertThat(node.path("key").asText()).isEqualTo("key");
}
