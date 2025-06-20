@Test public void properties(){
Assertions.assertThat(payloadJson).isEqualTo("{\"event\":\"event\",\"properties\":{\"key\":\"value\"}}");
}