@Test public void testConfiguration(){
assertThat(context.getEnvironment().getProperty("sm://" + TEST_SECRET_ID)).isEqualTo("the secret data.");
assertThat(byteArraySecret).isEqualTo("the secret data.".getBytes());
}