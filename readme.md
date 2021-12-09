# CosmeticCrafts
A small minecraft plugin that allows you to update a item's model using a server resourcepack

## Commands
/giveskin {itemcode} {playername:Optional}
- Gives the player the model changing item.

## Config default
```
items: //Don't change
  '0': //itemcode
    modelID: '1234567' // customModelData that is put in the resourcepack json's
    name: '&6&lSkinChanger: &b&lCosmeticChanger' // Colour coded item name
    lore: //Each line of lore for the item, can use as many as minecraft allows.
    - '&bChanges your item models'
    - ''
    - '&7Use on swords'
    materials: //What items the model changer can be used on
    - GOLDEN_SWORD
    - DIAMOND_SWORD
    - WOODEN_SWORD
    - IRON_SWORD
    - STONE_SWORD
    - NETHERITE_SWORD
```
