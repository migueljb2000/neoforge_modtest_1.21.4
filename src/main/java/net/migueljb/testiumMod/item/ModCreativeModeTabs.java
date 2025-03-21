package net.migueljb.testiumMod.item;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.lwjgl.system.windows.POINT;

import java.util.function.Supplier;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestiumMod.MOD_ID);

    public static final Supplier<CreativeModeTab> TESTIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "testium_items_tab", ()-> CreativeModeTab.builder().icon(
                            ()-> new ItemStack(ModItems.TESTIUM.get()))
                    .title(Component.translatable("creativetab.testiummod.testium_items"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        @Override
                        public void accept(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
                            pOutput.accept((ModItems.TESTIUM.get()));
                            pOutput.accept((ModItems.TESTIUMR.get()));
                            pOutput.accept((ModItems.TESTIUMG.get()));
                            pOutput.accept((ModItems.CHISEL).get());
                            pOutput.accept((ModItems.TESTER).get());
                            pOutput.accept((ModItems.GREEN_BEEF).get());
                            pOutput.accept((ModItems.RAW_GREEN_BEEF).get());
                            pOutput.accept((ModItems.RED_COAL).get());
                            pOutput.accept((ModItems.GREENIUM).get());
                            pOutput.accept((ModItems.REDIUM).get());
                            pOutput.accept((ModItems.TESTIUM_SWORD).get());
                            pOutput.accept((ModItems.TESTIUM_AXE).get());
                            pOutput.accept((ModItems.TESTIUM_PICKAXE).get());
                            pOutput.accept((ModItems.TESTIUM_HOE).get());
                            pOutput.accept((ModItems.TESTIUM_SHOVEL).get());
                            pOutput.accept((ModItems.TESTIUM_HAMMER).get());
                            pOutput.accept((ModItems.TESTIUM_HELMET).get());
                            pOutput.accept((ModItems.TESTIUM_CHESTPLATE).get());
                            pOutput.accept((ModItems.TESTIUM_LEGGINGS).get());
                            pOutput.accept((ModItems.TESTIUM_BOOTS).get());
                            pOutput.accept((ModItems.TESTIUM_HORSE_ARMOR).get());


                        }
                    }).build());


    public static final Supplier<CreativeModeTab> TESTIUM_BLOCKS_TAB = CREATIVE_MODE_TAB.register(
            "testium_blocks_tab", ()-> CreativeModeTab.builder().icon(
                            ()-> new ItemStack(ModBlocks.TESTIUMR_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestiumMod.MOD_ID, "testium_items_tab"))
                    .title(Component.translatable("creativetab.testiummod.testium_blocks"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        @Override
                        public void accept(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
                            pOutput.accept((ModBlocks.TESTIUMR_BLOCK.get()));
                            pOutput.accept((ModBlocks.TAINTER_BLOCK.get()));
                            pOutput.accept((ModBlocks.TAINTER_BLOCK.get()));
                            pOutput.accept((ModBlocks.GREENIUM_ORE_BLOCK.get()));
                            pOutput.accept((ModBlocks.REDIUM_ORE_BLOCK.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_BLOCK.get()));
                            //Non Blocks
                            //Slabs
                            pOutput.accept((ModBlocks.TESTIUMR_SLAB.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_SLAB.get()));
                            //Pressure Plates
                            pOutput.accept((ModBlocks.TESTIUMR_PRESSURE_PLATE.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_PRESSURE_PLATE.get()));
                            //Buttons
                            pOutput.accept((ModBlocks.TESTIUMR_BUTTON.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_BUTTON.get()));
                            //Stairs
                            pOutput.accept((ModBlocks.TESTIUMR_STAIRS.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_STAIRS.get()));
                            //Fences
                            pOutput.accept((ModBlocks.TESTIUMR_FENCE.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_FENCE.get()));
                            //Fence Gates
                            pOutput.accept((ModBlocks.TESTIUMR_FENCE_GATE.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_FENCE_GATE.get()));
                            //pOutput.accept((ModBlocks.TESTIUMR_WALL.get()));
                            //Doors
                            pOutput.accept((ModBlocks.TESTIUMR_DOOR.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_DOOR.get()));
                            //Trapdoors
                            pOutput.accept((ModBlocks.TESTIUMR_TRAPDOOR.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_TRAPDOOR.get()));
                            //pOutput.accept((ModBlocks.TESTIUMR_BUTTON));
                            //Walls
                            pOutput.accept((ModBlocks.TESTIUMR_WALL.get()));
                            pOutput.accept((ModBlocks.TESTIUMG_WALL.get()));
                            //LAMPS
                            pOutput.accept((ModBlocks.TESTIUM_LAMP.get()));

                        }
                    }).build());


    public static void  register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
