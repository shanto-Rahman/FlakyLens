@Test public void testDeepToString(){
  final Row row=Row.withNames(RowKind.UPDATE_BEFORE);
  row.setField("a",1);
  row.setField("b","hello");
  row.setField("c",null);
  row.setField("d",new Tuple2<>(2,"hi"));
  row.setField("e","hello world");
  row.setField("f",new int[][]{{1},null,{3,4}});
  row.setField("g",new Boolean[][]{{true},null,{false,false}});
  final Map<String,Integer[]> map=new LinkedHashMap<>();
  map.put("a",new Integer[]{1,2,3,4});
  map.put("b",new Integer[]{});
  map.put("c",null);
  row.setField("h",map);
  assertThat(row.toString(),equalTo("-U{" + "a=1, " + "b=hello, "+ "c=null, "+ "d=(2,hi), "+ "e=hello world, "+ "f=[[1], null, [3, 4]], "+ "g=[[true], null, [false, false]], "+ "h={a=[1, 2, 3, 4], b=[], c=null}"+ "}"));
}
