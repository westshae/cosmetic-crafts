package com.altoya.cosmeticcrafts.createItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class Information implements Serializable{
  private static final long serialVersionUID = 1L;
  private List<Material> materials;
  private int modelID;

  public Information(int modelID, List<Material> materials){
    this.materials = materials;
    this.modelID = modelID;
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
