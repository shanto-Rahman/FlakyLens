@Test public void client2RestCallViaCustomizer(){
assertThat(this.client2.test()).isEqualTo("there");
}