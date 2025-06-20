@Test public void testIntermediateUnions(){
  final Settings settings=TestUtils.settings();
  settings.quotes="'";
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(RecordUsage.class));
  final String expected="" + "interface RecordUsage {\n" + "    records: RecordUnion[];\n"+ "    formRecords: FormRecordUnion[];\n"+ "    listRecords: ListRecordUnion[];\n"+ "}\n"+ "\n"+ "interface Record {\n"+ "    '@type': 'order.form' | 'product.form' | 'order.list' | 'product.list';\n"+ "}\n"+ "\n"+ "interface FormRecord extends Record {\n"+ "    '@type': 'order.form' | 'product.form';\n"+ "}\n"+ "\n"+ "interface ListRecord extends Record {\n"+ "    '@type': 'order.list' | 'product.list';\n"+ "}\n"+ "\n"+ "interface OrderFormRecord extends FormRecord {\n"+ "    '@type': 'order.form';\n"+ "}\n"+ "\n"+ "interface ProductFormRecord extends FormRecord {\n"+ "    '@type': 'product.form';\n"+ "}\n"+ "\n"+ "interface OrderListRecord extends ListRecord {\n"+ "    '@type': 'order.list';\n"+ "}\n"+ "\n"+ "interface ProductListRecord extends ListRecord {\n"+ "    '@type': 'product.list';\n"+ "}\n"+ "\n"+ "type RecordUnion = FormRecord | ListRecord;\n"+ "\n"+ "type FormRecordUnion = OrderFormRecord | ProductFormRecord;\n"+ "\n"+ "type ListRecordUnion = OrderListRecord | ProductListRecord;\n"+ "";
  Assert.assertEquals(expected.trim(),output.trim());
}
