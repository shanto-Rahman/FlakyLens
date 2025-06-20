@Test public void addedEnum() throws NoSuchFieldException {
  TextWire tw=new TextWire(Bytes.allocateElasticOnHeap());
  UsesWDENums nums=tw.methodWriter(UsesWDENums.class);
  nums.push(WDENums.ONE);
  EnumCache<WDENums> cache=EnumCache.of(WDENums.class);
  WDENums three=cache.valueOf("THREE");
  three.setField("nice","Three");
  three.setField("value",3);
  nums.unwraps(new UnwrapsWDENum(three));
  nums.push(three);
  nums.holds(new HoldsWDENum(WDENums.TWO,three));
  WDENum2 ace=new WDENum2("Ace",101);
  nums.unwrap2(new UnwrapsWDENum2(ace));
  nums.push2(ace);
  assertEquals("push: ONE\n" + "...\n" + "unwraps: {\n"+ "  c: !WDENums {\n"+ "    name: THREE,\n"+ "    nice: Three,\n"+ "    value: 3\n"+ "  }\n"+ "}\n"+ "...\n"+ "push: THREE\n"+ "...\n"+ "holds: {\n"+ "  a: TWO,\n"+ "  b: THREE\n"+ "}\n"+ "...\n"+ "unwrap2: {\n"+ "  d: !WDENum2 {\n"+ "    name: ACE,\n"+ "    nice: Ace,\n"+ "    value: 101\n"+ "  }\n"+ "}\n"+ "...\n"+ "push2: ACE\n"+ "...\n",tw.toString());
}
