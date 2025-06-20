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
  CheckboxParam checkboxParam=new CheckboxParam.Builder("checkboxTest","checkboxTest").build();
  InputNumberParam inputNumberParam=new InputNumberParam.Builder("inputNumberTest","inputNumberTest").build();
  SelectParam selectParam=new SelectParam.Builder("selectTest","selectTest").build();
  SwitchParam switchParam=new SwitchParam.Builder("switchTest","switchTest").build();
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
  paramsList.add(checkboxParam);
  paramsList.add(inputNumberParam);
  paramsList.add(selectParam);
  paramsList.add(switchParam);
  String paramsJson=PluginParamsTransfer.transferParamsToJson(paramsList);
  List<PluginParams> pluginParams=PluginParamsTransfer.transferJsonToParamsList(paramsJson);
  Assert.assertEquals(12,pluginParams.size());
  String input=FormType.INPUT.getFormType();
  String radio=FormType.RADIO.getFormType();
  String checkbox=FormType.CHECKBOX.getFormType();
  String inputNumber=FormType.INPUTNUMBER.getFormType();
  String select=FormType.SELECT.getFormType();
  String switchType=FormType.SWITCH.getFormType();
  String[] name=new String[]{"field1","field2","field3","field4","field5","field6","field7","field8","field9","field10","field11","showType","checkboxTest","inputNumberTest","selectTest","switchTest"};
  String[] value=new String[]{null,null,null,null,null,"true",null,null,"false","false","*","table",null,null,null,null};
  Boolean[] validateRequired=new Boolean[]{true,false,true,true,true,true,false,false,true,true,true,true,false,false,false,false};
  String[] type=new String[]{input,input,input,input,input,radio,input,input,radio,radio,input,radio,checkbox,inputNumber,select,switchType};
  List<ParamsOptions> radioOptions=new ArrayList<ParamsOptions>();
  radioOptions.add(new ParamsOptions("YES",true,false));
  radioOptions.add(new ParamsOptions("NO",false,false));
  for (int i=0; i < pluginParams.size(); i++) {
    PluginParams param=pluginParams.get(i);
    Assert.assertEquals(name[i],param.getName());
    Assert.assertEquals(name[i],param.getTitle());
    if (value[i] != null) {
      Assert.assertEquals(value[i],param.getValue().toString());
    }
 else {
      Assert.assertEquals(null,param.getValue());
    }
    if (validateRequired[i]) {
      Assert.assertEquals(true,param.getValidateList().get(0).isRequired());
      Assert.assertEquals(i == 3 ? DataType.NUMBER.getDataType() : DataType.STRING.getDataType(),param.getValidateList().get(0).getType());
    }
 else {
      Assert.assertEquals(null,param.getValidateList());
    }
    Assert.assertEquals(type[i],param.getFormType());
  }
  assertEquals(radioOptions,((RadioParam)pluginParams.get(5)).getOptions());
  assertEquals(radioOptions,((RadioParam)pluginParams.get(8)).getOptions());
  assertEquals(radioOptions,((RadioParam)pluginParams.get(9)).getOptions());
  assertEquals(emailShowTypeList,((RadioParam)pluginParams.get(11)).getOptions());
}
