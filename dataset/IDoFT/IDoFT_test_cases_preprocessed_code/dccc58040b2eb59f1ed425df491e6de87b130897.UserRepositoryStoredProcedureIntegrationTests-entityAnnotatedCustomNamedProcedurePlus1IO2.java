@Test void entityAnnotatedCustomNamedProcedurePlus1IO2(){
assertThat(result).containsExactly(entry("res",2),entry("res2",3));
}