@Test public void deserialize(){
  String text="push: ONE\n" + "...\n" + "unwraps: {\n"+ "  c: !WDENums {\n"+ "    name: FOUR,\n"+ "    nice: Four,\n"+ "    value: 4\n"+ "  }\n"+ "}\n"+ "...\n"+ "push: FOUR\n"+ "...\n"+ "holds: {\n"+ "  a: TWO,\n"+ "  b: FOUR\n"+ "}\n"+ "...\n"+ "unwrap2: {\n"+ "  d: !WDENum2 {\n"+ "    name: ACE,\n"+ "    nice: Ace,\n"+ "    value: 101\n"+ "  }\n"+ "}\n"+ "...\n"+ "push2: ACE\n"+ "...\n";
  TextWire tw=new TextWire(Bytes.from(text)).useTextDocuments();
  StringWriter sw=new StringWriter();
  MethodReader reader=tw.methodReader(Mocker.logging(UsesWDENums.class,"",sw));
  for (int i=0; i < 6; i++)   assertTrue(reader.readOne());
  assertFalse(reader.readOne());
  assertEquals("push[ONE]\n" + "unwraps[!UnwrapsWDENum {\n" + "  c: !WDENums {\n"+ "    name: FOUR,\n"+ "    nice: Four,\n"+ "    value: 4\n"+ "  }\n"+ "}\n"+ "]\n"+ "push[FOUR]\n"+ "holds[!HoldsWDENum {\n"+ "  a: TWO,\n"+ "  b: FOUR\n"+ "}\n"+ "]\n"+ "unwrap2[!UnwrapsWDENum2 {\n"+ "  d: !WDENum2 {\n"+ "    name: ACE,\n"+ "    nice: Ace,\n"+ "    value: 101\n"+ "  }\n"+ "}\n"+ "]\n"+ "push2[!WDENum2 {\n"+ "  name: ACE,\n"+ "  nice: !!null \"\",\n"+ "  value: 0\n"+ "}\n"+ "]\n",sw.toString().replace("\r",""));
}
