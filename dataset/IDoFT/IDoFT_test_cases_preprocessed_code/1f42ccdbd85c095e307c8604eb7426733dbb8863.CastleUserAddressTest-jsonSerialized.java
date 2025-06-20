@Test public void jsonSerialized(){
Assertions.assertThat(payloadJson).isEqualTo("{\"street\":\"street 1\",\"city\":\"city\",\"postal_code\":\"12345\",\"region\":\"region\",\"country\":\"country\"}");
}