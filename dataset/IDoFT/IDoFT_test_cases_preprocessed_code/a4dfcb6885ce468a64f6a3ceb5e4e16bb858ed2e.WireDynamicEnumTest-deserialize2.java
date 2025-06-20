@Test public void deserialize2(){
sw.append(nums.name() + " = " + nums.nice+ " = "+ nums.value+ "\n");//IT
assertTrue(reader.readOne());
assertFalse(reader.readOne());
assertEquals("ONE ~ One ~ 1\n" + "Update FOUR\n" + "FOUR ~ Four ~ 4\n"+ "!HoldsWDENum {\n"+ "  a: TWO,\n"+ "  b: FOUR\n"+ "}\n"+ "# 2, 4\n"+ "Update !WDENum2 {\n"+ "  name: KING,\n"+ "  nice: King,\n"+ "  value: 112\n"+ "}\n"+ "\n"+ "ONE = One = 1\n"+ "TWO = Two = 2\n"+ "KING = King = 112\n",sw.toString());
}