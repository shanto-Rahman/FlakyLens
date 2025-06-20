@Test @DisplayName("Successful Feed JSON serialization") public void postFeedSerializationTest() throws IOException {
assertEquals(accessPointsFeedRequest.toJson(),feedRequestJson);
}