@Test public void manuallyCreateBean(){
assertThat(client.test()).isEqualTo("hello");
}