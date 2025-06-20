@Test public void deserialize(){
assertTrue(reader.readOne());
assertFalse(reader.readOne());
assertEquals("push[ONE]\n" + "unwraps[!UnwrapsWDENum {\n" + "  c: !WDENums {\n"+ "    name: FOUR,\n"+ "    nice: Four,\n"+ "    value: 4\n"+ "  }\n"+ "}\n"+ "]\n"+ "push[FOUR]\n"+ "holds[!HoldsWDENum {\n"+ "  a: TWO,\n"+ "  b: FOUR\n"+ "}\n"+ "]\n"+ "unwrap2[!UnwrapsWDENum2 {\n"+ "  d: !WDENum2 {\n"+ "    name: ACE,\n"+ "    nice: Ace,\n"+ "    value: 101\n"+ "  }\n"+ "}\n"+ "]\n"+ "push2[!WDENum2 {\n"+ "  name: ACE,\n"+ "  nice: !!null \"\",\n"+ "  value: 0\n"+ "}\n"+ "]\n",sw.toString().replace("\r",""));
}