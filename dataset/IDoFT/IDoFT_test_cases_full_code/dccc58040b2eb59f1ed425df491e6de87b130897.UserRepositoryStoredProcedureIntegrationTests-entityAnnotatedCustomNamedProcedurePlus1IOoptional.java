@Test void entityAnnotatedCustomNamedProcedurePlus1IOoptional(){
  Map<String,Integer> result=repository.entityAnnotatedCustomNamedProcedurePlus1IOoptional(1);
  assertThat(result).containsExactly(entry("res",2),entry("res2",null));
}
