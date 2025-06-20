@Test public void testComposite() throws Exception {
  String dataFile="target/composite.dat";
  BasicTypes child=new BasicTypes();
  child.setB(new BerBoolean(true));
  child.setI(new BerInteger(789));
  child.setOctStr(new BerOctetString(new byte[]{1,2,3,4,5}));
  BasicTypes child1=new BasicTypes();
  child1.setB(new BerBoolean(true));
  child1.setI(new BerInteger(0));
  child1.setOctStr(new BerOctetString(new byte[]{0,0,0}));
  BasicTypes child2=new BasicTypes();
  child2.setB(new BerBoolean(false));
  child2.setI(new BerInteger(1));
  child2.setOctStr(new BerOctetString(new byte[]{1,1,1}));
  BasicTypes child3=new BasicTypes();
  child3.setB(new BerBoolean(true));
  child3.setI(new BerInteger(2));
  child3.setOctStr(new BerOctetString(new byte[]{2,2,2}));
  Composite.Children children=new Composite.Children();
  children.getBasicTypes().add(child1);
  children.getBasicTypes().add(child2);
  children.getBasicTypes().add(child3);
  BasicTypes unordered1=new BasicTypes();
  unordered1.setB(new BerBoolean(true));
  unordered1.setI(new BerInteger(0));
  unordered1.setOctStr(new BerOctetString(new byte[]{0,0,0}));
  BasicTypes unordered2=new BasicTypes();
  unordered2.setB(new BerBoolean(false));
  unordered2.setI(new BerInteger(1));
  unordered2.setOctStr(new BerOctetString(new byte[]{1,1,1}));
  BasicTypeSet unordered=new BasicTypeSet();
  unordered.getBasicTypes().add(unordered1);
  unordered.getBasicTypes().add(unordered2);
  Composite.Numbers numbers=new Composite.Numbers();
  numbers.getBerInteger().add(new BerInteger(0));
  numbers.getBerInteger().add(new BerInteger(1));
  numbers.getBerInteger().add(new BerInteger(2));
  numbers.getBerInteger().add(new BerInteger(3));
  Composite composite=new Composite();
  composite.setChild(child);
  composite.setChildren(children);
  composite.setNumbers(numbers);
  composite.setUnordered(unordered);
  SimpleRecordSchema expectedChildSchema=new SimpleRecordSchema(Arrays.asList(new RecordField("b",RecordFieldType.BOOLEAN.getDataType()),new RecordField("i",RecordFieldType.BIGINT.getDataType()),new RecordField("octStr",RecordFieldType.STRING.getDataType()),new RecordField("utf8Str",RecordFieldType.STRING.getDataType())));
  RecordSchema expectedSchema=new SimpleRecordSchema(Arrays.asList(new RecordField("child",RecordFieldType.RECORD.getRecordDataType(expectedChildSchema)),new RecordField("children",RecordFieldType.ARRAY.getArrayDataType(RecordFieldType.RECORD.getRecordDataType(expectedChildSchema))),new RecordField("numbers",RecordFieldType.ARRAY.getArrayDataType(RecordFieldType.BIGINT.getDataType())),new RecordField("unordered",RecordFieldType.ARRAY.getArrayDataType(RecordFieldType.RECORD.getRecordDataType(expectedChildSchema)))));
  Function<Record,RecordSchema> expectedSchemaProvider=actualRecord -> {
    ((RecordDataType)actualRecord.getSchema().getField("child").get().getDataType()).getChildSchema();
    ((RecordDataType)((ArrayDataType)actualRecord.getSchema().getField("children").get().getDataType()).getElementType()).getChildSchema();
    ((RecordDataType)((ArrayDataType)actualRecord.getSchema().getField("unordered").get().getDataType()).getElementType()).getChildSchema();
    return expectedSchema;
  }
;
  Function<Record,Map<String,Object>> expectedValuesProvider=__ -> new HashMap<String,Object>(){
{
      put("child",new MapRecord(expectedChildSchema,new HashMap<String,Object>(){
{
          put("b",true);
          put("i",BigInteger.valueOf(789));
          put("octStr","0102030405");
        }
      }
));
      put("children",new MapRecord[]{new MapRecord(expectedChildSchema,new HashMap<String,Object>(){
{
          put("b",true);
          put("i",BigInteger.valueOf(0));
          put("octStr","000000");
        }
      }
),new MapRecord(expectedChildSchema,new HashMap<String,Object>(){
{
          put("b",false);
          put("i",BigInteger.valueOf(1));
          put("octStr","010101");
        }
      }
),new MapRecord(expectedChildSchema,new HashMap<String,Object>(){
{
          put("b",true);
          put("i",BigInteger.valueOf(2));
          put("octStr","020202");
        }
      }
)});
      put("unordered",new MapRecord[]{new MapRecord(expectedChildSchema,new HashMap<String,Object>(){
{
          put("b",true);
          put("i",BigInteger.valueOf(0));
          put("octStr","000000");
        }
      }
),new MapRecord(expectedChildSchema,new HashMap<String,Object>(){
{
          put("b",false);
          put("i",BigInteger.valueOf(1));
          put("octStr","010101");
        }
      }
)});
      put("numbers",new BigInteger[]{BigInteger.valueOf(0),BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3)});
    }
  }
;
  testReadRecord(dataFile,composite,expectedValuesProvider,expectedSchemaProvider);
}
