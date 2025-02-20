package net.migueljb.testiumMod.item;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.item.custom.ChiselItem;
import net.migueljb.testiumMod.item.custom.FuelItem;
import net.migueljb.testiumMod.item.custom.TesterItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.List;

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
    /*
    public static final DeferredItem<Item> GREENIUM = ITEMS.registerItem("greenium",
            Item::new,
            new Item.Properties());
    public static final DeferredItem<Item> REDIUM = ITEMS.registerItem("redium",
            Item::new,
            new Item.Properties());
    */

    /*
    public static final RegistryObject<Item> TESTIUM = ITEMS.register("testium",
            () -> new Item(new Item.Properties().setId(ITEMS.key("testium"))));
    public static final RegistryObject<Item> TESTIUMG = ITEMS.register("testiumg",
            () -> new Item(new Item.Properties().setId(ITEMS.key("testiumg"))));
    public static final RegistryObject<Item> TESTIUMR = ITEMS.register("testiumr",
            () -> new Item(new Item.Properties().setId(ITEMS.key("testiumr"))));
    public static final RegistryObject<Item> GREENIUM = ITEMS.register("greenium",
            () -> new Item(new Item.Properties().setId(ITEMS.key("greenium"))));
    public static final RegistryObject<Item> REDIUM = ITEMS.register("redium",
            () -> new Item(new Item.Properties().setId(ITEMS.key("redium"))));
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
/*
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            ()-> new ChiselItem(new Item.Properties()
                    .durability(192).setId(ITEMS.key("chisel"))));

    public static final RegistryObject<Item> TESTER = ITEMS.register("tester",
            ()-> new TesterItem(new Item.Properties()
                    .durability(192).setId(ITEMS.key("tester"))));
    */
    //FUEL ITEMS

    /*
    public static final RegistryObject<Item> RED_COAL = ITEMS.register("red_coal",
            ()-> new FuelItem(new Item.Properties().setId(ITEMS.key("red_coal")), 20000){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.migueljbmodtest.red_coal"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    */
    //FOOD ITEMS

    public static final DeferredItem<Item> GREEN_BEEF = ITEMS.registerItem("green_beef",
            Item::new,
            new Item.Properties()
                    .food(ModFoodProperties.GREEN_BEEF, ModFoodProperties.GREEN_BEEF_CONSUMABLE)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation
                            .fromNamespaceAndPath("migueljbmodtest", "green_beef"))));
    public static final DeferredItem<Item> RAW_GREEN_BEEF = ITEMS.registerItem("raw_green_beef",
            Item::new,
            new Item.Properties()
                    .food(ModFoodProperties.RAW_GREEN_BEEF, ModFoodProperties.RAW_GREEN_BEEF_CONSUMABLE)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation
                            .fromNamespaceAndPath("migueljbmodtest", "raw_green_beef"))));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
