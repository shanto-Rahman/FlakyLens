@Test public void encoding() throws Exception {
assertThat(encoded,equalTo("A[31;1mB[0mD[32mE[2mF[0;39m"));
}