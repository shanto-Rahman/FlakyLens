@Test void entityAnnotatedCustomNamedProcedurePlus1IO2(){
  Map<String,Integer> result=repository.entityAnnotatedCustomNamedProcedurePlus1IO2(1);
  assertThat(result).containsOnly(entry("res",2),entry("res2",3));
}
