package net.migueljb.testiumMod.item;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.item.custom.ChiselItem;
import net.migueljb.testiumMod.item.custom.HammerItem;
import net.migueljb.testiumMod.item.custom.TesterItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.List;


import static net.migueljb.testiumMod.item.ModArmorMaterials.TESTIUM_ARMOR_MATERIAL;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TestiumMod.MOD_ID);

    //ITEMS

    public static final DeferredItem<Item> TESTIUM = ITEMS.registerItem("testium",
            Item::new,
            new Item.Properties());
    public static final DeferredItem<Item> TESTIUMG = ITEMS.registerItem("testiumg",
            Item::new,
            new Item.Properties());
    public static final DeferredItem<Item> TESTIUMR = ITEMS.registerItem("testiumr",
            Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> GREENIUM = ITEMS.registerItem("greenium",
            Item::new,
            new Item.Properties());
    public static final DeferredItem<Item> REDIUM = ITEMS.registerItem("redium",
            Item::new,
            new Item.Properties());


    //Tools
    public static final DeferredItem<SwordItem> TESTIUM_SWORD = ITEMS.registerItem("testium_sword",
            props -> new SwordItem(ModToolTiers.Testium, 3,-2.4f, props));
    public static final DeferredItem<AxeItem> TESTIUM_AXE = ITEMS.registerItem("testium_axe",
            props -> new AxeItem(ModToolTiers.Testium, 6.0F,-3.2f, props));
    public static final DeferredItem<PickaxeItem> TESTIUM_PICKAXE = ITEMS.registerItem("testium_pickaxe",
            props -> new PickaxeItem(ModToolTiers.Testium, 1.0F,-2.8f, props));
    public static final DeferredItem<ShovelItem> TESTIUM_SHOVEL = ITEMS.registerItem("testium_shovel",
            props -> new ShovelItem(ModToolTiers.Testium, 1.5F,-3.0f, props));
    public static final DeferredItem<HoeItem> TESTIUM_HOE = ITEMS.registerItem("testium_hoe",
            props -> new HoeItem(ModToolTiers.Testium, 0F,-3.0f, props));
    public static final DeferredItem<HammerItem> TESTIUM_HAMMER = ITEMS.registerItem("testium_hammer",
            props -> new HammerItem(ModToolTiers.Testium, 7F,-3.5f, props));

    //Armor
    public static final DeferredItem<ArmorItem> TESTIUM_HELMET = ITEMS.registerItem(
            "testium_helmet",
            props -> new ArmorItem(
                    // The material to use.
                    TESTIUM_ARMOR_MATERIAL,
                    // The type of armor to create.
                    ArmorType.HELMET,
                    // The item properties.
                    props
            )
    );
    public static final DeferredItem<ArmorItem> TESTIUM_CHESTPLATE =
            ITEMS.registerItem("testium_chestplate", props -> new ArmorItem(TESTIUM_ARMOR_MATERIAL,
                    ArmorType.CHESTPLATE,
                    props));
    public static final DeferredItem<ArmorItem> TESTIUM_LEGGINGS =
            ITEMS.registerItem("testium_leggings", props -> new ArmorItem(TESTIUM_ARMOR_MATERIAL,
                    ArmorType.LEGGINGS,
                    props));
    public static final DeferredItem<ArmorItem> TESTIUM_BOOTS =
            ITEMS.registerItem("testium_boots", props -> new ArmorItem(TESTIUM_ARMOR_MATERIAL,
                    ArmorType.BOOTS, props));

    /*
    public static final DeferredItem<AnimalArmorItem> TESTIUM_WOLF_ARMOR =
            ITEMS.registerItem("testium_wolf_armor", props -> new AnimalArmorItem(TESTIUM_ARMOR_MATERIAL,
                    AnimalArmorItem.BodyType.CANINE,
                    props
            )
    );
    public static final DeferredItem<AnimalArmorItem> TESTIUM_HORSE_ARMOR =
            ITEMS.registerItem("testium_horse_armor", props -> new AnimalArmorItem(TESTIUM_ARMOR_MATERIAL,
                    AnimalArmorItem.BodyType.EQUESTRIAN,
                    props));
*/



    //CUSTOM ITEMS
    public static final DeferredItem<Item> CHISEL = ITEMS.registerItem("chisel",
                    ChiselItem::new,
                    new Item.Properties()
                    .durability(192));

    public static final DeferredItem<Item> TESTER = ITEMS.registerItem("tester",
                    TesterItem::new,
                    new Item.Properties()
                    .durability(192));

    //FUEL ITEMS


    public static final DeferredItem<Item> RED_COAL = ITEMS.registerItem("red_coal",
            Item::new,
            new Item.Properties());

    //FOOD ITEMS

    public static final DeferredItem<Item> GREEN_BEEF = ITEMS.registerItem("green_beef",
            Item::new,
            new Item.Properties()
                    .food(ModFoodProperties.GREEN_BEEF, ModFoodProperties.GREEN_BEEF_CONSUMABLE)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation
                            .fromNamespaceAndPath("testiummod", "green_beef"))));
    public static final DeferredItem<Item> RAW_GREEN_BEEF = ITEMS.registerItem("raw_green_beef",
            Item::new,
            new Item.Properties()
                    .food(ModFoodProperties.RAW_GREEN_BEEF, ModFoodProperties.RAW_GREEN_BEEF_CONSUMABLE)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation
                            .fromNamespaceAndPath("testiummod", "raw_green_beef"))));


    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}
