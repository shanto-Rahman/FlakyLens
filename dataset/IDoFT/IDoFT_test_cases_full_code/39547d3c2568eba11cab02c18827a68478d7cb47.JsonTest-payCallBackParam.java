@Test public void payCallBackParam(){
  PayCallbackParam param=new PayCallbackParam();
  param.setStatus(1);
  param.setMessage("fail");
  param.setNotifyTime(System.currentTimeMillis() / 1000 + "");
  param.setPaymentId("20210343");
  param.setTotalAmount("2590");
  param.setTradeNo("2340343433");
  String json=JsonUtil.encode2UnderScore(param);
  System.out.println(json);
  PayCallbackParam param1=JsonUtil.decode2Camel(json,PayCallbackParam.class);
  String json1=JsonUtil.encode2UnderScore(param1);
  System.out.println(json1);
  Assert.assertTrue(json.equals(json1));
}
