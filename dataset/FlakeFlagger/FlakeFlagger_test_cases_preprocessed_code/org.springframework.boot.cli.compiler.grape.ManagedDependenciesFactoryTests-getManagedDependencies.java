@Test public void getManagedDependencies(){
assertThat(result.size(),equalTo(2));
assertThat(result.get(0).toString(),equalTo("g1:a1:jar:1 (compile)"));
assertThat(result.get(1).toString(),equalTo("g1:a2:jar:1 (compile)"));
}