@Test public void testStringSet(){
  @NotNull Wire wire=createWire();
  @NotNull Set<String> noObjects=new HashSet();
  wire.write().object(noObjects);
  @Nullable Set<String> list=wire.read().object(Set.class);
  assertEquals(0,list.size());
  wire=createWire();
  @NotNull Set<String> threeObjects=new HashSet(Arrays.asList("abc","def","ghi"));
  wire.write().object(threeObjects);
  @Nullable Set<String> list2=wire.read().object(Set.class);
  assertEquals(3,list2.size());
  assertEquals("[abc, def, ghi]",list2.toString());
}
