@Test public void fullBuilderJson(){
Assertions.assertThat(payloadJson).isEqualTo("{\"id\":\"d_id\",\"manufacturer\":\"d_manufacturer\",\"model\":\"d_model\",\"name\":\"d_name\",\"type\":\"d_type\"}");
}