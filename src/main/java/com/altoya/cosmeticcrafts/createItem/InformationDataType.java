package com.altoya.cosmeticcrafts.createItem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

public class InformationDataType implements PersistentDataType<byte[], Information>{

  @Override
  public Class<Information> getComplexType() {
    return Information.class;
  }

  @Override
  public Class<byte[]> getPrimitiveType() {
    return byte[].class;
  }

  @Override
  public byte[] toPrimitive(Information complex, PersistentDataAdapterContext context) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(complex);
        oos.flush();
        return bos.toByteArray();
    } catch (IOException e) {
        throw new RuntimeException("Error serializing object", e);
    }
  }

  @Override
  public Information fromPrimitive(byte[] primitive, PersistentDataAdapterContext context) {
    try{
      InputStream is = new ByteArrayInputStream(primitive);
      ObjectInputStream o = new ObjectInputStream(is);
      return (Information) o.readObject();
    }catch(IOException | ClassNotFoundException event){
      event.printStackTrace();
    }
    return null;
  }

  
  
}
