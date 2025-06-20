/** 
 * for issue https://github.com/nutzam/nutz/issues/1393
 */
@Test public void test_final_field(){
  Issue1393 obj=new Issue1393("test1",99);
  String json=Json.toJson(obj,JsonFormat.compact());
  assertJsonEqualsNonStrict("{\"name\":\"test1\",\"age\":99}",json);
}
