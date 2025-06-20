@Test public void testMap(){
assertEquals(new HashMap<String,String>(){
{
    put("1","1");
    put("2","2");
    put("3","3");
  }
}
,udf.eval(testInput));
assertEquals(3,result.length);
assertThat(Arrays.asList(result),containsInAnyOrder("1","2","3"));
}