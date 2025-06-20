/** 
 * Method: getAlpacajsJson(List<PluginParams> pluginParamsList)
 */
@Test public void testGetParamsJson(){
Assert.assertEquals(12,pluginParams.size());
Assert.assertEquals(name[i],param.getName());
Assert.assertEquals(name[i],param.getTitle());
if (value[i] != null) {
Assert.assertEquals(value[i],param.getValue().toString());
Assert.assertEquals(null,param.getValue());
}
if (validateRequired[i]) {
Assert.assertEquals(true,param.getValidateList().get(0).isRequired());
Assert.assertEquals(i == 3 ? DataType.NUMBER.getDataType() : DataType.STRING.getDataType(),param.getValidateList().get(0).getType());
Assert.assertEquals(null,param.getValidateList());
}
Assert.assertEquals(type[i],param.getFormType());
assertEquals(radioOptions,((RadioParam)pluginParams.get(5)).getOptions());
assertEquals(radioOptions,((RadioParam)pluginParams.get(8)).getOptions());
assertEquals(radioOptions,((RadioParam)pluginParams.get(9)).getOptions());
assertEquals(emailShowTypeList,((RadioParam)pluginParams.get(11)).getOptions());
}