@Test public void testConstantExpression(){
  final Expression constant=Expressions.constant(new Object[]{1,new Object[]{(byte)1,(short)2,(int)3,(long)4,(float)5,(double)6,(char)7,true,"string",null},new AllType(true,(byte)100,(char)101,(short)102,103,(long)104,(float)105,(double)106,new BigDecimal(107),new BigInteger("108"),"109",null)});
  assertEquals("new Object[] {\n" + "  1,\n" + "  new Object[] {\n"+ "    (byte)1,\n"+ "    (short)2,\n"+ "    3,\n"+ "    4L,\n"+ "    5.0F,\n"+ "    6.0D,\n"+ "    (char)7,\n"+ "    true,\n"+ "    \"string\",\n"+ "    null},\n"+ "  new net.hydromatic.linq4j.test.ExpressionTest.AllType(\n"+ "    true,\n"+ "    (byte)100,\n"+ "    (char)101,\n"+ "    (short)102,\n"+ "    103,\n"+ "    104L,\n"+ "    105.0F,\n"+ "    106.0D,\n"+ "    new java.math.BigDecimal(107L),\n"+ "    new java.math.BigInteger(\"108\"),\n"+ "    \"109\",\n"+ "    null)}",constant.toString());
  constant.accept(new Visitor());
}
