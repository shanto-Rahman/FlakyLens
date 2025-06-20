@Test public void should_create_Assert_generics(){
Assertions.assertThat(bill).isEqualTo(billou);
Assertions.assertThat(billou).isEqualTo(bill);
}