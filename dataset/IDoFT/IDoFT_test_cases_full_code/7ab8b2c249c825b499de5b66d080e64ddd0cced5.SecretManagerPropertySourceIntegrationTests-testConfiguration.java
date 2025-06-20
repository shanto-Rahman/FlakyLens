@Test public void testConfiguration(){
  assertThat(context.getEnvironment().getProperty("sm://" + TEST_SECRET_ID)).isEqualTo("the secret data.");
  byte[] byteArraySecret=context.getEnvironment().getProperty("sm://" + TEST_SECRET_ID + "/latest",byte[].class);
  assertThat(byteArraySecret).isEqualTo("the secret data.".getBytes());
}
