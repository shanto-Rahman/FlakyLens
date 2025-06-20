@Test public void deserialize2(){
  String text="push: ONE\n" + "...\n" + "unwraps: {\n"+ "  c: !WDENums {\n"+ "    name: FOUR,\n"+ "    nice: Four,\n"+ "    value: 4\n"+ "  }\n"+ "}\n"+ "...\n"+ "push: FOUR\n"+ "...\n"+ "holds: {\n"+ "  a: TWO,\n"+ "  b: FOUR\n"+ "}\n"+ "...\n"+ "unwrap2: {\n"+ "  d: !WDENum2 {\n"+ "    name: KING,\n"+ "    nice: King,\n"+ "    value: 112\n"+ "  }\n"+ "}\n"+ "...\n"+ "push2: ONE\n"+ "...\n"+ "push2: TWO\n"+ "...\n"+ "push2: KING\n"+ "...\n";
  TextWire tw=new TextWire(Bytes.from(text)).useTextDocuments();
  StringWriter sw=new StringWriter();
  MethodReader reader=tw.methodReader(new UsesWDENums(){
    @Override public void push(    WDENums nums){
      sw.append(nums.name() + " ~ " + nums.nice+ " ~ "+ nums.value+ "\n");
    }
    @Override public void holds(    HoldsWDENum holdsWDENum){
      sw.append(holdsWDENum.toString());
      sw.append("# " + holdsWDENum.a.value + ", "+ holdsWDENum.b.value+ "\n");
    }
    @Override public void unwraps(    UnwrapsWDENum unwrapsWDENum){
      WDENums c=unwrapsWDENum.c;
      sw.append("Update " + c + "\n");
      updateEnum(c);
    }
    @Override public void push2(    WDENum2 nums){
      sw.append(nums.name() + " = " + nums.nice+ " = "+ nums.value+ "\n");
    }
    @Override public void unwrap2(    UnwrapsWDENum2 unwrapsWDENum2){
      WDENum2 d=unwrapsWDENum2.d;
      sw.append("Update " + d + "\n");
      updateEnum(d);
    }
  }
);
  for (int i=0; i < 8; i++)   assertTrue(reader.readOne());
  assertFalse(reader.readOne());
  assertEquals("ONE ~ One ~ 1\n" + "Update FOUR\n" + "FOUR ~ Four ~ 4\n"+ "!HoldsWDENum {\n"+ "  a: TWO,\n"+ "  b: FOUR\n"+ "}\n"+ "# 2, 4\n"+ "Update !WDENum2 {\n"+ "  name: KING,\n"+ "  nice: King,\n"+ "  value: 112\n"+ "}\n"+ "\n"+ "ONE = One = 1\n"+ "TWO = Two = 2\n"+ "KING = King = 112\n",sw.toString());
}
