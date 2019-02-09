package leiyichen.proto;

import leiyichen.proto.Datainfo.Person;

public class ProtoTest {

  public static void main(String[] args) throws Exception {
    Person person = Person.newBuilder().setId(1).setName("小王")
        .setEmail("hello@qq.com").build();
    byte[] person2ByteArray = person.toByteArray();
    Person person1 = Person.parseFrom(person2ByteArray);
    System.out.println(person1.getId());
    System.out.println(person1.getEmail());
    System.out.println(person1.getName());


  }
}
