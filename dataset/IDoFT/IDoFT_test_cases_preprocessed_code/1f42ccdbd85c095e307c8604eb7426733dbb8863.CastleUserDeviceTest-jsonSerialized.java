@Test public void jsonSerialized(){
Assertions.assertThat(payloadJson).isEqualTo("{\"risk\":0.0,\"is_current_device\":false}");
}