@Test @DisplayName("Successful Feed JSON serialization") public void postFeedSerializationTest() throws IOException {
JSONAssert.assertEquals(accessPointsFeedRequest.toJson(),feedRequestJson,false);
}