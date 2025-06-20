@Test void entityAnnotatedCustomNamedProcedurePlus1IO2(){
assertThat(result).containsOnly(entry("res",2),entry("res2",3));
}