@Test public void addedEnum() throws NoSuchFieldException {
nums.unwraps(new UnwrapsWDENum(three));//IT
nums.holds(new HoldsWDENum(WDENums.TWO,three));//IT
nums.unwrap2(new UnwrapsWDENum2(ace));//IT
nums.push2(ace);//IT
assertEquals("push: ONE\n" + "...\n" + "unwraps: {\n"+ "  c: !WDENums {\n"+ "    name: THREE,\n"+ "    nice: Three,\n"+ "    value: 3\n"+ "  }\n"+ "}\n"+ "...\n"+ "push: THREE\n"+ "...\n"+ "holds: {\n"+ "  a: TWO,\n"+ "  b: THREE\n"+ "}\n"+ "...\n"+ "unwrap2: {\n"+ "  d: !WDENum2 {\n"+ "    name: ACE,\n"+ "    nice: Ace,\n"+ "    value: 101\n"+ "  }\n"+ "}\n"+ "...\n"+ "push2: ACE\n"+ "...\n",tw.toString());
}