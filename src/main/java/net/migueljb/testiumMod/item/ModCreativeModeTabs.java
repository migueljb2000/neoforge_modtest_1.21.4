package net.migueljb.testiumMod.item;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestiumMod.MOD_ID);

    public static final Supplier<CreativeModeTab> TESTIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "testium_items_tab", ()-> CreativeModeTab.builder().icon(
                            ()-> new ItemStack(ModItems.TESTIUM.get()))
                    .title(Component.translatable("creativetab.migueljbmodtest.testium_items"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        @Override
                        public void accept(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
                            pOutput.accept((ModItems.TESTIUM.get()));
                            pOutput.accept((ModItems.TESTIUMR.get()));
                            pOutput.accept((ModItems.TESTIUMG.get()));
                            //pOutput.accept((ModItems.CHISEL).get());
                            //pOutput.accept((ModItems.TESTER).get());
                            //pOutput.accept((ModItems.GREEN_BEEF).get());
                            //pOutput.accept((ModItems.RAW_GREEN_BEEF).get());
                            //pOutput.accept((ModItems.RED_COAL).get());

                        }
                    }).build());


    public static final Supplier<CreativeModeTab> TESTIUM_BLOCKS_TAB = CREATIVE_MODE_TAB.register(
            "testium_blocks_tab", ()-> CreativeModeTab.builder().icon(
                            ()-> new ItemStack(ModBlocks.TESTIUMR_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestiumMod.MOD_ID, "testium_items_tab"))
                    .title(Component.translatable("creativetab.migueljbmodtest.testium_blocks"))
                    .displayItems(new CreativeModeTab.DisplayItemsGenerator() {
                        @Override
                        public void accept(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
                            pOutput.accept((ModBlocks.TESTIUMR_BLOCK.get()));
                            //pOutput.accept((ModBlocks.TAINTER_BLOCK.get()));
                        }
                    }).build());


    public static void  register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
