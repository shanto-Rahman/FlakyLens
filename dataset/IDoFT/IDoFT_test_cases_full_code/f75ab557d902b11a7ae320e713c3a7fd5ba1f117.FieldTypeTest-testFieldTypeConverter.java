@Test public void testFieldTypeConverter() throws Exception {
  Field[] fields=LocalFoo.class.getDeclaredFields();
  assertTrue(fields.length >= 4);
  Field nameField=fields[0];
  DatabaseType databaseType=createMock(DatabaseType.class);
  final SqlType sqlType=SqlType.DATE;
  final String nameArg="zippy buzz";
  final String nameResult="blabber bling";
  final AtomicBoolean resultToSqlArgCalled=new AtomicBoolean(false);
  DataPersister stringPersister=DataType.STRING.getDataPersister();
  expect(databaseType.getDataPersister(isA(DataPersister.class),isA(FieldType.class))).andReturn(stringPersister);
  expect(databaseType.getFieldConverter(isA(DataPersister.class),isA(FieldType.class))).andReturn(new BaseFieldConverter(){
    @Override public SqlType getSqlType(){
      return sqlType;
    }
    @Override public Object parseDefaultString(    FieldType fieldType,    String defaultStr){
      return defaultStr;
    }
    @Override public Object resultToSqlArg(    FieldType fieldType,    DatabaseResults resultSet,    int columnPos){
      resultToSqlArgCalled.set(true);
      return nameResult;
    }
    @Override public Object sqlArgToJava(    FieldType fieldType,    Object sqlArg,    int columnPos){
      return nameResult;
    }
    @Override public Object javaToSqlArg(    FieldType fieldType,    Object javaObject){
      return nameArg;
    }
    @Override public Object resultStringToJava(    FieldType fieldType,    String stringValue,    int columnPos){
      return stringValue;
    }
  }
);
  expect(databaseType.isEntityNamesMustBeUpCase()).andReturn(false);
  replay(databaseType);
  connectionSource.setDatabaseType(databaseType);
  FieldType fieldType=FieldType.createFieldType(databaseType,LocalFoo.class.getSimpleName(),nameField,LocalFoo.class);
  verify(databaseType);
  assertEquals(sqlType,fieldType.getSqlType());
  LocalFoo foo=new LocalFoo();
  foo.name=nameArg + " not that";
  assertEquals(nameArg,fieldType.extractJavaFieldToSqlArgValue(foo));
  DatabaseResults resultMock=createMock(DatabaseResults.class);
  expect(resultMock.findColumn("name")).andReturn(0);
  expect(resultMock.wasNull(0)).andReturn(false);
  replay(resultMock);
  assertEquals(nameResult,fieldType.resultToJava(resultMock,new HashMap<String,Integer>()));
  verify(resultMock);
  assertTrue(resultToSqlArgCalled.get());
}
