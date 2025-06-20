/** 
 * Method: getAlpacajsJson(List<PluginParams> pluginParamsList)
 */
@Test public void testGetParamsJson(){
  List<PluginParams> paramsList=new ArrayList<>();
  InputParam receivesParam=InputParam.newBuilder("field1","field1").addValidate(Validate.newBuilder().setRequired(true).build()).build();
  InputParam receiveCcsParam=new InputParam.Builder("field2","field2").build();
  InputParam mailSmtpHost=new InputParam.Builder("field3","field3").addValidate(Validate.newBuilder().setRequired(true).build()).build();
  InputParam mailSmtpPort=new InputParam.Builder("field4","field4").addValidate(Validate.newBuilder().setRequired(true).setType(DataType.NUMBER.getDataType()).build()).build();
  InputParam mailSender=new InputParam.Builder("field5","field5").addValidate(Validate.newBuilder().setRequired(true).build()).build();
  RadioParam enableSmtpAuth=new RadioParam.Builder("field6","field6").addParamsOptions(new ParamsOptions("YES",true,false)).addParamsOptions(new ParamsOptions("NO",false,false)).setValue(true).addValidate(Validate.newBuilder().setRequired(true).build()).build();
  InputParam mailUser=new InputParam.Builder("field7","field7").setPlaceholder("if enable use authentication, you need input user").build();
  PasswordParam mailPassword=new PasswordParam.Builder("field8","field8").setPlaceholder("if enable use authentication, you need input password").build();
  RadioParam enableTls=new RadioParam.Builder("field9","field9").addParamsOptions(new ParamsOptions("YES",true,false)).addParamsOptions(new ParamsOptions("NO",false,false)).setValue(false).addValidate(Validate.newBuilder().setRequired(true).build()).build();
  RadioParam enableSsl=new RadioParam.Builder("field10","field10").addParamsOptions(new ParamsOptions("YES",true,false)).addParamsOptions(new ParamsOptions("NO",false,false)).setValue(false).addValidate(Validate.newBuilder().setRequired(true).build()).build();
  InputParam sslTrust=new InputParam.Builder("field11","field11").setValue("*").addValidate(Validate.newBuilder().setRequired(true).build()).build();
  List<ParamsOptions> emailShowTypeList=new ArrayList<>();
  emailShowTypeList.add(new ParamsOptions("table","table",false));
  emailShowTypeList.add(new ParamsOptions("text","text",false));
  emailShowTypeList.add(new ParamsOptions("attachment","attachment",false));
  emailShowTypeList.add(new ParamsOptions("tableattachment","tableattachment",false));
  RadioParam showType=new RadioParam.Builder("showType","showType").setOptions(emailShowTypeList).setValue("table").addValidate(Validate.newBuilder().setRequired(true).build()).build();
  paramsList.add(receivesParam);
  paramsList.add(receiveCcsParam);
  paramsList.add(mailSmtpHost);
  paramsList.add(mailSmtpPort);
  paramsList.add(mailSender);
  paramsList.add(enableSmtpAuth);
  paramsList.add(mailUser);
  paramsList.add(mailPassword);
  paramsList.add(enableTls);
  paramsList.add(enableSsl);
  paramsList.add(sslTrust);
  paramsList.add(showType);
  String paramsJson=PluginParamsTransfer.transferParamsToJson(paramsList);
  String paramsJsonAssert="[{\"props\":null,\"field\":\"field1\",\"name\":\"field1\",\"type\":\"input\",\"title\":\"field1\",\"value\":null,\"validate\"" + ":[{\"required\":true,\"message\":null,\"type\":\"string\",\"trigger\":\"blur\",\"min\":null,\"max\":null}]},{\"props\":null,\"field\":" + "\"field2\",\"name\":\"field2\",\"type\":\"input\",\"title\":\"field2\",\"value\":null,\"validate\":null},{\"props\":null,\"field\":\"field3\","+ "\"name\":\"field3\",\"type\":\"input\",\"title\":\"field3\",\"value\":null,\"validate\":[{\"required\":true,\"message\":null,\"type\":\"string\","+ "\"trigger\":\"blur\",\"min\":null,\"max\":null}]},{\"props\":null,\"field\":\"field4\",\"name\":\"field4\",\"type\":\"input\",\"title\":\"field"+ "4\",\"value\":null,\"validate\":[{\"required\":true,\"message\":null,\"type\":\"number\",\"trigger\":\"blur\",\"min\":null,\"max\":null}]},{\"pro"+ "ps\":null,\"field\":\"field5\",\"name\":\"field5\",\"type\":\"input\",\"title\":\"field5\",\"value\":null,\"validate\":[{\"required\":true,\"mess"+ "age\":null,\"type\":\"string\",\"trigger\":\"blur\",\"min\":null,\"max\":null}]},{\"props\":null,\"field\":\"field6\",\"name\":\"field6\",\"typ"+ "e\":\"radio\",\"title\":\"field6\",\"value\":true,\"validate\":[{\"required\":true,\"message\":null,\"type\":\"string\",\"trigger\":\"blur\",\"mi"+ "n\":null,\"max\":null}],\"options\":[{\"label\":\"YES\",\"value\":true,\"disabled\":false},{\"label\":\"NO\",\"value\":false,\"disabled\":false}"+ "]},{\"props\":null,\"field\":\"field7\",\"name\":\"field7\",\"type\":\"input\",\"title\":\"field7\",\"value\":null,\"validate\":null},{\"field\":\"f"+ "ield8\",\"name\":\"field8\",\"props\":{\"disabled\":null,\"placeholder\":\"if enable use authentication, you need input password\",\"size\":\"smal"+ "l\"},\"type\":\"input\",\"title\":\"field8\",\"value\":null,\"validate\":null},{\"props\":null,\"field\":\"field9\",\"name\":\"field9\",\"type\":\"ra"+ "dio\",\"title\":\"field9\",\"value\":false,\"validate\":[{\"required\":true,\"message\":null,\"type\":\"string\",\"trigger\":\"blur\",\"min\":nul"+ "l,\"max\":null}],\"options\":[{\"label\":\"YES\",\"value\":true,\"disabled\":false},{\"label\":\"NO\",\"value\":false,\"disabled\":false}]},{\"pro"+ "ps\":null,\"field\":\"field10\",\"name\":\"field10\",\"type\":\"radio\",\"title\":\"field10\",\"value\":false,\"validate\":[{\"required\":true,\"mes"+ "sage\":null,\"type\":\"string\",\"trigger\":\"blur\",\"min\":null,\"max\":null}],\"options\":[{\"label\":\"YES\",\"value\":true,\"disabled\":fal"+ "se},{\"label\":\"NO\",\"value\":false,\"disabled\":false}]},{\"props\":null,\"field\":\"field11\",\"name\":\"field11\",\"type\":\"input\",\"titl"+ "e\":\"field11\",\"value\":\"*\",\"validate\":[{\"required\":true,\"message\":null,\"type\":\"string\",\"trigger\":\"blur\",\"min\":null,\"max\":nul"+ "l}]},{\"props\":null,\"field\":\"showType\",\"name\":\"showType\",\"type\":\"radio\",\"title\":\"showType\",\"value\":\"table\",\"validate\":[{\"re"+ "quired\":true,\"message\":null,\"type\":\"string\",\"trigger\":\"blur\",\"min\":null,\"max\":null}],\"options\":[{\"label\":\"table\",\"value\":\"tab"+ "le\",\"disabled\":false},{\"label\":\"text\",\"value\":\"text\",\"disabled\":false},{\"label\":\"attachment\",\"value\":\"attachment\",\"disabled\":f"+ "alse},{\"label\":\"tableattachment\",\"value\":\"tableattachment\",\"disabled\":false}]}]";
  Assert.assertEquals(paramsJsonAssert,paramsJson);
}
