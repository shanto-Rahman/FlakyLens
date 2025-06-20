@Test public void jsonSerialized(){
Assertions.assertThat(payloadJson).isEqualTo("{\"created_at\":\"2018-01-01\",\"timestamp\":\"2018-01-01\",\"device_token\":\"1234\",\"event\":\"event\",\"properties\":{\"key\":\"val\"},\"review_id\":\"2345\",\"user_id\":\"3456\",\"user_traits\":{\"key\":\"val\"}}");
}