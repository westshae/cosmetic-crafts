package com.altoya.cosmeticcrafts.createItem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import org.apache.commons.lang.SerializationUtils;
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
    return SerializationUtils.serialize(complex);
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
