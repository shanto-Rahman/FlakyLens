@Test public void client1RestCallViaCustomizer(){
assertThat(this.client1.test()).isEqualTo("hello");
}