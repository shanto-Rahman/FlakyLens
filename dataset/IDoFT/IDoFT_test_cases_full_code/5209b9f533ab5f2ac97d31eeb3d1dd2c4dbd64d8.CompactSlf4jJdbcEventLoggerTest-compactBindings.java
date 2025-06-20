@Test public void compactBindings(){
  StringBuilder buffer=new StringBuilder();
  DbAttributeBinding[] bindings=new DbAttributeBinding[]{createBinding("t0.NAME",1,"",new CharType(false,false)),createBinding("t0.NAME",2,52,new IntegerType()),createBinding("t0.NAME",3,true,new BooleanType()),createBinding("t0.F_KEY1",4,true,new BooleanType())};
  logger.appendParameters(buffer,"bind",bindings);
  assertEquals(buffer.toString(),"[bind: 1->t0.NAME: {'', 52, 'true'}, 2->t0.F_KEY1: 'true']");
}
