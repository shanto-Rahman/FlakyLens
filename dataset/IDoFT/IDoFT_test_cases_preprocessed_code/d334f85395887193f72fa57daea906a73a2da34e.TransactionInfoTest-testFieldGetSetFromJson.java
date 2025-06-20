/** 
 * Test field get set from json.
 */
@Test public void testFieldGetSetFromJson(){
assertThat(fromTxInfo.getTimeOut()).isEqualTo(TIME_OUT);
assertThat(fromTxInfo.getName()).isEqualTo(NAME);
assertThat(fromTxInfo.getRollbackRules()).isEqualTo(getRollbackRules());
assertThat(fromJson).isEqualTo(toJson);
}