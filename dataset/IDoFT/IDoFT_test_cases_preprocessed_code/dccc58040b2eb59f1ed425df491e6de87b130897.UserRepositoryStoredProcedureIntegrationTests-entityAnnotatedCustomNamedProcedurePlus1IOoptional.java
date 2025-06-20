@Test void entityAnnotatedCustomNamedProcedurePlus1IOoptional(){
assertThat(result).containsExactly(entry("res",2),entry("res2",null));
}