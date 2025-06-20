@Test public void testWriteConstant(){
  assertEquals("new int[] {\n" + "  1,\n" + "  2,\n"+ "  -1}",Expressions.toString(Expressions.constant(new int[]{1,2,-1})));
  assertEquals("-12",Expressions.toString(Expressions.constant(-12)));
  assertEquals("(short)-12",Expressions.toString(Expressions.constant((short)-12)));
  assertEquals("(byte)-12",Expressions.toString(Expressions.constant((byte)-12)));
  assertEquals("Integer.valueOf(1)",Expressions.toString(Expressions.constant(1,Integer.class)));
  assertEquals("Double.valueOf(-3.14D)",Expressions.toString(Expressions.constant(-3.14,Double.class)));
  assertEquals("Boolean.valueOf(true)",Expressions.toString(Expressions.constant(true,Boolean.class)));
  assertEquals("1",Expressions.toString(Expressions.constant(1,int.class)));
  assertEquals("(short)1",Expressions.toString(Expressions.constant(1,short.class)));
  assertEquals("(byte)1",Expressions.toString(Expressions.constant(1,byte.class)));
  assertEquals("-3.14D",Expressions.toString(Expressions.constant(-3.14,double.class)));
  assertEquals("true",Expressions.toString(Expressions.constant(true,boolean.class)));
  assertEquals("new String[] {\n" + "  \"foo\",\n" + "  null}",Expressions.toString(Expressions.constant(new String[]{"foo",null})));
  assertEquals("\"hello, \\\"world\\\"!\"",Expressions.toString(Expressions.constant("hello, \"world\"!")));
  assertEquals("net.hydromatic.linq4j.test.ExpressionTest.MyEnum.X",Expressions.toString(Expressions.constant(MyEnum.X)));
  assertEquals("new net.hydromatic.linq4j.test.ExpressionTest.MyEnum[] {\n" + "  net.hydromatic.linq4j.test.ExpressionTest.MyEnum.X,\n" + "  net.hydromatic.linq4j.test.ExpressionTest.MyEnum.Y}",Expressions.toString(Expressions.constant(new MyEnum[]{MyEnum.X,MyEnum.Y})));
  assertEquals("java.lang.String.class",Expressions.toString(Expressions.constant(String.class)));
  assertEquals("int[].class",Expressions.toString(Expressions.constant(int[].class)));
  assertEquals("java.util.List[][].class",Expressions.toString(Expressions.constant(List[][].class)));
  assertEquals("new net.hydromatic.linq4j.test.Linq4jTest.Employee[] {\n" + "  new net.hydromatic.linq4j.test.Linq4jTest.Employee(\n" + "    100,\n"+ "    \"Fred\",\n"+ "    10),\n"+ "  new net.hydromatic.linq4j.test.Linq4jTest.Employee(\n"+ "    110,\n"+ "    \"Bill\",\n"+ "    30),\n"+ "  new net.hydromatic.linq4j.test.Linq4jTest.Employee(\n"+ "    120,\n"+ "    \"Eric\",\n"+ "    10),\n"+ "  new net.hydromatic.linq4j.test.Linq4jTest.Employee(\n"+ "    130,\n"+ "    \"Janet\",\n"+ "    10)}",Expressions.toString(Expressions.constant(Linq4jTest.emps)));
}
