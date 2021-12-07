package com.altoya.cosmeticcrafts.createItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class Information implements Serializable{
  private static final long serialVersionUID = 1L;
  private List<Material> materials;
  private int modelID;
  private String hexCode;

  public Information(int modelID, List<Material> materials, String hexCode){
    this.materials = materials;
    this.modelID = modelID;
    this.hexCode = hexCode;
  }

  public String getHexCode() {
    return hexCode;
  }
  
  public void setHexCode(String hexCode) {
    this.hexCode = hexCode;
  }

  public int getModelID() {
    return modelID;
  }

  public void setModelID(int modelID) {
    this.modelID = modelID;
  }

  public List<Material> getMaterials() {
    return materials;
  }

  public void setMaterials(ArrayList<Material> materials) {
    this.materials = materials;
  }
}
