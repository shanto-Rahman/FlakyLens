@Test void entityAnnotatedCustomNamedProcedurePlus1IOoptional(){
assertThat(result).containsOnly(entry("res",2),entry("res2",null));
}