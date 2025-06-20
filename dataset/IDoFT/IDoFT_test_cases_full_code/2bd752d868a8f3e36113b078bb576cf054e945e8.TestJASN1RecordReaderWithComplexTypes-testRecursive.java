@Test public void testRecursive() throws Exception {
  String dataFile="target/recursive.dat";
  Recursive recursive=new Recursive();
  Recursive.Children children=new Recursive.Children();
  Recursive child1=new Recursive();
  Recursive child2=new Recursive();
  Recursive.Children grandChildren1=new Recursive.Children();
  Recursive grandChild11=new Recursive();
  grandChild11.setName(new BerIA5String("grandChildName11".getBytes()));
  grandChild11.setChildren(new Recursive.Children());
  grandChildren1.getRecursive().add(grandChild11);
  child1.setName(new BerIA5String("childName1".getBytes()));
  child1.setChildren(grandChildren1);
  child2.setName(new BerIA5String("childName2".getBytes()));
  child2.setChildren(new Recursive.Children());
  children.getRecursive().add(child1);
  children.getRecursive().add(child2);
  recursive.setName(new BerIA5String("name".getBytes()));
  recursive.setChildren(children);
  SimpleRecordSchema expectedSchema=new SimpleRecordSchema(Arrays.asList(new RecordField("name",RecordFieldType.STRING.getDataType()),new RecordField("children",RecordFieldType.ARRAY.getArrayDataType(RecordFieldType.RECORD.getRecordDataType(() -> null)))));
  Map<String,Object> expectedValues=new HashMap<String,Object>(){
{
      put("name","name");
      put("children",new MapRecord[]{new MapRecord(expectedSchema,new HashMap<String,Object>(){
{
          put("name","childName1");
          put("children",new MapRecord[]{new MapRecord(expectedSchema,new HashMap<String,Object>(){
{
              put("name","grandChildName11");
              put("children",new MapRecord[0]);
            }
          }
)});
        }
      }
),new MapRecord(expectedSchema,new HashMap<String,Object>(){
{
          put("name","childName2");
          put("children",new MapRecord[0]);
        }
      }
)});
    }
  }
;
  testReadRecord(dataFile,recursive,expectedValues,expectedSchema);
}
