/** 
 * Test field get set from json.
 */
@Test public void testFieldGetSetFromJson(){
  String fromJson="{\n" + "\t\"name\":\"" + NAME + "\",\n"+ "\t\"rollbackRules\":[{\n"+ "\t\t\"exceptionName\":\""+ Exception.class.getName()+ "\"\n"+ "\t},{\n"+ "\t\t\"exceptionName\":\""+ IllegalArgumentException.class.getName()+ "\"\n"+ "\t},{\n"+ "\t\t\"exceptionName\":\""+ IO_EXCEPTION_SHORT_NAME+ "\"\n"+ "\t},{\n"+ "\t\t\"exceptionName\":\""+ NullPointerException.class.getName()+ "\"\n"+ "\t}],\n"+ "\t\"timeOut\":30000\n"+ "}";
  TransactionInfo fromTxInfo=JSON.parseObject(fromJson,TransactionInfo.class);
  assertThat(fromTxInfo.getTimeOut()).isEqualTo(TIME_OUT);
  assertThat(fromTxInfo.getName()).isEqualTo(NAME);
  assertThat(fromTxInfo.getRollbackRules()).isEqualTo(getRollbackRules());
  TransactionInfo toTxInfo=new TransactionInfo();
  toTxInfo.setTimeOut(TIME_OUT);
  toTxInfo.setName(NAME);
  toTxInfo.setRollbackRules(getRollbackRules());
  String toJson=JSON.toJSONString(toTxInfo,true);
  assertThat(fromJson).isEqualTo(toJson);
}
